package com.example.iobejan.weather.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.iobejan.weather.R;
import com.example.iobejan.weather.adapter.MyPlacesAdapter;
import com.example.iobejan.weather.interfaces.OnItemClickListener;
import com.example.iobejan.weather.z_base.BaseFragment;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;

public class MyPlacesFragment extends BaseFragment {
    private final static String TAG = MyPlacesFragment.class.getSimpleName();

    @BindView(R.id.rv_my_places) RecyclerView rvMyPlaces;
    private MyPlacesAdapter myPlacesAdapter;
    private ArrayList<String> data = new ArrayList<>(Arrays.asList("Place1", "Place 2 ", "Place 3"));

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setAdapter();
        setListeners();
    }

    private void setAdapter(){
        myPlacesAdapter = new MyPlacesAdapter(data);
        rvMyPlaces.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        rvMyPlaces.setAdapter(myPlacesAdapter);
    }

    private void setListeners(){
        myPlacesAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Snackbar.make(view, data.get(position), Snackbar.LENGTH_LONG);
            }
        });
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.my_places_fragment;
    }

    @Override
    protected int getFragmentTitle() {
        return R.string.nav_drawer_my_places;
    }

    @Override
    protected boolean isToolbarTransparent() {
        return false;
    }
}
