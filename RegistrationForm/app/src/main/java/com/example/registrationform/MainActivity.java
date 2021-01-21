package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

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
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c=Calendar.getInstance();
                int y=c.get(Calendar.YEAR);
                int m=c.get(Calendar.MONTH);
                int d=c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dpd=new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                dob.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                            }
                        },y,m,d);
                dpd.show();
            }
        });

    }

    public void submit(View view) {
        String uname=name.getText().toString();
        String umail=mail.getText().toString();
        String unumber=number.getText().toString();
        int id=gender.getCheckedRadioButtonId();
        RadioButton rb=findViewById(id);
        String b=branch.getSelectedItem().toString();

        StringBuilder sb=new StringBuilder();
        if(tel.isChecked())
        {
            sb.append("telugu"+"\n");
        }
        if(hin.isChecked())
        {
            sb.append("hindi"+"\n");
        }
        if(eng.isChecked())
        {
            sb.append("english");
        }
    Log.i("DIET",uname+"\n"+
            umail+"\n"+
            unumber+"\n"+
            rb.getText()+"\n"+
            b+"\n"+
            sb.toString());
    }
}