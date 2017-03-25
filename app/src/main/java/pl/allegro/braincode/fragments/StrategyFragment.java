package pl.allegro.braincode.fragments;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import pl.allegro.braincode.R;
import pl.allegro.braincode.activities.MainActivity;

public class StrategyFragment extends BaseFragment {

    private static final String CATEGORY_KEY = "category";

    @BindView(R.id.seek_bar)
    SeekBar seekBar;

    @BindView(R.id.period_text_view)
    TextView perdioTextView;

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
                perdioTextView.setText(prettyPrintDuration(progress));
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

    static String prettyPrintDuration(int days) {
        StringBuffer stringBuffer = new StringBuffer();
        int restDays = days;
        if (restDays > 365) {
            int years = restDays / 365;
            restDays = restDays % 365;
            stringBuffer.append(years).append(" lat, ");
        }
        if (restDays > 30) {
            int months = restDays / 30;
            restDays = restDays % 30;
            stringBuffer.append(months).append(" miesięcy, ");
        }
        if (restDays > 7) {
            int weeks = restDays / 7;
            restDays = restDays % 7;
            stringBuffer.append(weeks).append(" tygodni, ");
        }
        if (restDays > 0) {
            stringBuffer.append(restDays).append(" dni");
        }
        return stringBuffer.toString();
    }


    @OnClick(R.id.proceed_button)
    public void proceed(){
        BaseFragment fragment = GetSuggestionsFragment.newInstance(
                getArguments().getString(CATEGORY_KEY));
        ((MainActivity) getActivity()).showFragentWithTransition(fragment,
                fragment.getFragmentTag(), true);
    }
}
