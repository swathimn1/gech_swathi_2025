package SpringBootFirstWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootFirstWebApp1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringBootFirstWebApp1Application.class, args);
		Object bean = run.getBean("customer1");
		Customer c1 = (Customer) bean;
		System.out.println(c1);
		System.out.println(c1.name);
		System.out.println(c1.age);

		Customer customer2 = (Customer) run.getBean("customer2");
		System.out.println(customer2);
		System.out.println(customer2.name);
		System.out.println(customer2.age);

		Customer customer3 = (Customer) run.getBean("customer2");
		System.out.println(customer3);
		System.out.println(customer3.name);
		System.out.println(customer3.age);

//		Customer bean2 = run.getBean(Customer.class); // if ioc contains only one bean per particular class
//		//this customer class contains 3 objects but using this method,we can call only one object ,so it will create an ambiguity like which object to call ,
//		//so it will throw an NoUniqueBeanDefinitionException
//		System.out.println(bean2);

		Car car = (Car) run.getBean("car1");
		System.out.println(car);
		System.out.println(car.name);
		System.out.println(car.model);
		System.out.println(car.no_w);
	}

}
