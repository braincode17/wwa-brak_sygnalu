package pl.allegro.braincode.suggestions.utils;

import com.github.mikephil.charting.data.Entry;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import pl.allegro.braincode.communication.ServiceProvider;
import pl.allegro.braincode.fragments.GetSuggestionsFragment;
import pl.allegro.braincode.messages.category.Category;
import pl.allegro.braincode.messages.price.PriceDto;
import pl.allegro.braincode.messages.price.Suggestion;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SuggestionOnQueryTextListener implements MaterialSearchView.OnQueryTextListener {

    private final GetSuggestionsFragment fragment;

    public SuggestionOnQueryTextListener(GetSuggestionsFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
       /* ArrayList<Entry> data = MockDataProvider.getData();
        fragment.setChartValues(data);
        ChartSetup.setupChart(fragment.getChart(), ChartSetup.prepareDataForChart(data));*/
        //rest query saving data to chartValues an updating
        ServiceProvider.INSTANCE.getServerService().getPrices(Category.CARS, query).enqueue(new Callback<Suggestion>() {
            @Override
            public void onResponse(Call<Suggestion> call, Response<Suggestion> response) {
                if(response.body() != null) {
                    List<Entry> entries = DtoConverter.convert(response.body());
                    fragment.setChartValues(entries);
                    ChartSetup.setupChart(fragment.getChart(), ChartSetup.prepareDataForChart(entries));
                    fragment.setBestPrice(DtoConverter.convert(response.body().getBestPrice()));
                    fragment.setFastest(DtoConverter.convert(response.body().getFastest()));
                }
            }

            @Override
            public void onFailure(Call<Suggestion> call, Throwable t) {
                fragment.showError("Rest call failed.");
            }
        });
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        //Do some magic
        return false;
    }

}
