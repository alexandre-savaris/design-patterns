public class Main {

    public static void main(String[] args) {

        File resume = new File("resume.pdf");
        File photo = new File("profile.jpg");

        Directory documents = new Directory("My Documents");
        documents.add(resume);

        Directory pictures = new Directory("My Pictures");
        pictures.add(photo);

        Directory root = new Directory("C Drive");
        root.add(documents);
        root.add(pictures);

        root.printName();
    }
}
