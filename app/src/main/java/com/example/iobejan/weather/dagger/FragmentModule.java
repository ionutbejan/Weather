package com.example.iobejan.weather.dagger;

import com.example.iobejan.weather.fragment.MapsFragment;
import com.example.iobejan.weather.fragment.MyPlacesFragment;
import com.example.iobejan.weather.fragment.UserProfileFragment;
import com.example.iobejan.weather.fragment.WeatherFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract UserProfileFragment contributeUserProfileFragment();

    @ContributesAndroidInjector
    abstract WeatherFragment contributeWeatherFragment();

    @ContributesAndroidInjector
    abstract MyPlacesFragment contributeMyPlacesFragment();

    @ContributesAndroidInjector
    abstract MapsFragment contributeMapsFragment();
}
