package com.example.guilh.gymbuddy;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.CountDownTimer;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void pisca(){
        final RelativeLayout relative = (RelativeLayout)findViewById(R.id.activity_main);
        relative.setBackgroundColor(Color.GREEN);
        final Runnable r = new Runnable() {
            @Override
            public void run() {
                relative.setBackgroundColor(Color.TRANSPARENT);


            }
        };
        Handler handler = new Handler();
        handler.postDelayed(r,3);

    }
    public void birl(){


        final MediaPlayer birlSoundMediaPlayer = MediaPlayer.create(this, R.raw.birl_show);
        birlSoundMediaPlayer.start();

        Toast.makeText(this,"Volte a treinar",Toast.LENGTH_LONG).show();
        pisca();


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        Button oneMinuteButton = (Button)findViewById(R.id.Minute);

        oneMinuteButton.setOnClickListener(

                new android.view.View.OnClickListener(){
                    @Override
                    public void onClick(View v) {

                        final Runnable r = new Runnable() {
                            @Override
                            public void run() {

                                birl();

                            }
                        };
                        Handler handler = new Handler();
                        handler.postDelayed(r,60000);
                    }
                });


        super.onCreate(savedInstanceState);
    }

}
