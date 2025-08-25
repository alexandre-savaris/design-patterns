public class Main {

    public static void main(String[] args) {
        Document myDoc = new Document();

        myDoc.approve();
        myDoc.publish();
        myDoc.publish();
        myDoc.approve();
        myDoc.approve();
    }
}
