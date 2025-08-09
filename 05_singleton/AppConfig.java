public class AppConfig {
    private static volatile AppConfig instance;
    private String serverUrl;

    private AppConfig() {

        this.serverUrl = "http://api.example.com";
        System.out.println("AppConfig instance created.");
    }

    public static AppConfig getInstance() {

        if (instance == null) {
            synchronized (AppConfig.class) {
                if (instance == null) {
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }

    public String getServerUrl() {

        return this.serverUrl;
    }
}
