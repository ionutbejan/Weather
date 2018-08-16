package com.example.iobejan.weather.dagger;

import com.example.iobejan.weather.fragment.UserProfileFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract UserProfileFragment contributeUserProfileFragment();
}
