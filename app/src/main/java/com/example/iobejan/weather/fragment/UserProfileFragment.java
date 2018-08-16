package com.example.iobejan.weather.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.iobejan.weather.R;
import com.example.iobejan.weather.datamodel.User;
import com.example.iobejan.weather.viewmodel.UserViewModel;
import com.example.iobejan.weather.viewmodel.ViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserProfileFragment extends Fragment{
    private static final String UID_KEY = "uid";
    private final static String TAG = UserProfileFragment.class.getSimpleName();

    @Inject
    ViewModelFactory viewModelFactory;

    @BindView(R.id.tv_username) TextView tv_username;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String userId = getArguments().getString(UID_KEY);


        UserViewModel viewModel = ViewModelProviders.of(this, this.viewModelFactory).get(UserViewModel.class);

        viewModel.init(userId);
        viewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                assert user != null;
                updateUI(user);
            }
        });
    }

    private void updateUI(@NonNull User user){
        tv_username.setText(user.getName());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.user_profile_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
