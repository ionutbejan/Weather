package com.example.iobejan.weather.dagger;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.iobejan.weather.database.DAOs.UserDao;
import com.example.iobejan.weather.database.WeatherDatabase;
import com.example.iobejan.weather.repository.UserRepository;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ViewModelModule.class)
public class AppModule {

    // --- DATABASE INJECTION ---

    @Provides
    @Singleton
    WeatherDatabase provideDatabase(Application application) {
        return Room.databaseBuilder(application,
                WeatherDatabase.class, "WeatherDatabase.db")
                .build();
    }

    @Provides
    @Singleton
    UserDao provideUserDao(WeatherDatabase database) { return database.userDao(); }

    // --- REPOSITORY INJECTION ---

    @Provides
    Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository(UserDao userDao, Executor executor) {
        return new UserRepository(userDao, executor); // here might pass another argument Webservice
    }
}
