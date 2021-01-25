package com.example.exampledb.rdb;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Rtable {
    @NonNull
    public String getRollno() {
        return rollno;
    }

    public void setRollno(@NonNull String rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }



    @PrimaryKey
    @NonNull
    String rollno;
    String name,number;

}
