public class Client {

    public static void main(String[] args) {

        Image image = new ProxyImage("high-res-photo.jpg");
        System.out.println("--- First call to display() ---");
        image.display();
        System.out.println("\n--- Second call to display() ---");
        image.display();
    }
}
