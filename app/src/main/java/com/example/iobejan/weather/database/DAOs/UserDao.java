package com.example.iobejan.weather.database.DAOs;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.iobejan.weather.datamodel.User;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {
    @Insert(onConflict = REPLACE)
    void save(User user);

    /**
     * @param userId
     * @return User associated with this id
     */
    @Query("Select * FROM user WHERE id = :userId")
    LiveData<User> load(String userId);
}
