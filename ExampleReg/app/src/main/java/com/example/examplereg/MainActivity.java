package com.example.examplereg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,upass;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.uname);
        upass=findViewById(R.id.password);
        sp=getSharedPreferences("DIET",MODE_PRIVATE);
    }

    public void login(View view) {
        String name=username.getText().toString();
        String password=upass.getText().toString();
        if (name.isEmpty()|password.isEmpty()){
            Toast.makeText(this, "Please fill all the details",
                    Toast.LENGTH_SHORT).show();
        }
        else if (name.equals(sp.getString("uname",null))
                &(password.equals(sp.getString("upass",null)))){
            Log.i("Diet","Authentication Successful");
            username.setText("");
            upass.setText("");
        }
        else{
            Log.i("Diet","Invalid Credentials");
        }
    }

    public void register(View view) {
        String name=username.getText().toString();
        String password=upass.getText().toString();
        if (name.isEmpty()|password.isEmpty()){
            Toast.makeText(this, "Please fill all the details",
                    Toast.LENGTH_SHORT).show();
        }
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("uname",name);
        editor.putString("upass",password);
        editor.commit();
        username.setText("");
        upass.setText("");
        Toast.makeText(this, "Successfully registered",
                Toast.LENGTH_SHORT).show();

    }
}