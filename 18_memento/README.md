Of course\! The **Memento** pattern is a behavioral design pattern that lets you save and restore the previous state of an object without revealing the details of its implementation. Think of it as a way to implement **checkpoints** or an **"undo"** feature.

Its main goal is to capture an object's internal state so it can be restored later, all while keeping the object's private data, well, private (preserving encapsulation).

-----

## Core Idea & Participants

The pattern involves three key participants working together:

1.  **Originator**: This is the object whose state needs to be saved. For example, a text editor with its current text. It knows how to create a "snapshot" of its state and how to restore its state from a snapshot.
2.  **Memento**: This is a simple object that acts as the "snapshot." It stores the state of the Originator. Crucially, it should protect its contents from being accessed or modified by any object other than the Originator that created it.
3.  **Caretaker**: This is the "history keeper." It holds onto the Mementos but never inspects or modifies them. It's like a list of save files; it knows which save is which, but it can't read what's inside. It just asks the Originator to save or load a state.

A great analogy is a **video game save system** 🎮:

* **Originator**: Your character in the game.
* **Memento**: The save file (capturing health, location, inventory, etc.).
* **Caretaker**: The game's load/save menu, which manages a list of save files.

-----

## Java Example: A Simple Text Editor

Here’s a practical example of an "undo" feature for a simple text editor.

### 1\. The Memento (`EditorState`)

This class holds the state. We make it a **static nested class** inside the `Editor` to ensure only the `Editor` can access its state, thus preserving encapsulation.

```java
// Originator
public class Editor {
    private String content;

    public EditorState save() {
        // Creates a new Memento with the current content.
        return new EditorState(this.content);
    }

    public void restore(EditorState state) {
        // Restores the editor's content from a Memento.
        this.content = state.getContent();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // --- Memento ---
    // A static nested class is often the best way to implement the Memento.
    // The Caretaker can hold it, but it cannot access its private fields.
    public static class EditorState {
        private final String content; // State is immutable

        private EditorState(String content) {
            this.content = content;
        }

        // Only the outer class (Editor) can access this private method.
        private String getContent() {
            return content;
        }
    }
}
```

### 2\. The Caretaker (`History`)

This class keeps a history of states but doesn't know anything about what's inside them. It just pushes and pops them from a stack.

```java
import java.util.Stack;

// Caretaker
public class History {
    // A stack is perfect for managing "undo" history.
    private final Stack<Editor.EditorState> states = new Stack<>();

    public void push(Editor.EditorState state) {
        states.push(state);
    }

    public Editor.EditorState pop() {
        // Avoids exceptions with an empty stack.
        return states.isEmpty() ? null : states.pop();
    }
}
```

### 3\. Putting It All Together

Here’s how the client code would use these classes to perform an undo operation.

```java
public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        History history = new History();

        // Type some text
        editor.setContent("a");
        history.push(editor.save()); // Save state: "a"

        editor.setContent("b");
        history.push(editor.save()); // Save state: "b"

        editor.setContent("c");
        // We don't save the state "c"

        System.out.println("Current content: " + editor.getContent()); // Prints "c"

        // --- Perform an Undo ---
        editor.restore(history.pop()); // Pop "b" and restore it
        System.out.println("After first undo: " + editor.getContent()); // Prints "b"

        // --- Perform another Undo ---
        editor.restore(history.pop()); // Pop "a" and restore it
        System.out.println("After second undo: " + editor.getContent()); // Prints "a"
    }
}
```

### Output

```
Current content: c
After first undo: b
After second undo: a
```