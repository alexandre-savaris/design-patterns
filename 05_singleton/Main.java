public class Main {

    public static void main(String[] args) {

        AppConfig config1 = AppConfig.getInstance();
        AppConfig config2 = AppConfig.getInstance();

        System.out.println("Server URL: " + config1.getServerUrl());
        System.out.println("Are both instances the same? " + (config1 == config2));
    }
}
