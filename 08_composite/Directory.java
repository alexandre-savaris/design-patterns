import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemItem {
    private String name;
    private List<FileSystemItem> items = new ArrayList<>();

    public Directory(String name) {

        this.name = name;
    }

    public void add(FileSystemItem item) {

        this.items.add(item);
    }

    public void remove(FileSystemItem item) {

        this.items.remove(item);
    }

    @Override
    public void printName() {

        System.out.println("Directory: " + this.name);
        for (FileSystemItem item : this.items) {
            item.printName();
        }
    }
}
