package model;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.FactoryRegistry;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MusicPlayer {
    private AdvancedPlayer player;

    public MusicPlayer() {
        player = null;
    }

    public void playFile(String filename) {
        try {
            preparePlayer(filename);
            player.play();
        } catch (JavaLayerException e) {
            System.out.println("Error");
        } finally {
            killPlayer();
        }
    }

    public void startPlaying(final String filename) {
        try {
            preparePlayer(filename);
            Thread playerThread = new Thread() {
                public void run() {
                    try {
                        player.play();
                    } catch (JavaLayerException e) {
                        System.out.println("Error");
                    } finally {
                        killPlayer();
                    }
                }
            };
            playerThread.start();
        } catch (Exception ex) {
            System.out.println("Error");
        }
    }

    public void stop() {
        killPlayer();
    }

    private void preparePlayer(String filename) {
        try {
            InputStream is = getInputStream(filename);
            player = new AdvancedPlayer(is, createAudioDevice());
        } catch (IOException | JavaLayerException e) {
            System.out.println("Error");
            killPlayer();
        }
    }

    private InputStream getInputStream(String filename)
            throws IOException {
        return new BufferedInputStream(
                new FileInputStream(filename));
    }

    private AudioDevice createAudioDevice()
            throws JavaLayerException {
        return FactoryRegistry.systemRegistry().createAudioDevice();
    }

    private void killPlayer() {
        synchronized (this) {
            if (player != null) {
                player.stop();
                player = null;
            }
        }
    }
}

