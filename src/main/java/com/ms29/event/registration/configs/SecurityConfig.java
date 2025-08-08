package com.ms29.event.registration.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
            .requestMatchers("/auth/**", "/css/**", "/js/**", "/").permitAll()
            .anyRequest().authenticated()
        ).formLogin(form -> form
            .loginPage("/auth/login")
            .loginProcessingUrl("/auth/login")
            .defaultSuccessUrl("/event/list", true)
            .failureUrl("/auth/login?error=true")
            .permitAll()
        ).logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/auth/login?logout=true")
            .permitAll()
        ).csrf(AbstractHttpConfigurer::disable); // Disable CSRF for simplicity

        return http.build();
    }
}
