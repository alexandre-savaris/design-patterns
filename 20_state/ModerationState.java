public class ModerationState implements DocumentState {

    @Override
    public void publish(Document document) {

        System.out.println("Document is already in moderation. Needs approval.");
    }

    @Override
    public void approve(Document document) {

        System.out.println("Approving the document. It is now published.");
        document.changeState(new PublishedState());
    }
}
