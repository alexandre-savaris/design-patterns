public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {

        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {

        System.out.println("Loading image " + this.filename);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void display() {

        System.out.println("Displaying image " + this.filename);
    }
}
