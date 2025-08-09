public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {

        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void paintUI() {

        this.button.paint();
        this.checkbox.paint();
    }

    public static void main(String[] args) {
        String osName = System.getProperty("os.name").toLowerCase();
        GUIFactory factory;

        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }

        Application app = new Application(factory);
        app.paintUI();
    }
}
