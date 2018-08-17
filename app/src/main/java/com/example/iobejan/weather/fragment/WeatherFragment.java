package com.example.iobejan.weather.fragment;

import com.example.iobejan.weather.R;
import com.example.iobejan.weather.z_base.BaseFragment;

public class WeatherFragment extends BaseFragment {
    @Override
    protected int getFragmentLayout() {
        return R.layout.weather_fragment;
    }

    @Override
    protected int getFragmentTitle() {
        return R.string.nav_drawer_weather;
    }

    @Override
    protected boolean isToolbarTransparent() {
        return true;
    }

}
