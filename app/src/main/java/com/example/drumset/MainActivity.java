package com.example.drumset;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageButton cymbal1,cymbal2,cymbal3,cymbal4,cymbal5;
    private ImageView stand1,stand2;

    private ImageButton drum;
    private ImageButton tone1;
    private ImageButton tone2;
    private SoundPool soundPool;
    int tom1,tom2,tom3,kick1,kick2,tone,ton_first,drum1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          cymbal1=(ImageButton)findViewById(R.id.cymbal1);
        cymbal2=(ImageButton)findViewById(R.id.cymbal2);
        cymbal3=(ImageButton)findViewById(R.id.cymbal3);
        cymbal4=(ImageButton)findViewById(R.id.cymbal4);
        cymbal5=(ImageButton)findViewById(R.id.cymbal5);

        tone1=(ImageButton)findViewById(R.id.tone1);
        tone2=(ImageButton)findViewById(R.id.tone);
        drum=(ImageButton)findViewById(R.id.drum);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(8)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC, 0);
        }
        tom1 = soundPool.load(this, R.raw.tom1, 1);
        tom2 = soundPool.load(this, R.raw.tom2, 1);
        tom3 = soundPool.load(this, R.raw.tomfm, 1);
        ton_first = soundPool.load(this, R.raw.jazz_ride, 1);
        drum1 = soundPool.load(this, R.raw.snare, 1);
        tone = soundPool.load(this, R.raw.crashacoustic, 1);
        kick2 = soundPool.load(this, R.raw.kickthump, 1);
        kick1 = soundPool.load(this, R.raw.kickacoustic02, 1);


    }
    public void playsound(View v) {
        switch (v.getId()) {
            case R.id.cymbal1:
                soundPool.play(kick1, 1, 1, 0, 0, 1);
                Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.anim1);
                cymbal1.startAnimation(animation1);

                break;
            case R.id.cymbal2:
                soundPool.play(kick2, 1, 1, 0, 0, 1);
                Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.anim1);
                cymbal2.startAnimation(animation2);
                break;
            case R.id.cymbal3:
                soundPool.play(tom1, 1, 1, 0, 0, 1);
                Animation animation3 = AnimationUtils.loadAnimation(this,R.anim.anim1);
                cymbal3.startAnimation(animation3);
                break;
            case R.id.cymbal4:
                soundPool.play(tom3, 1, 1, 0, 0, 1);
                Animation animation4 = AnimationUtils.loadAnimation(this,R.anim.anim1);
                cymbal4.startAnimation(animation4);
                break;
            case R.id.cymbal5:
                soundPool.play(tom2, 1, 1, 0, 0, 1);
                Animation animation5 = AnimationUtils.loadAnimation(this,R.anim.anim1);
                cymbal5.startAnimation(animation5);
                break;
            case R.id.drum:
                soundPool.play(drum1, 1, 1, 0, 0, 1);
                Animation animation6 = AnimationUtils.loadAnimation(this,R.anim.anim1);
                drum.startAnimation(animation6);
                break;

            case R.id.tone:
                soundPool.play(tone, 1, 1, 0, 0, 1);
                Animation animation7 = AnimationUtils.loadAnimation(this,R.anim.anim1);
                tone2.startAnimation(animation7);
                break;
            case R.id.tone1:
                soundPool.play(ton_first, 1, 1, 0, 0, 1);
                Animation animation8 = AnimationUtils.loadAnimation(this,R.anim.anim1);
                tone1.startAnimation(animation8);
                break;



        }
    }





    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
