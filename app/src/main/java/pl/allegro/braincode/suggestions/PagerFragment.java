package pl.allegro.braincode.suggestions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;
import pl.allegro.braincode.R;
import pl.allegro.braincode.activities.MainActivity;

public class PagerFragment extends Fragment {

    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.indicator)
    CircleIndicator circleIndicator;

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
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        viewPager.setAdapter(new SuggestionsFragmentPagerAdapter(getChildFragmentManager()));
        viewPager.setPageTransformer(true, new CubeOutTransformer());
        circleIndicator.setViewPager(viewPager);
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
