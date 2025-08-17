public class ApprovalSystem {

    public static void main(String[] args) {

        Approver manager = new Manager();
        Approver director = new Director();
        Approver ceo = new CEO();

        manager.setNextApprover(director);
        director.setNextApprover(ceo);

        System.out.println("--- Processing Leave Request ---");
        manager.processRequest(new Document("Leave", "Request for 2 days off."));

        System.out.println("\n--- Processing Budget Request ---");
        manager.processRequest(new Document("Budget", "Request for new project funding."));

        System.out.println("\n--- Processing Resignation Request ---");
        manager.processRequest(new Document("Resignation", "Letter of resignation."));
    }
}
