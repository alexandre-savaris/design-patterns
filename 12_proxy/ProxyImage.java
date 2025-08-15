public class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {

        this.filename = filename;
    }

    @Override
    public void display() {

        if (this.realImage == null) {
            System.out.println("Proxy: creating RealImage object now.");
            this.realImage = new RealImage(filename);
        }
        this.realImage.display();
    }
}
