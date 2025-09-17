package studentcrud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserConfig {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user1 = User.withUsername("swathi").password(passwordEncoder().encode("Swathi@123")).roles("ADMIN")
				.build();
		UserDetails user2 = User.withUsername("varshi").password(passwordEncoder().encode("Varshi@123")).roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user1, user2);
	}

}
