package behavioural.statealt;

public class PlayingState implements State {
    public void pressPlay(MP3PlayerContext context) {
        context.setState(new StandbyState());
    }
}