package com.example.iobejan.weather.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.iobejan.weather.R;
import com.example.iobejan.weather.datamodel.User;
import com.example.iobejan.weather.viewmodel.UserProfileViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserProfileFragment extends Fragment {
    private static final String UID_KEY = "uid";
    private UserProfileViewModel viewModel;

    @BindView(R.id.tv_username) TextView tv_username;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String userId = getArguments().getString(UID_KEY);
        viewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);
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
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.user_profile_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
