package com.lakshancd.finance.internet_banking_api_gateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        return http
                // Disable CSRF for stateless APIs
                .csrf(ServerHttpSecurity.CsrfSpec::disable)

                // Authorization rules
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/user/api/v1/register").permitAll()
                        .anyExchange().authenticated()
                )

                // Enable OAuth2 login (Keycloak)
                .oauth2Login(Customizer.withDefaults())

                // Enable JWT-based resource server
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))

                // Build the filter chain
                .build();
    }
}
