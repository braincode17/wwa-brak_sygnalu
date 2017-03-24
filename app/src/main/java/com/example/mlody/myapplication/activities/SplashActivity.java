package com.example.mlody.myapplication.activities;

import android.os.Bundle;

import butterknife.BindView;

import com.example.mlody.myapplication.R;
import com.example.mlody.myapplication.waveview.Typefaces;
import com.example.mlody.myapplication.waveview.Wave;
import com.example.mlody.myapplication.waveview.WaveTextView;


public class SplashActivity extends BaseActivity {
    @BindView(R.id.wave_ale_tv)
    WaveTextView waveAleTv;
    @BindView(R.id.wave_author)
    WaveTextView waveAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initIntro();
    }

    @Override
    protected int onActivityContentView() {
        return R.layout.activity_splash;
    }

    @Override
    protected int getFragmentContainer() {
        return R.id.fragment_container;
    }

    @Override
    protected boolean onActivityBackPressed() {
        return false;
    }

    private void initIntro() {
        // set fancy typeface
        waveAleTv.setTypeface(Typefaces.get(this, "Comfortaa-Regular.ttf"));
        waveAleTv.setWaveImage(getResources().getDrawable(R.mipmap.wave_orange));

        waveAuthor.setTypeface(Typefaces.get(this, "Comfortaa-Light.ttf"));
        waveAuthor.setWaveImage(getResources().getDrawable(R.mipmap.wave_orange));

        // start animation
        Wave waveAle = new Wave();
        waveAle.start(waveAleTv);

        Wave titleWave = new Wave();

        waveAuthor.postDelayed(new Runnable() {
            @Override
            public void run() {
                runActivity(MainActivity.class);
            }
        }, Wave.TIME_WAVE_ANIMATION + 400);

        titleWave.start(waveAuthor);
    }
}
