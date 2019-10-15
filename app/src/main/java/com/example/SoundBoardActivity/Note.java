package com.example.SoundBoardActivity;

public class Note {

    private int soundId;
    private int delay;
    public Note(int soundId, int delay)
    {
        this.soundId = soundId;
        this.delay = soundId;
    }

    public int getDelay() {
        return delay;
    }
    public int getSoundId(){
        return soundId;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void setSoundId(int soundId) {
        this.soundId = soundId;
    }
}
