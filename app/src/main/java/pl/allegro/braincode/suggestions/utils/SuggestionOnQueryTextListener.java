package pl.allegro.braincode.suggestions.utils;

import com.github.mikephil.charting.data.Entry;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import pl.allegro.braincode.fragments.GetSuggestionsFragment;

public class SuggestionOnQueryTextListener implements MaterialSearchView.OnQueryTextListener {

    private final GetSuggestionsFragment fragment;

    public SuggestionOnQueryTextListener(GetSuggestionsFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        ArrayList<Entry> data = MockDataProvider.getData();
        fragment.setChartValues(data);
        ChartSetup.setupChart(fragment.getChart(), ChartSetup.prepareDataForChart(data));
        //rest query saving data to chartValues an updating
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        //Do some magic
        return false;
    }

}
