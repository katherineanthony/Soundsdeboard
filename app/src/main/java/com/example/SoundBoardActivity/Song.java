package com.example.SoundBoardActivity;

import android.media.SoundPool;

public class Song {
    private int[] notes;
    private int[] delay;
    private SoundPool soundPool;
    private int aNote;
    private int bNote;
    private int bflatNote;
    private int cNote;
    private int csharpNote;
    private int dNote;
    private int dsharpNote;
    private int eNote;
    private int fNote;
    private int fsharpNote;
    private int gNote;
    private int gsharpNote;


    public Song(int[] n, int[] d)
    {
        notes = n;
        delay = n;
    }

    public int getDelay(int space)
    {
        return delay[space];
    }

    public int[] getDelay() {
        return delay;
    }

    public void setDelay(int[] delay) {
        this.delay = delay;
    }

    public void setNotes(int n)
    {
        int x = notes.length;
        notes[x] = n;
    }

    public int[] getNotes()
    {
        return notes;
    }

    public int getNotes(int number) {
        return notes[number];
    }
}
