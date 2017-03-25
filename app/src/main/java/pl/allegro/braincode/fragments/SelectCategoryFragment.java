package pl.allegro.braincode.fragments;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import pl.allegro.braincode.R;
import pl.allegro.braincode.activities.MainActivity;
import pl.allegro.braincode.adapters.DividerItemDecor;
import pl.allegro.braincode.adapters.RecyclerViewAdapter;
import pl.allegro.braincode.communication.ServiceProvider;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectCategoryFragment extends BaseFragment implements OnChooseListener {

    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    private List<String> categories = new ArrayList<>();

    public static SelectCategoryFragment newInstance() {
        return new SelectCategoryFragment();
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
        downloadAndDisplay();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        categories.clear();
    }

    public void downloadAndDisplay(){
        ServiceProvider.INSTANCE.getServerService().getCategories().enqueue(
                new Callback<List<String>>() {
                    @Override
                    public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                        categories.addAll(response.body());
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                        recyclerView.setLayoutManager(linearLayoutManager);
                        recyclerView.setAdapter(new RecyclerViewAdapter(categories, SelectCategoryFragment.this));
                    }
                    @Override
                    public void onFailure(Call<List<String>> call, Throwable t) {
                        Toast.makeText(getContext(),":(", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    protected void onViewsFragment(View view, Bundle savedInstanceState) {
    }

    @Override
    public void choose(int id) {
        //Transaction
        BaseFragment fragment = StrategyFragment.newInstance(categories.get(id));
        ((MainActivity) getActivity()).showFragentWithTransition(fragment,
                fragment.getFragmentTag(), true);
    }
}
