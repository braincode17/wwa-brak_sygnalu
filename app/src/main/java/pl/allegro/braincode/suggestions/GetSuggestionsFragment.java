package pl.allegro.braincode.suggestions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import pl.allegro.braincode.MainActivity;
import pl.allegro.braincode.R;

public class GetSuggestionsFragment extends Fragment {

    private MainActivity mainActivity;

    public GetSuggestionsFragment() {
    }

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_get_suggestions, container, false);
        Button finish = (Button)view.findViewById(R.id.search);
        return view;
    }

    private void showMessageIfViewExists(String message, View view) {
        if(view != null) {
            Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
                    .show();
        }
    }
}
