package com.example.iobejan.weather.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.iobejan.weather.datamodel.User;
import com.example.iobejan.weather.repository.UserRepository;

import javax.inject.Inject;


public class UserProfileViewModel extends ViewModel {
    private String userId;
    private LiveData<User> user;
    private UserRepository userRepository;

    @Inject
    public UserProfileViewModel(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void init(String userId){
        if (this.user != null)
            return;

        user = userRepository.getUser(userId);
    }

    public LiveData<User> getUser() {
        return user;
    }
}
