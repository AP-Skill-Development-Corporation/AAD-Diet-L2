package com.example.exampledb.rdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Rtable.class},version = 1,exportSchema = false)
public abstract class Rdatabase extends RoomDatabase {
    public abstract Rdao rdao();
    public static Rdatabase rdatabase;
    public static synchronized Rdatabase getRdatabase(Context context){
        if (rdatabase==null){
            rdatabase= Room.databaseBuilder(context,
                    Rdatabase.class,"Myroom")
                    .allowMainThreadQueries().build();
        }
        return rdatabase;
    }

}
