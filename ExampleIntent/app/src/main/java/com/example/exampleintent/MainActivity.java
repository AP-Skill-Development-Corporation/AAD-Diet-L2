package com.example.exampleintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //Declare the views globally
EditText name,number,link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Instantiate or initialise the views here
        name=findViewById(R.id.name);
        number=findViewById(R.id.number);
        link=findViewById(R.id.link);
        Log.i("DIET","Activity Created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("DIET","Activity Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("DIET","Activity Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("DIET","Activity Paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("DIET","Activity Stopped");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("DIET","Activity Restarted");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("DIET","Activity Destroyed");
    }

    public void send(View view) {
        String n=name.getText().toString();
        //navigating from one screen to another screen in same application is called explicit intent
        Intent i=new Intent(this,SecondActivity.class);
        i.putExtra("name",n);
        startActivity(i);
    }

    public void call(View view) {
        String n=number.getText().toString();
        Uri u=Uri.parse("tel:"+n);
        Intent i=new Intent(Intent.ACTION_DIAL,u);
        startActivity(i);
    }

    public void search(View view) {
        String l=link.getText().toString();
        Uri u=Uri.parse("http:"+l);
        Intent i=new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }
}