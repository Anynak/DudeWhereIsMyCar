package com.innowise.DudeWhereIsMyCar.scurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/register", "/logout", "/login").permitAll()
                .requestMatchers("/api/setVehicleBrands", "/api/deleteVehicleBrand", "/api/setVehicleModels", "/api/deleteVehicleModel").hasRole("ROLE_ADMIN")
                .anyRequest().authenticated()
                .and()
                .logout().logoutSuccessUrl("/")
                .and()
                .httpBasic()
        ;
        return httpSecurity.build();
    }
}