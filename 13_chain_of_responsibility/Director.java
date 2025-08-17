public class Director extends Approver {

    @Override
    public void processRequest(Document document) {

        if (document.getType().equals("Budget")) {
            System.out.println("Director approved the Budget request: " + document.getContent());
        } else if (this.nextApprover != null) {
            System.out.println("Director can't handle this. Passing to CEO.");
            this.nextApprover.processRequest(document);
        }
    }
}
