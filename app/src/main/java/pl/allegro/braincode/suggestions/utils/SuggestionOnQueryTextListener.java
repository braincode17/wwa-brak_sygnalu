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
        SuggestionQueryHelper.query(fragment, query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        //Do some magic
        return false;
    }

}
