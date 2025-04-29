package com.DanielPons.AppTrip.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

   /* @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                // Configura las reglas de autorización
                .authorizeHttpRequests(auth -> auth
                        // Permite el acceso a /api/trips/** y /api/users/** sin autenticación
                        .requestMatchers("/auth/**").permitAll()
                        // Requiere autenticación para cualquier otro endpoint
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .build();


    }  Activar para seguridad */



    @Bean
    public SecurityFilterChain noSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                .build();
    }

}
