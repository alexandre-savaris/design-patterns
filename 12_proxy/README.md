Of course\! Here's a gist of the Proxy design pattern with a Java example.

The **Proxy** design pattern provides a surrogate or placeholder for another object to control access to it. It's like having a representative who can handle requests for you. This is useful for adding a layer of control, such as checking permissions, caching data, or delaying the creation of a resource-intensive object until it's actually needed.

### Core Idea & Analogy

Think of a **credit card** as a proxy for your **bank account**. Instead of carrying around a large amount of cash (the "real object"), you use the card (the "proxy"). The card provides the same interface for making payments but adds a layer of security (like a PIN) and convenience. It controls access to your money.

The main participants are:

* **Subject**: An interface that both the real object and the proxy implement. This lets the client treat the proxy just like the real object.
* **Real Subject**: The actual object that the proxy represents. This is the object that has the core functionality but might be expensive to create or needs controlled access.
* **Proxy**: The object that controls access to the Real Subject. It can add functionality before or after delegating the request to the real object.

-----

### Java Example: Virtual Proxy

A **virtual proxy** is used to delay the creation of a resource-intensive object until it's truly required. In this example, we'll create a proxy for loading a high-resolution image from a disk, which is a slow operation.

#### 1\. The Subject Interface

First, we define a common interface that both the real image and the proxy will use.

```java
// Subject Interface
public interface Image {
    void display();
}
```

#### 2\. The Real Subject

This class represents the actual, resource-intensive object. It loads an image from the disk, which we'll simulate with a message and a delay.

```java
// Real Subject
public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk(); // This is the expensive operation
    }

    private void loadFromDisk() {
        System.out.println("Loading image: " + filename);
        // Simulate a time-consuming operation
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}
```

#### 3\. The Proxy

The `ProxyImage` class controls access to the `RealImage`. It holds a reference to the `RealImage` but only creates it the first time the `display()` method is called. On subsequent calls, it uses the already created object.

```java
// Proxy
public class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        // The RealImage is created only when display() is called for the first time
        if (realImage == null) {
            System.out.println("Proxy: Creating RealImage object now.");
            realImage = new RealImage(filename);
        }
        // Delegate the call to the real object
        realImage.display();
    }
}
```

#### 4\. The Client Code

The client code uses the `ProxyImage` without needing to know that it's a proxy. It interacts with it through the `Image` interface.

```java
// Client
public class Client {
    public static void main(String[] args) {
        // Create the proxy. The expensive RealImage object is not created yet.
        Image image = new ProxyImage("high-res-photo.jpg");

        System.out.println("--- First call to display() ---");
        // The RealImage is created and loaded only now.
        image.display();

        System.out.println("\n--- Second call to display() ---");
        // The RealImage is already loaded, so it just displays instantly.
        image.display();
    }
}
```

### Output

When you run the client, you'll see this output, demonstrating the lazy loading:

```
--- First call to display() ---
Proxy: Creating RealImage object now.
Loading image: high-res-photo.jpg
Displaying image: high-res-photo.jpg

--- Second call to display() ---
Displaying image: high-res-photo.jpg
```

As you can see, the "Loading image..." part only happens on the first call. The proxy successfully delayed the creation of the `RealImage` object. 🖼️