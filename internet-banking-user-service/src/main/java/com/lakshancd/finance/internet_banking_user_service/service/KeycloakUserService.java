package com.lakshancd.finance.internet_banking_user_service.service;

import com.lakshancd.finance.internet_banking_user_service.configuration.KeyCloakManager;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KeycloakUserService {
    private final KeyCloakManager keyCloakManager;

    public Integer createUser(UserRepresentation userRepresentation){
        Response response = keyCloakManager
                .getKeyCloakInstanceWithRealm()
                .users()
                .create(userRepresentation);

        return response.getStatus();
    }

    public void updateUser(UserRepresentation userRepresentation){
        keyCloakManager
                .getKeyCloakInstanceWithRealm()
                .users()
                .get(userRepresentation.getId())
                .update(userRepresentation);
    }

    public List<UserRepresentation> readUserByEmail(String email){
        return keyCloakManager
                .getKeyCloakInstanceWithRealm()
                .users()
                .search(email);
    }

    public UserRepresentation readUser (String authId){
        try {
            UserResource usersResource = keyCloakManager
                    .getKeyCloakInstanceWithRealm()
                    .users()
                    .get(authId);
            return usersResource.toRepresentation();
        } catch (Exception e){
            throw new RuntimeException("User not found under given id: " + authId);
        }
    }
}
