package pl.allegro.braincode.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(onActivityContentView());
        unbinder = ButterKnife.bind(this);
        int iContentView = onActivityContentView();
        if (iContentView == 0) {
            throw new RuntimeException("onActivityContentView() is not set");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onBackPressed() {
        if (!onActivityBackPressed()) super.onBackPressed();
    }

    protected abstract int onActivityContentView();

    protected abstract int getFragmentContainer();

    public void runActivity(Class<?> className) {
        Intent i = new Intent(this, className);
        startActivity(i);
    }

    public void showFragment(Fragment fragment, String tag, boolean addToBackStop) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(getFragmentContainer(), fragment, tag);
        if (addToBackStop)
            transaction.addToBackStack(tag);
        transaction.commitAllowingStateLoss();
    }

    protected abstract boolean onActivityBackPressed();
}
