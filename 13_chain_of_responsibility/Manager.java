public class Manager extends Approver {

    @Override
    public void processRequest(Document document) {

        if (document.getType().equals("Leave")) {
            System.out.println("Manager approved the Leave request: " + document.getContent());
        } else if (this.nextApprover != null) {
            System.out.println("Manager can't handle this. Passing to Director.");
            this.nextApprover.processRequest(document);
        }
    }
}
