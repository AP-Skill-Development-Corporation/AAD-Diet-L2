package com.example.exampledb.rdb;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Update;

import java.util.List;

public class Rrepository {
    Rdatabase rdatabase;
    LiveData<List<Rtable>> list;
    public Rrepository(Application application){
        rdatabase= Rdatabase.getRdatabase(application);
        list=rdatabase.rdao().getall();

    }
    class InsertTask extends AsyncTask<Rtable,Void,Void>{

        @Override
        protected Void doInBackground(Rtable... rtables) {
            for (int i=0;i<rtables.length;i++){
                rdatabase.rdao().insert(rtables[i]);
            }
            return null;
        }
    }
    class UpdateTask extends AsyncTask<Rtable,Void,Void>{

        @Override
        protected Void doInBackground(Rtable... rtables) {
            for (int i=0;i<rtables.length;i++){
                rdatabase.rdao().update(rtables[i]);
            }
            return null;
        }
    }
    class DeleteTask extends AsyncTask<Rtable,Void,Void>{

        @Override
        protected Void doInBackground(Rtable... rtables) {
            for (int i=0;i<rtables.length;i++){
                rdatabase.rdao().delete(rtables[i]);
            }
            return null;
        }
    }
    public LiveData<List<Rtable>> readtable(){
        return list;
    }
    public void insert(Rtable rtable){
        new InsertTask().execute(rtable);
    }
    public void update(Rtable rtable){
        new UpdateTask().execute(rtable);
    }
    public void delete(Rtable rtable){
        new DeleteTask().execute(rtable);
    }
}
