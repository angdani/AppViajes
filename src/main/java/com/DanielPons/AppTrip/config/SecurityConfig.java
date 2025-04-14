package com.DanielPons.AppTrip.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Deshabilita CSRF (útil para APIs REST)
                .csrf(csrf -> csrf.disable())
                // Configura las reglas de autorización
                .authorizeHttpRequests(auth -> auth
                        // Permite el acceso a /api/trips/** y /api/users/** sin autenticación
                        .requestMatchers("/api/trips/**", "/api/users/**").permitAll()
                        // Requiere autenticación para cualquier otro endpoint
                        .anyRequest().authenticated()
                )
                // Si deseas habilitar autenticación básica o de formulario, agrega lo necesario aquí
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
