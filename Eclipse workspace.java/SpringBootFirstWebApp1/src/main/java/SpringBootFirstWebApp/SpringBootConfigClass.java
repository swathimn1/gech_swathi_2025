package SpringBootFirstWebApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootConfigClass {
	@Bean("customer1")
	public Customer customer() {
		Customer c1 = new Customer();
		c1.name = "swathi";
		c1.age = 23;
		// return new Customer();
		return c1;
	}

	@Bean("customer2")
	// if we want an custom value for an object variables,we should go for an @Bean
	// method.
	public Customer customer2() {
		Customer c2 = new Customer();
		return c2;
	}

	@Bean // if we don't provide a Bean name,default value will be the name of the method
	public Customer customer3() {
		Customer c3 = new Customer();
		return c3;
	}

}
