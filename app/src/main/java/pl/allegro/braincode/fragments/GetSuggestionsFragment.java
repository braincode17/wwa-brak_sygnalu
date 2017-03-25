package pl.allegro.braincode.fragments;

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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.miguelcatalan.materialsearchview.MaterialSearchView;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import lombok.Getter;
import lombok.Setter;
import pl.allegro.braincode.R;
import pl.allegro.braincode.suggestions.utils.ChartSetup;
import pl.allegro.braincode.suggestions.utils.MockDataProvider;
import pl.allegro.braincode.suggestions.utils.SuggestionOnQueryTextListener;

@Getter
@Setter
public class GetSuggestionsFragment extends BaseFragment {

    private static final String CATEGORY_KEY = "category";

    private LineChart chart;
    private MaterialSearchView searchView;
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

    private List<Entry> chartValues;
    private Entry bestPrice;
    private Entry fastest;
    private String category;

    public static GetSuggestionsFragment newInstance(String category) {
        GetSuggestionsFragment fragment = new GetSuggestionsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(CATEGORY_KEY, category);
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
        chartValues = MockDataProvider.getData();
        ChartSetup.setupChart(chart, ChartSetup.prepareDataForChart(chartValues));
        chart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                priceView.setText(String.valueOf(e.getX()));
                priceView.setText(String.valueOf(e.getY()));
            }

            @Override
            public void onNothingSelected() {
                priceView.setText("-");
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
                chart.highlightValue(6, 0, true);
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
}
