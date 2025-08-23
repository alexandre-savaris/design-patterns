public class Demo {

    public static void main(String[] args) {
        Editor editor = new Editor();
        History history = new History();

        editor.setContent("a");
        history.push(editor.save());

        editor.setContent("b");
        history.push(editor.save());

        editor.setContent("c");

        System.out.println("Current content: " + editor.getContent());

        editor.restore(history.pop());
        System.out.println("Content after first UNDO: " + editor.getContent());

        editor.restore(history.pop());
        System.out.println("Content after second UNDO: " + editor.getContent());
    }
}
