package SpringBootDependancy3;

import org.springframework.stereotype.Component;

@Component
public class NetBankingPaymentService implements PaymentService {
	NetBankingPaymentService() {
		System.out.println("NetBanking PaymentService object created");
	}

	@Override
	public void paymentType() {
		System.out.println("Netbanking Payment Service");

	}

}
