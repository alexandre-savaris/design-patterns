public class DraftState implements DocumentState {

    @Override
    public void publish(Document document) {

        System.out.println("Moving the document to moderation...");
        document.changeState(new ModerationState());
    }

    @Override
    public void approve(Document document) {

        System.out.println("Cannot approve a draft directly.");
    }
}
