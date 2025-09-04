package SpringBootDependancy3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {
	@Value("Karnataka")
	public String State;
	@Value("573102")
	public int Pincode;

	public Address() {
		System.out.println("Address object created ");
	}
}
