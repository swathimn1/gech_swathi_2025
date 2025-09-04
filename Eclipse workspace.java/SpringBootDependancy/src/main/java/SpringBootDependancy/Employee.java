package SpringBootDependancy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	public String name;
	@Qualifier("address2")
	@Autowired
	public Address AddressOne;

	public Employee() {
		System.out.println("Employee object created");
	}
}
