package pl.allegro.braincode.fragments;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import pl.allegro.braincode.R;
import pl.allegro.braincode.activities.MainActivity;
import pl.allegro.braincode.adapters.DividerItemDecor;
import pl.allegro.braincode.adapters.RecyclerViewAdapter;

public class SelectCategoryFragment extends BaseFragment implements OnChooseListener {

    @BindView(R.id.recycler)
    RecyclerView recyclerView;
        List<String> kek = Arrays.asList("lel","wooo","hoho","haha",
                "lel","wooo","hoho","haha","kek2", "kekr3");

    private LinearLayoutManager  linearLayoutManager;

    public static SelectCategoryFragment newInstance() {
        SelectCategoryFragment fragment = new SelectCategoryFragment();
        return fragment;
    }

    @Override
    protected int onFragmentContentView() {
        return R.layout.fragment_select_category;
    }

    @Override
    public String getFragmentTag() {
        return this.getClass().getName();
    }

    @Override
    protected void onCreateFragmentView(View v, ViewGroup container, Bundle savedInstanceState) {
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecor(ContextCompat.getDrawable(getActivity(),
                R.drawable.divider)));
        recyclerView.setAdapter(new RecyclerViewAdapter(kek, this));
    }

    @Override
    protected void onViewsFragment(View view, Bundle savedInstanceState) {
    }

    @Override
    public void choose(int id) {
        //Transaction
        BaseFragment fragment = GetSuggestionsFragment.newInstance();
        ((MainActivity) getActivity()).showFragment(fragment, fragment.getFragmentTag(), true);
    }
}
