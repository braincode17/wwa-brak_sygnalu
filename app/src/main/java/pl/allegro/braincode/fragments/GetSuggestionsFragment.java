package pl.allegro.braincode.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import lombok.Getter;
import lombok.Setter;
import pl.allegro.braincode.R;
import pl.allegro.braincode.suggestions.utils.ChartSetup;
import pl.allegro.braincode.suggestions.utils.SuggestionOnQueryTextListener;
import pl.allegro.braincode.suggestions.utils.SuggestionQueryHelper;

@Getter
@Setter
public class GetSuggestionsFragment extends BaseFragment {

    private static final String CATEGORY_KEY = "category";
    private static final String USERS_DECISION_KEY = "decision";
    private static final String TIME_PERIOD_KEY = "time";

    @BindView(R.id.chart)
    LineChart chart;
    @BindView(R.id.search_view)
    MaterialSearchView searchView;

    @BindView(R.id.days)
    TextView daysView;
    @BindView(R.id.price)
    TextView priceView;

    @BindView(R.id.radio_group)
    RadioGroup radioGroup;

    @BindView(R.id.radio_fastest)
    RadioButton radioFastest;
    @BindView(R.id.radio_custom)
    RadioButton radioCustom;
    @BindView(R.id.radio_highest)
    RadioButton radioHighest;

    @BindView(R.id.sell_button)
    Button sellButton;

    private List<Entry> chartValues;
    private Entry bestPrice;
    private Entry fastest;
    private String category;

    public static GetSuggestionsFragment newInstance(String category, String usersDecision,
                                                     Integer time) {
        GetSuggestionsFragment fragment = new GetSuggestionsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(CATEGORY_KEY, category);
        bundle.putString(USERS_DECISION_KEY, usersDecision);
        bundle.putInt(TIME_PERIOD_KEY, time);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        category = getArguments().getString(CATEGORY_KEY);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(CATEGORY_KEY, category);
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
        Toolbar toolbar = (Toolbar) v.findViewById(R.id.toolbar);

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        ChartSetup.initSettings(chart);
        SuggestionQueryHelper.query(this, null);
        chart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                daysView.setText(prettyPrintDuration((int) e.getX()));
                priceView.setText(String.valueOf(e.getY()) + " zł");
            }

            @Override
            public void onNothingSelected() {
                daysView.setText("-");
                priceView.setText("-");
            }
        });
        searchView.setOnQueryTextListener(new SuggestionOnQueryTextListener(this));
        radioHighest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chart.highlightValue(bestPrice.getX(), 0, true);
            }
        });
        radioFastest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chart.highlightValue(fastest.getX(), 0, true);
            }
        });
        radioCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chart.highlightValue(fastest.getX(), 0, true);
            }
        });
    }

    @Override
    protected void onViewsFragment(View view, Bundle savedInstanceState) {
    }

    public void showError(String error) {
        Snackbar.make(getView(), error, Snackbar.LENGTH_SHORT);
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

    @OnClick(R.id.sell_button)
    public void sell(){
        Uri uriUrl = Uri.parse("https://allegro.pl/");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
