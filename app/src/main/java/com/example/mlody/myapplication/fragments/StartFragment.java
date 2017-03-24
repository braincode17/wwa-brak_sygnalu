package com.example.mlody.myapplication.fragments;


import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.example.mlody.myapplication.R;


public class StartFragment extends BaseFragment {

    public static StartFragment newInstance() {
        StartFragment fragment = new StartFragment();
        return fragment;
    }

    @Override
    public String getFragmentTag() {
        return this.getClass().getName();
    }

    @Override
    protected int onFragmentContentView() {
        return R.layout.fragment_start;
    }

    @Override
    protected void onCreateFragmentView(View v, ViewGroup container, Bundle savedInstanceState) {

    }

    @Override
    protected void onViewsFragment(View view, Bundle savedInstanceState) {
    }

}
