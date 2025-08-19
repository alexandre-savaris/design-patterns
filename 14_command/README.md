Of course\! Here's a gist of the **Command** design pattern, including a simple Java example.

The Command pattern turns a request into a stand-alone object that contains all information about the request. This lets you parameterize methods with different requests, delay or queue a request's execution, and support undoable operations.

Think of it like ordering food at a restaurant レストラン.

* You (the **Client**) create an order (the **Command**).
* You give the order to the waiter (the **Invoker**).
* The waiter takes the order to the kitchen and puts it on the order queue. The waiter doesn't know how to cook the food.
* The chef (the **Receiver**) picks up the order and knows exactly how to cook the meal requested.

This decouples you (who requests the meal) from the chef (who knows how to prepare it).

### Key Components

* **Command**: An interface with a single method, typically `execute()`.
* **Concrete Command**: Implements the `Command` interface. It holds an instance of the Receiver and calls the appropriate action on it.
* **Receiver**: The object that knows how to perform the actual work.
* **Invoker**: The object that holds a `Command` and asks it to execute the request. It is completely decoupled from the Receiver.
* **Client**: The application that creates the Receiver, Command, and Invoker, and wires them all together.

-----

### Java Example: A Simple Light Switch 💡

Let's model a simple remote control that can turn a light on and off.

#### 1\. The Receiver

This is the `Light` class. It knows how to perform the actual operations: turning on and off.

```java
// Receiver
public class Light {
    public void turnOn() {
        System.out.println("The light is ON");
    }

    public void turnOff() {
        System.out.println("The light is OFF");
    }
}
```

#### 2\. The Command Interface

This interface defines the single execution method that all commands will have.

```java
// Command Interface
public interface Command {
    void execute();
}
```

#### 3\. Concrete Commands

These classes implement the `Command` interface. They link a receiver (`Light`) with an action (`turnOn()` or `turnOff()`).

```java
// Concrete Command to turn the light on
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Concrete Command to turn the light off
public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
```

#### 4\. The Invoker

This is our `RemoteControl`. It holds a command and has a button. When the button is pressed, it calls `execute()` on whatever command it's holding, without needing to know what the command does or who the receiver is.

```java
// Invoker
public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
```

#### 5\. The Client

Finally, the `Client` wires everything together.

```java
// Client
public class Main {
    public static void main(String[] args) {
        // Receiver
        Light livingRoomLight = new Light();

        // Concrete Commands, linking the receiver to an action
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // Invoker
        RemoteControl remote = new RemoteControl();

        // --- Use the remote to turn the light on ---
        remote.setCommand(lightOn);
        System.out.print("Pressing button... ");
        remote.pressButton(); // Output: The light is ON

        // --- Use the remote to turn the light off ---
        remote.setCommand(lightOff);
        System.out.print("Pressing button... ");
        remote.pressButton(); // Output: The light is OFF
    }
}
```

The key benefit here is that the `RemoteControl` isn't tied to the `Light`. You could easily create new commands for other devices (like `StereoOnCommand` or `GarageDoorOpenCommand`) and the `RemoteControl` would work with them without any changes.