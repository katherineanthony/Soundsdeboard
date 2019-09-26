package com.example.SoundBoardActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.media.SoundPool.OnLoadCompleteListener;
import android.widget.Toast;
import android.widget.ViewAnimator;

import java.util.HashMap;
import java.util.Map;


public class SoundsActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonA;
    private Button buttonBflat;
    private Button buttonB;
    private Button buttonSong1;
    private Button buttonSong2;
    private Button buttonSong3;
    private int aNote;
    private int bNote;
    private int bflatNote;
    private int cNote;
    private int dNote;
    private int eNote;
    private int gNote;
    private Song stressInducingSong;
    private SoundPool soundPool;
    private boolean loaded;
    private Map<Integer,Integer> noteMap;
    int[] notes = new int[] {gNote, gNote, dNote, dNote, eNote, dNote};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sounds);
        wireWidgets();
        loaded = false;

        //stressInducingSong = new Song(new int[] {gNote, gNote,dNote,dNote,eNote,dNote}, new int[] {1000,1000,1000,1000,1000,2000});

        loadSoundPool();
        liamsuckssetListeners();
        //int[] notes = new int[] {gNote, gNote, dNote, dNote, eNote, dNote};
        stressInducingSong = new Song(notes, new int[] {1000,1000,1000,1000,1000,2000});
    }

    private void loadSoundPool() {
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        aNote = soundPool.load(this, R.raw.scalea,1);
        bNote = soundPool.load(this, R.raw.scaleb,1);
        bflatNote = soundPool.load(this, R.raw.scalebb,1);
        cNote = soundPool.load(this, R.raw.scalec,1);
        dNote = soundPool.load(this, R.raw.scaled,1);
        eNote = soundPool.load(this, R.raw.scalee,1);
        gNote = soundPool.load(this, R.raw.scaleg,1);
        loaded = true;

        noteMap = new HashMap<>();
        noteMap.put(buttonA.getId(), aNote);
        noteMap.put(buttonB.getId(), bNote);
        noteMap.put(buttonBflat.getId(), bNote);

    }


    private void liamsuckssetListeners() {
        KeyBoardListener keyBoardListener = new KeyBoardListener();
        buttonA.setOnClickListener(keyBoardListener);
        buttonB.setOnClickListener(keyBoardListener);
        buttonBflat.setOnClickListener(keyBoardListener);

        buttonSong1.setOnClickListener(this);
        buttonSong2.setOnClickListener(this);
        buttonSong3.setOnClickListener(this);
    }

    private void delay(int millisDelay) {
        try{
        Thread.sleep(millisDelay);}
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void wireWidgets() {
        buttonA=findViewById(R.id.button_main_a);
        buttonB=findViewById(R.id.button_main_b);
        buttonBflat=findViewById(R.id.button_main_bflat);
        buttonSong1 = findViewById(R.id.button_main_song1);
        buttonSong2 = findViewById(R.id.button_main_song2);
        buttonSong3 = findViewById(R.id.button_main_song3);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.button_main_song1: {
                if(loaded){
                    for(int n: notes){
                        soundPool.play(stressInducingSong.getNotes(n), 1,1,1,0,1f);
                        delay(stressInducingSong.getDelay(n));

                    }
                break;}}
            //case R.id.button_main_song2: {
               //if(loaded){

                //}
            //}
            case R.id.button_main_song3: {
                soundPool.play(bflatNote, 1, 1, 1, 0, 1f);
                break;}
        }}



    private class KeyBoardListener implements View.OnClickListener{

            @Override
            public void onClick(View view) {
                int songId = noteMap.get(view.getId());
                if(songId != 0){
                    soundPool.play(songId,1,1,1,0,1f);
                }
            }
        }
    }
