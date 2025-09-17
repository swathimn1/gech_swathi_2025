package springbootdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootDataJpa1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringBootDataJpa1Application.class, args);
		SpringData Bean = run.getBean(SpringData.class);
//		Bean.addStudent();
//		Bean.getStudent();
		Bean.findAll();
		Bean.findById();
		Bean.existsById();
		Bean.deleteById();
		Bean.deleteAll();
		Bean.deleAllStudents();
	}

}
