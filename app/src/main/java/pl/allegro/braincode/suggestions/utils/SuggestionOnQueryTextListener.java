package pl.allegro.braincode.suggestions.utils;

import com.miguelcatalan.materialsearchview.MaterialSearchView;
import pl.allegro.braincode.fragments.GetSuggestionsFragment;

public class SuggestionOnQueryTextListener implements MaterialSearchView.OnQueryTextListener {

    private final GetSuggestionsFragment fragment;

    public SuggestionOnQueryTextListener(GetSuggestionsFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        SuggestionQueryHelper.query(fragment, query, fragment.getDays(), fragment.getMinPrice());
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        //Do some magic
        return false;
    }

}
