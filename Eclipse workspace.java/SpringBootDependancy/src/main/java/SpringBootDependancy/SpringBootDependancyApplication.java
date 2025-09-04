package SpringBootDependancy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootDependancyApplication {

	private final Employee employee;

	SpringBootDependancyApplication(Employee employee) {
		this.employee = employee;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringBootDependancyApplication.class, args);
		Employee emp = (Employee) run.getBean("employee");
		System.out.println("Employee:" + emp);
		System.out.println("From Employee:" + emp.AddressOne);

		Address address = (Address) run.getBean("address");
		System.out.println("First Address :" + address);
		Address address1 = (Address) run.getBean("address1");
		System.out.println("Second Address :" + address1);
		Address address2 = (Address) run.getBean("address2");
		System.out.println("Third Address :" + address2);

	}

}
