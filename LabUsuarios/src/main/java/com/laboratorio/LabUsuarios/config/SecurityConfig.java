package com.laboratorio.LabUsuarios.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())        // Desactiva CSRF (útil para Postman)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()        // Permite todas las rutas
                )
                .formLogin(login -> login.disable()) // Desactiva login form
                .httpBasic(basic -> basic.disable()); // Desactiva autenticación básica

        return http.build();
    }
}
