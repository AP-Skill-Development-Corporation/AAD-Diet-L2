package com.example.exampledb.rdb;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class Rviewmodel extends AndroidViewModel {
    Rrepository rrepository;
    LiveData<List<Rtable>> list;
    public Rviewmodel(@NonNull Application application) {
        super(application);
        rrepository=new Rrepository(application);
        list=rrepository.readtable();
    }
    public void insert(Rtable rtable){
        rrepository.insert(rtable);
    }
    public void update(Rtable rtable){
        rrepository.update(rtable);
    }
    public void delete(Rtable rtable){
        rrepository.delete(rtable);
    }
    public LiveData<List<Rtable>> readdata(){
        return list;
    }
}
