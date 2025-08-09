public class File implements FileSystemItem {
    private String name;

    public File(String name) {

        this.name = name;
    }

    @Override
    public void printName() {

        System.out.println("File: " + this.name);
    }
}
