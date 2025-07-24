package com.example.DBRelationEmployee.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.DBRelationEmployee.repository.EmployeeRepository;
import com.example.DBRelationEmployee.service.CustomEmployeeDetailsService;



@Configuration
public class SecurityConfig {
	
	private final EmployeeRepository employeeRepository;
	private SuccessHandler handler;


	public SecurityConfig(EmployeeRepository employeeRepository, SuccessHandler handler) {
		super();
		this.employeeRepository = employeeRepository;
		this.handler = handler;
	}


	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    

	@Bean
	public UserDetailsService userDetailsService() {
	    return new CustomEmployeeDetailsService(employeeRepository);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.authorizeHttpRequests(auth -> auth
					.requestMatchers("/users/**","/roles/**","/admin").hasRole("ADMIN")
					.requestMatchers("/employees").hasRole("USERs")
					.requestMatchers("/login","/register","/","/about","/contact").permitAll()
					.anyRequest().authenticated()
				)
				.formLogin(login -> login
					.loginPage("/login")
					.loginProcessingUrl("/login")
					.successHandler(handler)
					.permitAll()
				)
				.exceptionHandling(exception -> exception.accessDeniedPage("/403"))
				.logout(logout -> logout
					.permitAll()
				)
				.build();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(userDetailsService());
		return provider;
	}
}
    
