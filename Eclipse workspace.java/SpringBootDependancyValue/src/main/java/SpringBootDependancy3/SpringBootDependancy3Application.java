package SpringBootDependancy3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootDependancy3Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringBootDependancy3Application.class, args);

		Student std = run.getBean(Student.class);
		System.out.println("Student:" + std);
		System.out.println("Name:" + std.name);
		System.out.println("Age:" + std.age);
		System.out.println("Address:" + std.address.Pincode + " " + std.address.State);
		System.out.println("Skills:" + std.skills);
		System.out.println("Marks:" + std.marks);
//		Address adress = (Address) run.getBean("address");
//		System.out.println("Address:" + adress);
		
		Student1 st=run.getBean(Student1.class);
		System.out.println("Student1:"+st);
		System.out.println("Name:"+st.getName());
		System.out.println("age:"+st.getAge());

	}

}
