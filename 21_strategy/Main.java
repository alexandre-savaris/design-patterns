public class Main {

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        int amount = 150;

        PaymentStrategy creditCard = new CreditCardPayment("John Doe", "1234567890");
        shoppingCart.setPaymentStrategy(creditCard);
        shoppingCart.checkout(amount);

        PaymentStrategy payPal = new PayPalPayment("john@example.com");
        shoppingCart.setPaymentStrategy(payPal);
        shoppingCart.checkout(amount);
    }
}
