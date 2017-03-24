package pl.allegro.braincode;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import pl.allegro.braincode.suggestions.PagerFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showWizardFragment();
    }

    public void showWizardFragment() {
        showFragment(PagerFragment.newInstance(), true);
    }

    private void showFragment(Fragment fragment, boolean addToBackStack) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

}
