package com.example.exampledb.rdb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Rdao {
    @Query("select * from Rtable")
    LiveData <List<Rtable>> getall();

    @Insert
    void insert(Rtable rtable);

    @Delete
    void delete(Rtable rtable);

    @Update
    void update(Rtable rtable);
}
