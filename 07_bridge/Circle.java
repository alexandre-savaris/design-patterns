public class Circle extends Shape {

    public Circle(Color color) {

        super(color);
    }

    @Override
    public String draw() {

        return "Drawing a Circle in " + color.applyColor() + " color.";
    }
}
