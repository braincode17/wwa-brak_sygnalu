package pl.allegro.braincode.fragments;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import butterknife.OnClick;
import pl.allegro.braincode.R;
import pl.allegro.braincode.activities.MainActivity;

public class StrategyFragment extends BaseFragment {

    private static final String CATEGORY_KEY = "category";

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

    }

    @Override
    protected void onViewsFragment(View view, Bundle savedInstanceState) {

    }

//    @OnClick(R.id.)
//    public void proceed(){
//        BaseFragment fragment = GetSuggestionsFragment.newInstance(
//                getArguments().getString(CATEGORY_KEY));
//        ((MainActivity) getActivity()).showFragentWithTransition(fragment,
//                fragment.getFragmentTag(), true);
//    }
}
