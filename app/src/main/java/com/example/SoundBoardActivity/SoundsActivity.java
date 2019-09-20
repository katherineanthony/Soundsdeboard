package com.example.SoundBoardActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.media.SoundPool.OnLoadCompleteListener;
import android.widget.ViewAnimator;


public class SoundsActivity extends AppCompatActivity {
    private Button buttonA;
    private Button buttonBflat;
    private Button buttonB;
    private int aNote;
    private int bNote;
    private int bflatNote;
    private SoundPool soundPool;
    private int soundA;
    private int soundB;
    private int soundBb;
    private boolean loaded;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sounds);
        wireWidgets();
        //this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        loaded = false;

        //wirewidgets();

        loadSoundPool();
        liamsuckssetListeners();


    }

    private void loadSoundPool() {
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        aNote = soundPool.load(this, R.raw.scalea,1);
        bNote = soundPool.load(this, R.raw.scaleb,1);
        bflatNote = soundPool.load(this, R.raw.scalebb,1);
        loaded = true;
    }


    private void liamsuckssetListeners() {
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
                    @Override
                    public void onLoadComplete(SoundPool soundPool, int sampleId,
                                               int status) {
                        loaded = true;
                    }
                });
                AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                float actualVolume = (float) audioManager
                        .getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = (float) audioManager
                        .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float volume = actualVolume / maxVolume;
                if(loaded)
                    soundPool.play(aNote, volume, volume, 1, 0, 1f);
            }
        });
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
                    @Override
                    public void onLoadComplete(SoundPool soundPool, int sampleId,
                                               int status) {
                        loaded = true;
                    }
                });
                AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                float actualVolume = (float) audioManager
                        .getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = (float) audioManager
                        .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float volume = actualVolume / maxVolume;
                if(loaded)
                    soundPool.play(bNote, volume, volume, 1, 0, 1f);
            }
        });
        buttonBflat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
                    @Override
                    public void onLoadComplete(SoundPool soundPool, int sampleId,
                                               int status) {
                        loaded = true;
                    }
                });
                AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                float actualVolume = (float) audioManager
                        .getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = (float) audioManager
                        .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float volume = actualVolume / maxVolume;
                if(loaded)
                    soundPool.play(bflatNote, volume, volume, 1, 0, 1f);
            }
        });
    }

    private void wireWidgets() {
        buttonA=findViewById(R.id.button_main_a);
        buttonB=findViewById(R.id.button_main_b);
        buttonBflat=findViewById(R.id.button_main_bflat);
    }

}
