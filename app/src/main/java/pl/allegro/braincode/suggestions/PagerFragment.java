package pl.allegro.braincode.suggestions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.allegro.braincode.MainActivity;

import me.relex.circleindicator.CircleIndicator;
import pl.allegro.braincode.R;

public class PagerFragment extends Fragment {

    private MainActivity activity;


    public static PagerFragment newInstance() {
        PagerFragment fragment = new PagerFragment();

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        activity = (MainActivity) getActivity();
        View view = inflater.inflate(R.layout.fragment_pager, container, false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ViewPager viewpager = (ViewPager) view.findViewById(R.id.viewpager);
        CircleIndicator indicator = (CircleIndicator) view.findViewById(R.id.indicator);
        viewpager.setAdapter(new SuggestionsFragmentPagerAdapter(getChildFragmentManager()));
        indicator.setViewPager(viewpager);
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
