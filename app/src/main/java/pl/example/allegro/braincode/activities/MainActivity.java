package pl.example.allegro.braincode.activities;

import android.os.Bundle;

import pl.example.allegro.braincode.R;
import pl.example.allegro.braincode.fragments.StartFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showStartFragment();
    }

    @Override
    protected int onActivityContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected int getFragmentContainer() {
        return R.id.fragment_container;
    }

    @Override
    protected boolean onActivityBackPressed() {
        return false;
    }

    void showStartFragment() {
        StartFragment fragment = StartFragment.newInstance();
        showFragment(fragment, fragment.getFragmentTag(), false);
    }
}
