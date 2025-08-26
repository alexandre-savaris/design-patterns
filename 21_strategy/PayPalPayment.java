public class PayPalPayment implements PaymentStrategy {
    private final String emailId;

    public PayPalPayment(String emailId) {

        this.emailId = emailId;
    }

    @Override
    public void pay(int amount) {

        System.out.println(amount + " paid using PayPal.");
    }
}
