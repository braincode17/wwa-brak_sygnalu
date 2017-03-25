package pl.allegro.braincode.activities;

import android.os.Bundle;

import butterknife.BindView;
import pl.allegro.braincode.R;
import pl.allegro.braincode.waveview.Typefaces;
import pl.allegro.braincode.waveview.Wave;
import pl.allegro.braincode.waveview.WaveTextView;

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
        throw new RuntimeException("Not implemented fragment container on splash screen.");
    }

    @Override
    protected boolean onActivityBackPressed() {
        return false;
    }

    private void initIntro() {
        // set fancy typeface
        waveAleTv.setTypeface(Typefaces.get(this, "Comfortaa-Regular.ttf"));
        waveAleTv.setWaveImage(getResources().getDrawable(R.mipmap.wave_orange,null));

        waveAuthor.setTypeface(Typefaces.get(this, "Comfortaa-Light.ttf"));
        waveAuthor.setWaveImage(getResources().getDrawable(R.mipmap.wave_orange,null));

        // start animation
        Wave waveAle = new Wave();
        waveAle.start(waveAleTv);

        Wave titleWave = new Wave();

        waveAuthor.postDelayed(new Runnable() {
            @Override
            public void run() {
                runActivity(MainActivity.class);
                finish();
            }
        }, Wave.TIME_WAVE_ANIMATION + 400);

        titleWave.start(waveAuthor);
    }
}
