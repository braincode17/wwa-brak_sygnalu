package pl.allegro.braincode.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.miguelcatalan.materialsearchview.MaterialSearchView;


import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import pl.allegro.braincode.R;
import pl.allegro.braincode.suggestions.utils.ChartSetup;
import pl.allegro.braincode.suggestions.utils.MockDataProvider;
import pl.allegro.braincode.suggestions.utils.SuggestionOnQueryTextListener;

@Getter
@Setter
public class GetSuggestionsFragment extends BaseFragment {

    private LineChart chart;
    private MaterialSearchView searchView;
    private ArrayList<Entry> chartValues;

    public static GetSuggestionsFragment newInstance(String category) {
        GetSuggestionsFragment fragment = new GetSuggestionsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("category", category);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        chart = (LineChart) v.findViewById(R.id.chart);
        ChartSetup.initSettings(chart);
        chartValues = MockDataProvider.getData();
        ChartSetup.setupChart(chart, ChartSetup.prepareDataForChart(chartValues));
        searchView = (MaterialSearchView) v.findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SuggestionOnQueryTextListener(this));
    }

    @Override
    protected void onViewsFragment(View view, Bundle savedInstanceState) {
    }
}
