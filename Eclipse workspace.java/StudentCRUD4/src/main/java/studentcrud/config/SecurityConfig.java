package studentcrud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import studentcrud.repository.StudentRepository;
import studentcrud.service.CustomUserDetailsService;

@Configuration
public class SecurityConfig {
	private StudentRepository studentRepository;
	private CustomSuccessHandler customSuccessHandler;

	public SecurityConfig(StudentRepository studentRepository, CustomSuccessHandler customSuccessHandler) {
		super();
		this.studentRepository = studentRepository;
		this.customSuccessHandler = customSuccessHandler;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService(studentRepository);
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(userDetailsService());
		return provider;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(auth -> auth.requestMatchers("/student-dashboard").hasAnyRole("USER", "ADMIN")
						.requestMatchers("/admin").hasRole("ADMIN").requestMatchers("/", "/register").permitAll()
						.anyRequest().authenticated())
				.formLogin(login -> login.loginPage("/login").successHandler(customSuccessHandler).permitAll())
				.logout(logout -> logout.logoutSuccessUrl("/") // ✅ logout now goes to root
						.permitAll())
				.build();
	}
}
