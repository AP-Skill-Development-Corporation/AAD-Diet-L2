package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText name,mail,number;
Spinner branch;
RadioGroup gender;
TextView dob;
CheckBox tel,hin,eng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        mail=findViewById(R.id.email);
        number=findViewById(R.id.number);
        branch=findViewById(R.id.branch);
        gender=findViewById(R.id.rg);
        dob=findViewById(R.id.DOB);
        tel=findViewById(R.id.tel);
        hin=findViewById(R.id.hin);
        eng=findViewById(R.id.eng);
    }

    public void submit(View view) {
        String uname=name.getText().toString();
        String umail=mail.getText().toString();
        String unumber=number.getText().toString();
        int id=gender.getCheckedRadioButtonId();
        RadioButton rb=findViewById(id);

    }
}