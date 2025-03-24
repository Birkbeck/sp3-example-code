package observer;

// This interface handles adding, deleting and updating
// all observers

public interface Subject {

    void register(Observer o);

    void unregister(Observer o);

    void notifyObserver();

}