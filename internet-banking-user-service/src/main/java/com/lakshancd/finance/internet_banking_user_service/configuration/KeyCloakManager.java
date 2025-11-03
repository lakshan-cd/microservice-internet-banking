package com.lakshancd.finance.internet_banking_user_service.configuration;

import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.resource.RealmResource;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KeyCloakManager {
    private final KeycloakProperties keycloakProperties;

    public RealmResource getKeyCloakInstanceWithRealm(){
        return keycloakProperties.getKeycloakInstance().realm(keycloakProperties.getRealm());
    }
}
