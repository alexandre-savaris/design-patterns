public class BridgePatternDemo {

    public static void main(String[] args) {

        Shape redCircle = new Circle(new RedColor());
        Shape blueCircle = new Circle(new BlueColor());

        System.out.println(redCircle.draw());
        System.out.println(blueCircle.draw());
    }
}
