# Adapter Pattern
An Adapter Pattern says that just "converts the interface of a class into another interface that a client wants".

In other words, to provide the interface according to client requirement while using the services of a class with a different interface.

The Adapter Pattern is also known as **Wrapper**.

## Example of Adapter Pattern

## Step 1: Create interfaces for Media Player and Advanced Media Player.

### MediaPlayer.java

```java
public interface MediaPlayer {
    void play(String audioType, String fileName);
}
```

### AdvancedMediaPlayer.java

```java
public interface AdvancedMediaPlayer {
    void playVlc(String fileName);
    void playMp4(String fileName);
}
```

## Step 2: Create concrete classes implementing the AdvancedMediaPlayer interface.

### Mp4Player.java

```java
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing Mp4 file. Name - " + fileName);
    }
}
```

### VlcPlayer.java

```java
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing Vlc file. Name - " + fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
```

## Step 3: Create adapter class implementing the MediaPlayer interface.

### MediaAdapter.java

```java
public class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
```

## Step 4: Create concrete class implementing the MediaPlayer interface.

### AudioPlayer.java

```java
public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file. Name: " + fileName);
        } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}
```

## Step 5: Use the AudioPlayer to play different types of audio formats.

### Main.java

```java
public class Main {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "Abc");
        audioPlayer.play("mp4", "123");
        audioPlayer.play("vlc", "smth");
        audioPlayer.play("aaa", "bbb");
    }
}
```

### Output:

```
Playing mp3 file. Name: Abc
Playing Mp4 file. Name - 123
Playing Vlc file. Name - smth
Invalid media. aaa format not supported
```
