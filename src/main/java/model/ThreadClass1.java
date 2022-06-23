package model;

public class ThreadClass1 implements Runnable {
    public String tone;

    public ThreadClass1(String s) {
        tone = s;
    }

    /**
     * @author: skimeswe
     * Erstellt einen neuen MusicPlayer und übergibt den Tone.
     */
    @Override
    public void run() {
        MusicPlayer musicplayer = new MusicPlayer();
        musicplayer.playFile(tone);
    }
}
