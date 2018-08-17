package com.example.iobejan.weather.fragment;

import com.example.iobejan.weather.R;
import com.example.iobejan.weather.z_base.BaseFragment;

public class MapsFragment extends BaseFragment {

    @Override
    protected int getFragmentLayout() {
        return R.layout.maps_fragment;
    }

    @Override
    protected int getFragmentTitle() {
        return R.string.nav_drawer_maps;
    }

    @Override
    protected boolean isToolbarTransparent() {
        return true;
    }
}
