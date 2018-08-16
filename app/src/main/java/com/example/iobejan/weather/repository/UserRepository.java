package com.example.iobejan.weather.repository;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.iobejan.weather.database.DAOs.UserDao;
import com.example.iobejan.weather.datamodel.User;

import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserRepository {
    private final UserDao userDao;
    private final Executor executor;

    @Inject
    public UserRepository(UserDao userDao, Executor executor){
        this.userDao = userDao;
        this.executor = executor;
    }

    public LiveData<User> getUser(String userId){
        refreshUser(userId);

        return userDao.load(userId);
    }

    private void refreshUser(final String userId){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                boolean exists = userDao.load(userId) != null;

                if (!exists){
                    // refresh data (Facebook / Google)
                    // using dummy user for now
                    User user = new User();
                    user.setId(1);
                    user.setEmail("test@yahoo.com");
                    user.setName("Test Account");
                    userDao.save(user);
                }
            }
        });
    }
}
