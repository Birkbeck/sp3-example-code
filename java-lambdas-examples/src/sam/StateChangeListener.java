package sam;

public interface StateChangeListener {

    void onStateChange(State oldState, State newState);

}