package com.example.iobejan.weather.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.example.iobejan.weather.z_base.BaseFragment;
import com.example.iobejan.weather.R;
import com.example.iobejan.weather.datamodel.User;
import com.example.iobejan.weather.viewmodel.UserViewModel;
import com.example.iobejan.weather.viewmodel.ViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;

public class UserProfileFragment extends BaseFragment {
    private static final String UID_KEY = "uid";
    private final static String TAG = UserProfileFragment.class.getSimpleName();

    @Inject
    ViewModelFactory viewModelFactory;

    @BindView(R.id.tv_username) TextView tv_username;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String userId = getArguments().getString(UID_KEY);

        final UserViewModel viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel.class);

        viewModel.init(userId);
        viewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user != null)
                    tv_username.setText(user.getNickname());
            }
        });
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.user_profile_fragment;
    }

    @Override
    protected int getFragmentTitle() {
        return R.string.nav_drawer_profile;
    }

    @Override
    protected boolean isToolbarTransparent() {
        return false;
    }
}
