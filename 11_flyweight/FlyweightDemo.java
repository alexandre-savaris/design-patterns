public class FlyweightDemo {
    private static final String[] colors = {"Red", "Green", "Blue", "Yellow", "Black"};

    public static void main(String[] args) {

        System.out.println("--- Drawing 20 circles ---");
        for (int i = 0; i < 20; i++) {
            Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.draw(getRandomX(), getRandomY(), 100);
        }
    }

    private static int getRandomX() {

        return (int) (Math.random() * 100);
    }

    private static int getRandomY() {

        return (int) (Math.random() * 100);
    }

    private static String getRandomColor() {

        return colors[(int) (Math.random() * colors.length)];
    }
}
