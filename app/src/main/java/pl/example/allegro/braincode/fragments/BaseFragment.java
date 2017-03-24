package pl.example.allegro.braincode.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onViewsFragment(view, savedInstanceState);
    }


    abstract String getFragmentTag();

    public void addFragment(FragmentManager support, int layout, String fragmentTag, boolean addToBackStack) {
        FragmentTransaction ft = support.beginTransaction();
        ft.replace(layout, this, fragmentTag);
        if (addToBackStack) ft.addToBackStack(null);
        ft.commit();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int contentView = onFragmentContentView();

        if (contentView == 0)
            throw new IllegalArgumentException("onFragmentContentView must be not equal 0");

        View layout = inflater.inflate(contentView, container, false);
        ButterKnife.bind(this, layout);

        onCreateFragmentView(layout, container, savedInstanceState);

        return layout;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    protected abstract int onFragmentContentView();

    /**
     * Override this method instead onCreateView
     */
    protected abstract void onCreateFragmentView(View v, ViewGroup container, Bundle savedInstanceState);

    /**
     * Override this method instead onViewCreated
     */
    protected abstract void onViewsFragment(View view, Bundle savedInstanceState);

}
