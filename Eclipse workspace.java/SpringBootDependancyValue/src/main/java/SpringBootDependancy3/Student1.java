package SpringBootDependancy3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student1 {
	private final String name;

	private final int age;

	@Autowired
	public void SetStudentDetails(@Value("${student.name}") String name, @Value("${student.age}") int age) {
		this.getName();
		this.getAge();
		System.out.println("Setter Injection: name=" + name + ", age=" + age);
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Student1(@Value("${student.name}") String name, @Value("${student.age}") int age) {
		this.name = name;
		this.age = age;
		System.out.println("Constructor Injection :name:" + name + ",age=" + age);

	}

}
