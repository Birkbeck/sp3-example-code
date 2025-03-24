package iterator;

public class RadioStation {

    public static void main(String[] args) {

        final SongsOfThe70s songs70s = new SongsOfThe70s();
        final SongsOfThe80s songs80s = new SongsOfThe80s();
        final SongsOfThe90s songs90s = new SongsOfThe90s();

        final DiscJockey madMike = new DiscJockey(songs70s, songs80s, songs90s);

        // madMike.showTheSongs();

        madMike.showTheSongs2();

    }

}