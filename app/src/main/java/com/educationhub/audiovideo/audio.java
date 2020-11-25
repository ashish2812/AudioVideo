package com.educationhub.audiovideo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

public class audio extends AppCompatActivity {

    boolean playing =true;
    MediaPlayer mediaPlayer;

    //for changing the volume in the system
   ;

    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        mediaPlayer = MediaPlayer.create(this,R.raw.sound);


        audioManager =(AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        SeekBar seekBar = findViewById(R.id.seekbar);
        seekBar.setMax(maxVolume);
        seekBar.setProgress(curVolume);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("SeekBar changed",Integer.toString(i));
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void playButton(View view) {
        mediaPlayer.start();
    }

    public void pause(View view) {

            mediaPlayer.pause();


    }
}