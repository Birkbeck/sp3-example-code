package behavioural.statealt;

//Context
public class MP3PlayerContext {
    private State state;

    private MP3PlayerContext(State state) {
        this.state = state;
    }

    public void play() {
        state.pressPlay(this);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}