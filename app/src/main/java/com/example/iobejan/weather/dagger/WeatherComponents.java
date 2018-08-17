package com.example.iobejan.weather.dagger;

import android.app.Application;

import com.example.iobejan.weather.application.Weather;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules={ActivityModule.class, FragmentModule.class, AppModule.class})
public interface WeatherComponents {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        WeatherComponents build();
    }

    void inject(Weather weatherApp);
}
