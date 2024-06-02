package com.example.hotelbackend.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF for simplicity, configure as needed
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/auth/register", "/auth/login", "/admin/auth/register", "/admin/auth/login","/auth/users", "/auth/delete/{id}","/auth/put","/room/allrooms","/reservation/create","/room/register","/hotel/register","/room/delete/{id}").permitAll()  // Allow access to these endpoints
                        .anyRequest().authenticated()  // All other requests require authentication
                )
                .httpBasic(httpBasic -> {});  // Enable HTTP Basic authentication
        return http.build();
    }


}
