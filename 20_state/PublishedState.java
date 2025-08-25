public class PublishedState implements DocumentState {

    @Override
    public void publish(Document document) {

        System.out.println("The document is already published.");
    }

    @Override
    public void approve(Document document) {

        System.out.println("The document has already been approved and published.");
    }
}
