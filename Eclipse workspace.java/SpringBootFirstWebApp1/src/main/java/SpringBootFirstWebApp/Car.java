package SpringBootFirstWebApp;

import org.springframework.stereotype.Component;

@Component("car1") // if we don't provide a component name ,it will be defaultly provided as per
					// the class name
//if we want an default value for an object variables provided by jvm,we should go for a @Component
public class Car {
	String name;
	String model;
	int no_w;

	public Car() {
		System.out.println("Car object created");
	}
}
