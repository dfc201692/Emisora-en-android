package com.androfast.appradio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button button_stop;
    Button button_play;
    private String STREAM_URL ="https://streaming1.hostingmontevideo.com:7026";
    private MediaPlayer mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_stop=(Button) findViewById(R.id.btnStop);
        button_play=(Button) findViewById(R.id.btnPlay);
        mPlayer=new MediaPlayer();
        button_play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try{
                    mPlayer.reset();
                    mPlayer.setDataSource(STREAM_URL);
                    mPlayer.prepareAsync();
                    mPlayer.setOnPreparedListener(new MediaPlayer.
                            OnPreparedListener(){
                        @Override
                        public void onPrepared(MediaPlayer mp){
                            mp.start();
                        }
                    });
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
        button_stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mPlayer.stop();
            }
        });
    }
}
