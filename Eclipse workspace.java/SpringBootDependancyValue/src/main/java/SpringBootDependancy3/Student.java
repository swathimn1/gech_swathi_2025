package SpringBootDependancy3;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component

public class Student {
//@Value("swathi")
	@Value("${student.name}")
	public String name;
//@Value("21")
	@Value("${student.age}")
	public int age;
	@Autowired
	public Address address;

	@Value("${student.skills}")
	public List<String> skills;
	@Value("#{${student.marks}}")
	public Map<String, Integer> marks;

	public Student() {
		System.out.println("Student object created");
	}
}
