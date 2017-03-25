package pl.allegro.braincode.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import pl.allegro.braincode.R;
import pl.allegro.braincode.activities.MainActivity;
import pl.allegro.braincode.utils.TextUtils;

public class StrategyFragment extends BaseFragment {

    private static final String CATEGORY_KEY = "category";

    @BindView(R.id.time_strategy_selector)
    LinearLayout timeStrategyLayout;

    @BindView(R.id.time_money_edit_text)
    EditText timeMoneyEditText;

    @BindView(R.id.money_strategy_selector)
    LinearLayout moneyStrategyLayout;

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
        seekBar.setMax(180);
        seekBar.setProgress(31);
    }

    @Override
    protected void onViewsFragment(View view, Bundle savedInstanceState) {

    }

    @OnClick(R.id.money_button)
    public void chooseMoney() {
        userStrategy = "money";
        moneyButton.setAlpha(1F);
        timeButton.setAlpha(0.2F);
        timeStrategyLayout.setVisibility(View.GONE);
        moneyStrategyLayout.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.time_button)
    public void chooseTime() {
        userStrategy = "time";
        timeButton.setAlpha(1F);
        moneyButton.setAlpha(0.2F);
        timeStrategyLayout.setVisibility(View.VISIBLE);
        moneyStrategyLayout.setVisibility(View.GONE);
    }

    @OnClick(R.id.proceed_button)
    public void proceed() {
//        if (userStrategy != null && (!(seekBar.getProgress() == 0) || timeMoneyEditText.getText() != null)) {
//            String text = timeMoneyEditText.getText().toString();
//            BaseFragment fragment = GetSuggestionsFragment.newInstance(
//                    getArguments().getString(CATEGORY_KEY), userStrategy,
//                    seekBar.getProgress(), Integer.valueOf(text));
//            ((MainActivity) getActivity()).showFragentWithTransition(fragment,
//                    fragment.getFragmentTag(), true);
//        } else {
//            Toast.makeText(getContext(), "Wybierz strategię i czas oczekiwania.",
//                    Toast.LENGTH_SHORT).show();
//        }

        if (userStrategy != null) {
            if (userStrategy.equals("money")) {
                if (!(seekBar.getProgress() == 0)) {
                    BaseFragment fragment = GetSuggestionsFragment.newInstance(
                            getArguments().getString(CATEGORY_KEY), userStrategy,
                            seekBar.getProgress(), null);
                    ((MainActivity) getActivity()).showFragentWithTransition(fragment, fragment.getFragmentTag(), true);
                } else {
                    Toast.makeText(getContext(), "Wybierz minimalny czas.", Toast.LENGTH_SHORT).show();
                }
            } else {
                if (timeMoneyEditText.getText() != null && !timeMoneyEditText.getText().toString().isEmpty()) {
                    String text = timeMoneyEditText.getText().toString();
                    BaseFragment fragment = GetSuggestionsFragment.newInstance(
                            getArguments().getString(CATEGORY_KEY), userStrategy,
                            null, Integer.valueOf(text));

                    ((MainActivity) getActivity()).showFragentWithTransition(fragment, fragment.getFragmentTag(), true);
                } else {
                    Toast.makeText(getContext(), "Wybierz minimalną cenę.", Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            Toast.makeText(getContext(), "Wybierz strategię.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroyView() {
        userStrategy = null;
        super.onDestroyView();
    }
}
