package com.myapps.android.fbb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
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

    public void logOut(View view){
        startActivity(new Intent(UserProfile.this,LoginActivity.class));
    }

    public void allowEditing(View view){
        EditText e1= (EditText)findViewById(R.id.phone_number);
        EditText e2= (EditText)findViewById(R.id.address);
        EditText e3= (EditText)findViewById(R.id.email_address);
        EditText e4= (EditText)findViewById(R.id.dob);
        EditText e5= (EditText)findViewById(R.id.gender);
        e1.setEnabled(true);
        e2.setEnabled(true);
        e3.setEnabled(true);
        e4.setEnabled(true);
        e5.setEnabled(true);
        e1.setInputType(InputType.TYPE_CLASS_NUMBER);
        e2.setInputType(InputType.TYPE_TEXT_VARIATION_POSTAL_ADDRESS);
        e3.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        e4.setInputType(InputType.TYPE_DATETIME_VARIATION_DATE);
        e5.setInputType(InputType.TYPE_CLASS_TEXT);
    }
}
