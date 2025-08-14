Of course\! The **Flyweight** design pattern is a structural pattern focused on minimizing memory usage by sharing as much data as possible with other similar objects. It's great for situations where you need to create a huge number of objects that have some shared, unchanging data.

The pattern achieves this by separating an object's state into two parts:

* **Intrinsic State**: This is the data that is constant and shared among many objects. It's stored inside the flyweight object.
* **Extrinsic State**: This is the data that is unique to each object and depends on the context. It's passed to the flyweight object's methods by the client.

Think of it like letters in a document. Instead of creating a unique object for every single 'a' in this text, the font rendering engine uses a single 'a' object (the flyweight) and just tells it *where* to draw itself (the extrinsic state: x, y coordinates).

-----

## Java Example: Drawing Shapes 🎨

Let's imagine an application that needs to draw thousands of circles of different colors and at different positions. The color is an intrinsic property (a red circle is always red), while the position and size are extrinsic.

### 1\. The Flyweight Interface

First, we define a common interface for our objects. The `draw` method accepts the extrinsic state.

```java
// Flyweight interface
public interface Shape {
    void draw(int x, int y, int radius);
}
```

### 2\. The Concrete Flyweight

This class implements the interface and stores the intrinsic state. Here, the `color` is intrinsic because we'll share circle objects based on their color.

```java
// ConcreteFlyweight
public class Circle implements Shape {
    private final String color; // Intrinsic state

    public Circle(String color) {
        this.color = color;
        System.out.println("Creating a " + color + " circle."); // To show when a new object is made
    }

    @Override
    public void draw(int x, int y, int radius) { // Extrinsic state is passed here
        System.out.println("Drawing a " + color + " circle at (" + x + ", " + y + ") with radius " + radius);
    }
}
```

### 3\. The Flyweight Factory

This factory is the key. It creates and manages the flyweight objects, ensuring that we only have one instance for each type of shared state (e.g., one for "Red", one for "Blue", etc.). It uses a `HashMap` to store and retrieve the shared objects.

```java
import java.util.HashMap;
import java.util.Map;

// FlyweightFactory
public class ShapeFactory {
    private static final Map<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        // Check if a circle of this color already exists
        Circle circle = (Circle) circleMap.get(color);

        // If not, create it and add it to the map
        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
        }
        return circle;
    }
}
```

### 4\. The Client

Finally, the client code uses the factory to get flyweight objects instead of creating them directly. Notice that "Creating..." is printed only once for each color, even though we are "drawing" many circles.

```java
public class FlyweightDemo {
    private static final String[] colors = {"Red", "Green", "Blue", "Yellow", "Black"};

    public static void main(String[] args) {
        System.out.println("--- Drawing 20 Circles ---");
        for (int i = 0; i < 20; ++i) {
            // Get a shared circle object from the factory
            Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
            
            // Pass the unique, extrinsic state to the draw method
            circle.draw(getRandomX(), getRandomY(), 100);
        }
    }

    private static String getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    private static int getRandomX() {
        return (int) (Math.random() * 100);
    }

    private static int getRandomY() {
        return (int) (Math.random() * 100);
    }
}
```

### Output

When you run this, you'll see something like this:

```
--- Drawing 20 Circles ---
Creating a Yellow circle.
Drawing a Yellow circle at (8, 77) with radius 100
Creating a Red circle.
Drawing a Red circle at (45, 12) with radius 100
Creating a Black circle.
Drawing a Black circle at (98, 3) with radius 100
Drawing a Yellow circle at (23, 56) with radius 100
Creating a Green circle.
Drawing a Green circle at (1, 89) with radius 100
Creating a Blue circle.
Drawing a Blue circle at (4, 42) with radius 100
Drawing a Red circle at (67, 21) with radius 100
... (and so on for 20 draws, but only 5 creations)
```

As you can see, even though 20 circles are drawn, only 5 `Circle` objects (one for each color) are actually created and stored in memory. The rest are reused, saving a significant amount of memory. ✨