package model;

public class ThreadClass1 implements Runnable {
    public String tone;

    public ThreadClass1(String s) {
        tone = s;
    }

    @Override
    public void run() {
        MusicPlayer musicplayer = new MusicPlayer();
        musicplayer.playFile(tone);
    }
}
