public class Square extends Shape {

    public Square(Color color) {

        super(color);
    }

    @Override
    public String draw() {

        return "Drawing a Square in " + color.applyColor() + " color.";
    }
}
