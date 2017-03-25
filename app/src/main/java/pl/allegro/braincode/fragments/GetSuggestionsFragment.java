package pl.allegro.braincode.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import pl.allegro.braincode.activities.BaseActivity;
import pl.allegro.braincode.activities.MainActivity;
import pl.allegro.braincode.R;

public class GetSuggestionsFragment extends BaseFragment {

    public static GetSuggestionsFragment newInstance() {
        GetSuggestionsFragment fragment = new GetSuggestionsFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    String getFragmentTag() {
        return this.getClass().getName();
    }

    @Override
    protected int onFragmentContentView() {
        return R.layout.fragment_get_suggestions;
    }

    @Override
    protected void onCreateFragmentView(View v, ViewGroup container, Bundle savedInstanceState) {
        Button finish = (Button)v.findViewById(R.id.search);
    }

    @Override
    protected void onViewsFragment(View view, Bundle savedInstanceState) {

    }

    private void showMessageIfViewExists(String message, View view) {
        if(view != null) {
            Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
                    .show();
        }
    }
}
