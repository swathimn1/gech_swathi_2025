package SpringBootFirstWebApp.hello;

import org.springframework.stereotype.Component;

@Component
public class Student {
	String name;

	public Student() {
		System.out.println("student object created");
	}

}
