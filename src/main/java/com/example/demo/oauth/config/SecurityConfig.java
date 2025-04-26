package com.example.demo.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/login", "/css/**").permitAll()  // Public
                        .anyRequest().authenticated()  // Require login
                )
                .oauth2Login(oauth -> oauth
                        .loginPage("/login")  // Custom login page
                        .defaultSuccessUrl("/profile", true)  // Redirect after login
                );
        return http.build();
    }
}