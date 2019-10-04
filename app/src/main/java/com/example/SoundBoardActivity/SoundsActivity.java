package com.example.SoundBoardActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.media.SoundPool.OnLoadCompleteListener;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ViewAnimator;

import java.util.HashMap;
import java.util.Map;


public class SoundsActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonA;
    private Button buttonBflat;
    private Button buttonB;
    private Button buttonC;
    private Button buttonCsharp;
    private Button buttonD;
    private Button buttonDsharp;
    private Button buttonE;
    private Button buttonF;
    private Button buttonFsharp;
    private Button buttonG;
    private Button buttonGsharp;
    private Button buttonSong1;
    private Button buttonSong2;
    private Button buttonSong3;
    private Button buttonScale;
    private Button buttonRecord;
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

    private SoundPool soundPool;
    private boolean loaded;
    private Map<Integer,Integer> noteMap;
    private int[] stressInducingNotes;
    private int[] stressInducingDelays;
    private Song stressInducingSong;
    private int[] thisIsHalloweenNotes;
    private int[] thisIsHalloweenDelays;
    private Song thisIsHalloween;
    private int[] notes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sounds);
        wireWidgets();
        loaded = false;

        loadSoundPool();
        stressInducingNotes = new int[] {gNote, gNote, dNote, dNote, eNote, eNote, dNote, cNote,
                cNote,bNote,bNote,aNote, aNote, gNote, dNote,dNote,cNote,cNote,bNote,bNote,
                aNote,dNote, dNote,cNote,cNote,bNote,bNote,aNote,gNote,gNote,dNote,dNote,
                eNote,eNote,dNote,cNote,cNote,bNote,bNote,aNote,aNote,gNote};
        stressInducingDelays = new int[] {500,500,500,500,500,500,1000,500,500,500,500,500,500,1000,
                500,500,500,500,500,500,1000,500,500,500,500,500,500,1000,500,500,500,
                500,500,500,1000,500,500,500,500,500,500,1000};
        stressInducingSong = new Song(stressInducingNotes,stressInducingDelays);
        thisIsHalloweenNotes = new int[] {gsharpNote,gsharpNote,gsharpNote,gNote,fNote,gsharpNote,
                gsharpNote, gsharpNote,gNote,fNote, dNote,csharpNote, bNote, dNote, csharpNote,
                bNote,bflatNote,aNote,gNote,bflatNote,aNote,gNote};
        thisIsHalloweenDelays = new int[] {500, 500, 150,150,150, 500,500, 150,150,300,150,150,
                250,150,150,250,150,150,250,150,150,150};
        thisIsHalloween = new Song(thisIsHalloweenNotes,thisIsHalloweenDelays);
        notes = new int[] {aNote,bflatNote,bNote,cNote,csharpNote,dNote,dsharpNote,eNote,fNote,
                fsharpNote,gNote,gsharpNote};
        setListeners();
    }

    private void loadSoundPool() {
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        aNote = soundPool.load(this, R.raw.scalea,1);
        bNote = soundPool.load(this, R.raw.scaleb,1);
        bflatNote = soundPool.load(this, R.raw.scalebb,1);
        cNote = soundPool.load(this, R.raw.scalec,1);
        csharpNote = soundPool.load(this, R.raw.scalecs,1);
        dNote = soundPool.load(this, R.raw.scaled,1);
        dsharpNote = soundPool.load(this, R.raw.scaleds,1);
        eNote = soundPool.load(this, R.raw.scalee,1);
        fNote = soundPool.load(this, R.raw.scalef,1);
        fsharpNote = soundPool.load(this, R.raw.scalefs,1);
        gNote = soundPool.load(this, R.raw.scaleg,1);
        gsharpNote = soundPool.load(this, R.raw.scalegs,1);
        //loaded = true;

        /*noteMap = new HashMap<>();
        noteMap.put(buttonA.getId(), aNote);
        noteMap.put(buttonB.getId(), bNote);
        noteMap.put(buttonBflat.getId(), bflatNote);
        noteMap.put(buttonC.getId(), cNote);
        noteMap.put(buttonCsharp.getId(), csharpNote);
        noteMap.put(buttonD.getId(), dNote);
        noteMap.put(buttonDsharp.getId(), dsharpNote);
        noteMap.put(buttonE.getId(), eNote);
        noteMap.put(buttonF.getId(), fNote);
        noteMap.put(buttonFsharp.getId(), fsharpNote);
        noteMap.put(buttonG.getId(), gNote);
        noteMap.put(buttonGsharp.getId(), gsharpNote);*/
        loaded = true;
    }


    private void setListeners() {
        KeyBoardListener keyBoardListener = new KeyBoardListener();
        buttonA.setOnClickListener(keyBoardListener);
        buttonB.setOnClickListener(keyBoardListener);
        buttonBflat.setOnClickListener(keyBoardListener);
        buttonC.setOnClickListener(keyBoardListener);
        buttonCsharp.setOnClickListener(keyBoardListener);
        buttonD.setOnClickListener(keyBoardListener);
        buttonDsharp.setOnClickListener(keyBoardListener);
        buttonE.setOnClickListener(keyBoardListener);
        buttonF.setOnClickListener(keyBoardListener);
        buttonFsharp.setOnClickListener(keyBoardListener);
        buttonG.setOnClickListener(keyBoardListener);
        buttonGsharp.setOnClickListener(keyBoardListener);
        buttonSong1.setOnClickListener(this);
        buttonSong2.setOnClickListener(this);
        buttonSong3.setOnClickListener(this);
        buttonScale.setOnClickListener(this);
        buttonRecord.setOnClickListener(this);
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
        buttonC=findViewById(R.id.button_main_c);
        buttonCsharp=findViewById(R.id.button_main_csharp);
        buttonD=findViewById(R.id.button_main_d);
        buttonDsharp=findViewById(R.id.button_main_dsharp);
        buttonE=findViewById(R.id.button_main_e);
        buttonF=findViewById(R.id.button_main_f);
        buttonFsharp=findViewById(R.id.button_main_fsharp);
        buttonG=findViewById(R.id.button_main_g);
        buttonGsharp=findViewById(R.id.button_main_gsharp);
        buttonSong1 = findViewById(R.id.button_main_song1);
        buttonSong2 = findViewById(R.id.button_main_song2);
        buttonSong3 = findViewById(R.id.button_main_song3);
        buttonScale = findViewById(R.id.button_main_scale);
        buttonRecord=findViewById(R.id.button_main_record);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.button_main_song1: {
                if(loaded) {
                    for (int s = 0; s < stressInducingNotes.length; s++) {
                        soundPool.play(stressInducingNotes[s], 1, 1, 1, 0, 1f);
                        delay(stressInducingSong.getDelay(s));
                    }
                }
                break;}
            case R.id.button_main_song2: {
                if (loaded) {
                    for (int s = 0; s < thisIsHalloweenNotes.length; s++) {
                        soundPool.play(thisIsHalloweenNotes[s], 1, 1, 1, 0, 1f);
                        delay(thisIsHalloween.getDelay(s));
                    }
                }
                break;
            }
            case R.id.button_main_song3: {
                soundPool.play(bflatNote, 1, 1, 1, 0, 1f);
                break;}

            case R.id.button_main_scale:{
                if(loaded){
                    for(int s = 0; s < 13; s++)
                    {
                        soundPool.play(notes[s], 1,1,1,0,1f);
                        delay(2000);
                    }
                }
            }
            case R.id.button_main_record: {

            }
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
