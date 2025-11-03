package com.lakshancd.finance.core_banking_service.service;

import com.lakshancd.finance.core_banking_service.model.dto.User;
import com.lakshancd.finance.core_banking_service.model.entity.UserEntity;
import com.lakshancd.finance.core_banking_service.model.mapper.UserMapper;
import com.lakshancd.finance.core_banking_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper = new UserMapper();
    private final UserRepository userRepository;

    public User readUser(String identification){
        UserEntity userEntity = userRepository.findByIdentificationNumber(identification).get();
        return userMapper.convertToDto(userEntity);
    }

    public List<User> readUsers(Pageable pageable) {
        return userMapper.convertToDtoList(userRepository.findAll(pageable).getContent());
    }

}
