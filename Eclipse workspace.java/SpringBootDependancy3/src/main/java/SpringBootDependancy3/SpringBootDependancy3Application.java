package SpringBootDependancy3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootDependancy3Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringBootDependancy3Application.class, args);
		SpringBootInterface bean = run.getBean(SpringBootInterface.class);
		bean.getPaymentService().paymentType();

		NetBankingPaymentService bean2 = run.getBean(NetBankingPaymentService.class);
		bean2.paymentType();
		CreditPaymentService bean3 = run.getBean(CreditPaymentService.class);
		bean3.paymentType();

	}

}
