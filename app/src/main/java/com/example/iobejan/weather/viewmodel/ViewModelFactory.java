package com.example.iobejan.weather.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.iobejan.weather.repository.UserRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private UserRepository userRepository;

    @Inject
    public ViewModelFactory(@NonNull UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new UserViewModel(userRepository);
    }
}
