package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import java.io.IOException;

@Configuration
@EnableMethodSecurity(
        prePostEnabled = true
)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .formLogin(login ->
                        login.usernameParameter("AZERTYUIOP")
                                .passwordParameter("QSDFGHJKLM")
//                                .loginProcessingUrl("/log")
//                                .successForwardUrl("/hello")
                                //.loginPage("/superpagedelogin.html")
                )
//                .exceptionHandling(
//                        handler ->
//                                handler.authenticationEntryPoint(new Http403ForbiddenEntryPoint())
//                )
                .sessionManagement(session -> session.maximumSessions(1))
                //.httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers("/public").permitAll()
                                .requestMatchers("/user").hasRole("USER")
                                .requestMatchers("/admin").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails u = User.builder()
                .username("user")
                .password(encoder().encode("u"))
                .roles("USER")
                .build();
        UserDetails a = User.builder()
                .username("admin")
                .password(encoder().encode("a"))
                .roles("ADMIN", "USER")
                .build();

        return new InMemoryUserDetailsManager(u, a);
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
