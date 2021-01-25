package com.example.exampledb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exampledb.rdb.Rtable;
import com.example.exampledb.rdb.Rviewmodel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    EditText sroll,sname,snumber;
    public static Rviewmodel rviewmodel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        sroll=findViewById(R.id.sroll);
        sname=findViewById(R.id.sname);
        snumber=findViewById(R.id.snumber);
        rviewmodel=new ViewModelProvider(this)
                .get(Rviewmodel.class);
        rviewmodel.readdata().observe(this, new Observer<List<Rtable>>() {
            @Override
            public void onChanged(List<Rtable> rtables) {
                MyAdapter myAdapter=new MyAdapter(MainActivity.this,rtables);
                rv.setAdapter(myAdapter);
                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }
        });
    }

    public void save(View view) {
        String roll=sroll.getText().toString();
        String name=sname.getText().toString();
        String number=snumber.getText().toString();
        Rtable rtable=new Rtable();
        rtable.setRollno(roll);
        rtable.setName(name);
        rtable.setNumber(number);
        rviewmodel.insert(rtable);
        Toast.makeText(this, "Data inserted", Toast.LENGTH_SHORT).show();
    }
}