package com.example.SoundBoardActivity;

import android.media.SoundPool;

public class Song {
    private int[] notes;
    private int[] delay;
    private SoundPool soundPool;

    public Song(int[] n, int[] delay)
    {
        this.notes = n;
        this.delay = delay;

    }

    public int getDelay(int space)
    {
        return delay[space];
    }

    private void delay(int millisDelay) {
        try{
            Thread.sleep(millisDelay);}
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public int[] getDelay() {
        return delay;
    }

    public void setDelay(int[] delay) {
        this.delay = delay;
    }

    public int[] getNotes()
    {
        return notes;
    }

    public int getNotes(int number) {
        return notes[number];
    }

    /*
        public void setNotes(int[] notes) {
        this.notes = notes;
        }
        */

    public int play(int space){
        return notes[space];
    }
}
