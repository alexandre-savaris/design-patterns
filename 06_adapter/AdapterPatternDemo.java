public class AdapterPatternDemo {

    public static void main(String[] args) {

        MainPlayer mainPlayer = new MainPlayer();
        mainPlayer.play("mp3", "beyond_the_horizon.mp3");
        mainPlayer.play("mp4", "alone.mp4");
        mainPlayer.play("vlc", "far_far_away.vlc");
        mainPlayer.play("avi", "mind_me.avi");
    }
}
