package SpringBootDependancy3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SpringBootInterface {
	@Qualifier("creditPaymentService")
	@Autowired
	private PaymentService paymentService;

	public SpringBootInterface() {
		super();
		System.out.println("SpringBootInterface object created");
	}

	public PaymentService getPaymentService() {
		return paymentService;
	}

	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

}
