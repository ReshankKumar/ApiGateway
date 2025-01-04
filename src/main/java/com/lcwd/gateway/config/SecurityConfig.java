package com.lcwd.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {


    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        // Configure authorization for requests
            http
                    .authorizeExchange(custimizer->custimizer
                            .anyExchange().authenticated()).oauth2ResourceServer(auth->auth.jwt(Customizer.withDefaults()));
//                    .anyExchange().authenticated() // Enforce authentication for all requests

//                    .oauth2ResourceServer()
//                    .jwt(); // Configure OAuth2 resource server with JWT

            return http.build();
    }
}
