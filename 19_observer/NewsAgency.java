import java.util.ArrayList;
import java.util.List;

public class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String news;

    public void setNews(String news) {

        this.news = news;
        System.out.println("\nNews Agency: Broadcasting new headline...");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {

        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {

        observers.remove(o);
    }

    @Override
    public void notifyObservers() {

        for (Observer observer : this.observers) {
            observer.update(this.news);
        }
    }
}
