package com.example.schoolERP.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;



import java.io.IOException;

@Configuration
public class UserConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Implement your UserDetailsService to load user-specific data
        return new CustomUser DetailsService(); // Replace with your actual implementation
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUser DetailsService(userDetailsService());
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/about", "/contact", "/login", "/register").permitAll() // Public access
                .requestMatchers("/admin/**").hasRole("ADMIN") // Admin dashboard
                .requestMatchers("/faculty/**").hasRole("FACULTY") // Faculty dashboard
                .requestMatchers("/student/**").hasRole("STUDENT") // Student dashboard
                .anyRequest().authenticated() // All other requests require authentication
            )
            .formLogin(login -> login
                .loginPage("/login") // Custom login page
                .loginProcessingUrl("/login") // URL to process login
                .successHandler(customAuthenticationSuccessHandler()) // Custom success handler
                .permitAll() // Allow all to access login page
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout") // Redirect after logout
                .permitAll() // Allow all to logout
            );

        return http.build();
    }

    @Bean
    public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        return new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                Authentication authentication) throws IOException {
                String redirectUrl = "/"; // Default redirect URL

                // Check user roles and set redirect URL accordingly
                if (authentication.getAuthorities().stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"))) {
                    redirectUrl = "/admin/dashboard"; // Admin dashboard URL
                } else if (authentication.getAuthorities().stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_FACULTY"))) {
                    redirectUrl = "/faculty/dashboard"; // Faculty dashboard URL
                } else if (authentication.getAuthorities().stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_STUDENT"))) {
                    redirectUrl = "/student/dashboard"; // Student dashboard URL
                }

                response.sendRedirect(redirectUrl); // Redirect to the appropriate dashboard
            }
        };
    }
}
