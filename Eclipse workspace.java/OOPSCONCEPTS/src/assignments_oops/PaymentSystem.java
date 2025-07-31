package assignments_oops;

interface Payment {
	public void pay(double amount);
}

class CardPayment implements Payment {

	@Override
	public void pay(double amount) {
		System.out.println("we are paying amount using card");
	}

}

class UPIPayment implements Payment {

	@Override
	public void pay(double amount) {
		System.out.println("we are paying using UPI");
	}

}

public class PaymentSystem {

	public static void main(String[] args) {
		Payment payment = new CardPayment();
		payment.pay(1000.00);
		Payment payment1 = new UPIPayment();
		payment1.pay(500);

	}

}
