public class Demo {

    public static void main(String[] args) {

        NewsAgency agency = new NewsAgency();

        Observer channel1 = new NewsChannel("CNN");
        Observer channel2 = new NewsChannel("BBC News");
        Observer channel3 = new NewsChannel("Fox News");

        agency.registerObserver(channel1);
        agency.registerObserver(channel2);
        agency.registerObserver(channel2);

        agency.setNews("Major tech company announces a breakthrough in AI!");

        System.out.println("\n--- BBC News is unsubscribing ---");

        agency.removeObserver(channel2);

        agency.setNews("Global stock markets react to the new technology.");
    }
}
