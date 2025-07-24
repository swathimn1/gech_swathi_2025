package com.example.dbrelationship.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.dbrelationship.service.CustomUserDetailsService;

@EnableWebSecurity
@Configuration
public class WebSecurity {

	private final CustomUserDetailsService employeeDetailsService;
	private final CustomSuccessAuthenticationHandler handler;

	public WebSecurity(CustomUserDetailsService employeeDetailsService, CustomSuccessAuthenticationHandler handler) {
		this.employeeDetailsService = employeeDetailsService;
		this.handler = handler;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(employeeDetailsService);
		return provider;
	}

	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder builder = http.getSharedObject(AuthenticationManagerBuilder.class);
		builder.authenticationProvider(authenticationProvider());
		return builder.build();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(auth -> auth.requestMatchers("/employees/**", "/roles/**", "/departments/**")
						.hasRole("ADMIN")
						.requestMatchers("/departments/**").hasAnyRole("ADMIN", "USER")

						.requestMatchers("/tasks/**").hasAnyRole("ADMIN", "USER")

						.requestMatchers("/login", "/register", "/css/**", "/js/**", "/images/**").permitAll()
						.anyRequest().authenticated())
				.formLogin(login -> login.loginPage("/login").loginProcessingUrl("/login").successHandler(handler)
						.permitAll())
				.exceptionHandling(exception -> exception.accessDeniedPage("/403"))
				.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login?logout").permitAll()).build();
	}

}
