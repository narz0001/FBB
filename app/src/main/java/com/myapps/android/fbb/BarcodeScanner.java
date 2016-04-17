package com.myapps.android.fbb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class BarcodeScanner extends AppCompatActivity {

    Button typeIt;
    PopupWindow popUpWindow;
    LayoutInflater layoutInflater;
    LinearLayout rootLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_scanner);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        typeIt = (Button)findViewById(R.id.typeIt);
//        rootLinear = (LinearLayout)findViewById(R.id.rootLinear);
//
//        typeIt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showPopUp();
//            }
//        });
    }

    void showPopUp(){
        layoutInflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.pop,null);

        popUpWindow = new PopupWindow(container, rootLinear.getMeasuredWidth() - 100, rootLinear.getMeasuredHeight(), true);
        popUpWindow.showAtLocation(rootLinear, Gravity.CENTER, 0, 0);


    }
}
