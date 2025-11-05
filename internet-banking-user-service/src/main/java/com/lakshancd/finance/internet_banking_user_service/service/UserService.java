package com.lakshancd.finance.internet_banking_user_service.service;

import com.lakshancd.finance.internet_banking_user_service.model.dto.User;
import com.lakshancd.finance.internet_banking_user_service.model.dto.UserUpdateRequest;
import com.lakshancd.finance.internet_banking_user_service.model.dto.user.UserResponse;
import com.lakshancd.finance.internet_banking_user_service.model.entity.UserEntity;
import com.lakshancd.finance.internet_banking_user_service.model.enums.Status;
import com.lakshancd.finance.internet_banking_user_service.model.mapper.UserMapper;
import com.lakshancd.finance.internet_banking_user_service.model.repository.UserRepository;
import com.lakshancd.finance.internet_banking_user_service.service.feignclinet.BankingCoreRestClient;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final KeycloakUserService keycloakUserService;
    private final UserRepository userRepository;
    private final BankingCoreRestClient bankingCoreRestClient;

    private final UserMapper userMapper = new UserMapper(); //manual instantiation dependency injection

    public User createUser(User user) {
        List<UserRepresentation> userRepresentations = keycloakUserService
                .readUserByEmail(user.getEmail());
        if (!userRepresentations.isEmpty()) {
            throw new RuntimeException("User already exists with email: " + user.getEmail());
        }

        //newly added part for communication with core banking service
        UserResponse userResponse =bankingCoreRestClient.readUser(user.getIdentification());
        if (userResponse.getId() !=null){
            if (!userResponse.getEmail().equals(user.getEmail())){
                throw new RuntimeException("Incorrect email. Please check and retry.");
            }
        }

        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setEmail(user.getEmail());
        userRepresentation.setEmailVerified(false);
        userRepresentation.setEnabled(false);
        userRepresentation.setUsername(user.getEmail());

        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setValue(user.getPassword());
        credentialRepresentation.setTemporary(false);

        userRepresentation.setCredentials(Collections.singletonList(credentialRepresentation));

        Integer userCreatedResponse = keycloakUserService.createUser(userRepresentation);
        if (userCreatedResponse == 201) {
            log.info("User created in Keycloak with username: {}", user.getEmail());

            List<UserRepresentation> userRepresentations1 =
                    keycloakUserService.readUserByEmail(user.getEmail());
            user.setAuthId(userRepresentations1.get(0).getId());
            user.setStatus(Status.PENDING);
            user.setIdentification(UUID.randomUUID().toString());
            user.setId(null); //ensure id is null for new entity creation

            UserEntity save = userRepository.save(userMapper.convertToEntity(user));
            return userMapper.convertToDto(save);
        }

        throw new RuntimeException("We couldn't find user under given identification. Please check and retry");
    }

    public List<User> readUsers (Pageable pageable){
        Page<UserEntity> allUsersInDb  = userRepository.findAll(pageable);
        List<User> users = userMapper.convertToDtoList(allUsersInDb.getContent());
        users.forEach(user -> {
            UserRepresentation userRepresentation = keycloakUserService.readUser(user.getAuthId());
            user.setId(user.getId());
            user.setEmail(userRepresentation.getEmail());
            user.setIdentification(user.getIdentification());
        });
        return users;
    }

    public User readUser(Long userId) {
        return userMapper.convertToDto(userRepository.findById(userId).orElseThrow(EntityNotFoundException::new));
    }

    public User updateUser(Long id , UserUpdateRequest userUpdateRequest){
       UserEntity userEntity = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
       if (userUpdateRequest.getStatus() == Status.APPROVED){
           UserRepresentation userRepresentation = keycloakUserService.readUser(userEntity.getAuthId());
           userRepresentation.setEnabled(true);
           userRepresentation.setEmailVerified(true);
           keycloakUserService.updateUser(userRepresentation);
       }
       userEntity.setStatus(userUpdateRequest.getStatus());
       return userMapper.convertToDto(userRepository.save(userEntity));
    }
}
