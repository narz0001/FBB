package com.myapps.android.fbb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

public class UserProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_user_profile);
    }

    public void closeActivity(View view){
        finish();
    }

    public void allowEditing(View view){
        EditText e1= (EditText)findViewById(R.id.phone_number);
        EditText e2= (EditText)findViewById(R.id.address);
        EditText e3= (EditText)findViewById(R.id.email_address);
        EditText e4= (EditText)findViewById(R.id.dob);
        EditText e5= (EditText)findViewById(R.id.gender);
        e1.setInputType(phone);
        e2.setInputType(text);
        e3.setInputType(textEmailAddress);
        e4.setInputType(date);
        e5.setInputType(text);
    }
}
