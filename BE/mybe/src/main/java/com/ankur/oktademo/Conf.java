package com.ankur.oktademo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class Conf {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/open").permitAll()
                        .anyRequest().authenticated()
                ).cors(withDefaults())
                .oauth2ResourceServer(o-> o.jwt(withDefaults()));
        return http.build();
    }
}
