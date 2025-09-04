package SpringBootDependancy3;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class CreditPaymentService implements PaymentService {

	public CreditPaymentService() {
		System.out.println("NetBankingPaymentService1 object created");
	}

	@Override
	public void paymentType() {
		System.out.println("CreditPaymentService");

	}

}
