package pl.allegro.braincode.fragments;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import butterknife.BindView;
import butterknife.OnClick;
import pl.allegro.braincode.R;
import pl.allegro.braincode.activities.MainActivity;
import pl.allegro.braincode.utils.TextUtils;

public class StrategyFragment extends BaseFragment {

    private static final String CATEGORY_KEY = "category";

    @BindView(R.id.seek_bar)
    SeekBar seekBar;

    @BindView(R.id.period_text_view)
    TextView periodTextView;

    @BindView(R.id.money_button)
    ImageButton moneyButton;

    @BindView(R.id.time_button)
    ImageButton timeButton;

    private String userStrategy;

    public static StrategyFragment newInstance(String category) {
        StrategyFragment fragment = new StrategyFragment();
        Bundle bundle = new Bundle();
        bundle.putString(CATEGORY_KEY, category);
        fragment.setArguments(bundle);
        return fragment;
    }



    @Override
    String getFragmentTag() {
        return this.getClass().getName();
    }

    @Override
    protected int onFragmentContentView() {
        return R.layout.fragment_strategy;
    }

    @Override
    protected void onCreateFragmentView(View v, ViewGroup container, Bundle savedInstanceState) {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                periodTextView.setText(TextUtils.prettyPrintDuration(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onViewsFragment(View view, Bundle savedInstanceState) {

    }

    @OnClick(R.id.money_button)
    public void chooseMoney() {
        userStrategy = "money";
        moneyButton.setAlpha(1F);
        timeButton.setAlpha(0.2F);
    }

    @OnClick(R.id.time_button)
    public void chooseTime() {
        userStrategy = "time";
        timeButton.setAlpha(1F);
        moneyButton.setAlpha(0.2F);
    }

    @OnClick(R.id.proceed_button)
    public void proceed() {
        if (userStrategy!=null) {
            BaseFragment fragment = GetSuggestionsFragment.newInstance(
                    getArguments().getString(CATEGORY_KEY), userStrategy,
                    seekBar.getProgress());
            ((MainActivity) getActivity()).showFragentWithTransition(fragment,
                    fragment.getFragmentTag(), true);
        } else {
            Toast.makeText(getContext(),"You need to select one category.",Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
