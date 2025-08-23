public class Editor {
    private String content;

    public EditorState save() {

        return new EditorState(this.content);
    }

    public void restore(EditorState state) {

        this.content = state.getContent();
    }

    public String getContent() {

        return this.content;
    }

    public void setContent(String content) {

        this.content = content;
    }

    public static class EditorState {
        private final String content;

        private EditorState(String content) {

            this.content = content;
        }

        private String getContent() {

            return content;
        }
    }
}
