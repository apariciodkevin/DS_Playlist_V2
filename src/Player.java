// Java program to play an Audio
// file using Clip Object
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Player {

    // to store current position
    Long currentFrame;
    Clip clip;

    // current status of clip
    String status = "stopped";

    AudioInputStream audioInputStream;

    // Method to play the audio
    public void play(String filePath){
        // step 1: stop previous clip if any
        if (clip != null) {
            clip.stop();
            clip.close();
        }

        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            status = "play";
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Error playing file: " + e.getMessage());
        }

    }

    // Method to pause the audio
    public void pause() {
        if (clip == null) {
            return;
        }
        if (status.equals("paused")){
            System.out.println("audio is already paused");
            return;
        }
        this.currentFrame = this.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }

    // Method to resume the audio
    public void resume() {
        if (status.equals("paused")){
            clip.setMicrosecondPosition(currentFrame);
            clip.start();
            status = "play";
        }

    }

    // Method to stop the audio
    public void stop() {
        if (clip != null){
            currentFrame = 0L;
            clip.stop();
            clip.close();
            status = "stopped";
        }
    }

}