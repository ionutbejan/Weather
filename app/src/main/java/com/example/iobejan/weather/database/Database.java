package com.example.iobejan.weather.database;

import android.arch.persistence.room.RoomDatabase;

import com.example.iobejan.weather.database.DAOs.UserDao;

@android.arch.persistence.room.Database(entities = {}, version = 1)
public abstract class Database extends RoomDatabase {
    public abstract UserDao userDao();
}
