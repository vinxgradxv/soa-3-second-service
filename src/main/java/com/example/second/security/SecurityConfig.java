package com.example.second.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of(
                "http://localhost:3000",
                "http://localhost:3001",
                "https://127.0.0.1:8543/springmvc",
                "https://127.0.0.1:8543",
                "https://localhost:1112",
                "http://localhost:1112",
                "https://se.ifmo.ru/~s335045/.next/server/app/",
                "https://se.ifmo.ru",
                "https://localhost",
                "https://localhost:443"
        ));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
        configuration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors(httpSecurityCorsConfigurer ->
            httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource()));
        http
            .authorizeHttpRequests(authorize ->
                    authorize
                            .anyRequest().permitAll()
            )
            .csrf(csrf -> csrf.disable());


        return http.build();
    }
}
