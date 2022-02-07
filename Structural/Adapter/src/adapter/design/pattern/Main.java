package adapter.design.pattern;

public class Main {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "Abc");
        audioPlayer.play("mp4", "123");
        audioPlayer.play("vlc", "smth");
        audioPlayer.play("aaa", "bbb");
    }
}
