import java.util.Stack;

public class History {
    private final Stack<Editor.EditorState> states = new Stack<>();

    public void push(Editor.EditorState state) {

        this.states.push(state);
    }

    public Editor.EditorState pop() {

        return this.states.isEmpty() ? null : this.states.pop();
    }
}
