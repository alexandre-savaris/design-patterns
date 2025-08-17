public class CEO extends Approver {

    @Override
    public void processRequest(Document document) {

        if (document.getType().equals("Resignation")) {
            System.out.println("CEO approved the Resignation request: " + document.getContent());
        } else {
            System.out.println("CEO is handling: " + document.getContent());
        }
    }
}
