public class Circle implements Shape {
    private final String color;

    public Circle(String color) {

        this.color = color;
        System.out.println("Creating a " + this.color + " circle.");
    }

    @Override
    public void draw(int x, int y, int radius) {

        System.out.println("Drawing a " + this.color + " circle at (" + x + ", " + y + ") with radius " + radius);
    }
}
