import java.util.Hashtable;

public class ShapeCache {
    private static Hashtable<String, Shape> shapeMap = new Hashtable<>();

    public static void loadInitialCache() {

        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");
        shapeMap.put(rectangle.getId(), rectangle);
    }

    public static Shape getShape(String shapeId) {

        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }
}
