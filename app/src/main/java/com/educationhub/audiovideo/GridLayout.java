package com.educationhub.audiovideo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class GridLayout extends AppCompatActivity {
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);
    }

    public void nextActivity(View view) {
    }

    public void play(View view) {

       int id  = view.getId();
       String ourId  = "";
       ourId = view.getResources().getResourceEntryName(id);
        playList(ourId);
        Log.i("Button Name",ourId);

    }

    public void playList(String soundTrack){
        int resouceId = getResources().getIdentifier(soundTrack,"raw",
                "com.educationhub.audiovideo");
        mediaPlayer = MediaPlayer.create(this,resouceId);
        mediaPlayer.start();
        }
    }
