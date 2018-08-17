package com.example.iobejan.weather.database;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.iobejan.weather.database.DAOs.UserDao;
import com.example.iobejan.weather.datamodel.User;

@android.arch.persistence.room.Database(entities = {User.class}, version = 2)
public abstract class WeatherDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
