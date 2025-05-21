package com.springboot.preparation.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;


/*
WebSecurityConfigurerAdapter is deprecated and removed in spring 6.x so we need to use something else
*/
@Configuration
public class SecurityConfig  {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(authorize ->
                authorize.requestMatchers("/actuator/health", "/actuator/info","/actuator/prometheus","/actuator/metrics")
                        .permitAll()
//                        .requestMatchers("/actuator/metrics").hasRole("AdminMetric")
                        .anyRequest()
                        .authenticated())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
