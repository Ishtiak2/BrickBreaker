package game;

import javax.sound.sampled.*;
import java.net.URL;

public class SoundPlayer {
    public static void playSound(String soundFileName) {
        try {
            URL url = SoundPlayer.class.getResource("/" + soundFileName);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
