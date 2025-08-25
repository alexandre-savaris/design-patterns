public class Document {
    private DocumentState state;

    public Document() {

        this.state = new DraftState();
        System.out.println("New document created. Current state: Draft");
    }

    public void changeState(DocumentState newState) {

        this.state = newState;
    }

    public void publish() {

        this.state.publish(this);
    }

    public void approve() {

        this.state.approve(this);
    }
}
