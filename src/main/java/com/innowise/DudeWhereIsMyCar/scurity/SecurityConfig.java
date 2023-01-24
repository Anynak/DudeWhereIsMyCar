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
                .csrf().disable().cors().disable()
                .authorizeHttpRequests()
                .requestMatchers(
                         "//swagger-ui.html", "/v3/api-docs/**", "/v3/api-docs.yaml").permitAll()
                .requestMatchers(
                        "/api/setVehicleBrands"
                        , "/api/deleteVehicleBrand"
                        , "/api/setVehicleModels"
                        , "/api/deleteVehicleModel"
                        , "/api/user/*"
                        //, "/api/user/**"
                ).hasAuthority("ADMIN")
                //.anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .logout().logoutSuccessUrl("/")
                .and()
                .httpBasic();
        return httpSecurity.build();
    }
}
