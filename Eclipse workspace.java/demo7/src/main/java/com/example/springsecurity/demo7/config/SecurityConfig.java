
package com.example.springsecurity.demo7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.springsecurity.demo7.repository.StudentRepository;
import com.example.springsecurity.demo7.service.StudentDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private StudentRepository studentRepository;
	
	
	public SecurityConfig(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new StudentDetailsService(studentRepository);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(auth ->
						auth.requestMatchers("/","/register").permitAll()
						.anyRequest().authenticated())
				.formLogin(login ->
						login.loginPage("/login")
						.loginProcessingUrl("/login")
						.defaultSuccessUrl("/about",true).permitAll()
						)
				.logout(logout  -> logout
						.logoutSuccessUrl("/login?logout").permitAll())
				.build();
	}
	
	@Bean
	public DaoAuthenticationProvider provider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(); 
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(userDetailsService());
		return daoAuthenticationProvider;
	}
}
