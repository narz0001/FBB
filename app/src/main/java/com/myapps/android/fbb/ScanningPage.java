package com.myapps.android.fbb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ScanningPage extends AppCompatActivity {

    Button typeIt,done, initScan, historyButton;
    PopupWindow popUpWindow;
    LayoutInflater layoutInflater;
    LinearLayout rootLinear;
    private String barcodeEntered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanning_page);

//        Toolbar myToolbar = (Toolbar) findViewById(R.id.scan_page_tool_bar);
//        setSupportActionBar(myToolbar);

        typeIt = (Button)findViewById(R.id.typeIt);
        rootLinear = (LinearLayout)findViewById(R.id.rootLinear);
        initScan = (Button)findViewById(R.id.initScan);
        historyButton = (Button)findViewById(R.id.historyButton); 

        typeIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopUp();
            }
        });

        initScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanStart();
            }
        });
        
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ScanningPage.this, "Will Show Histo", Toast.LENGTH_SHORT).show();
            }
        });

    }

    void showPopUp(){
        layoutInflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        final ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.pop,null);

        popUpWindow = new PopupWindow(container, rootLinear.getMeasuredWidth() - 250,700, true);
        popUpWindow.showAtLocation(rootLinear, Gravity.CENTER, 0, 0);

        done = (Button)container.findViewById(R.id.done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUpWindow.dismiss();
                EditText enterBarCode = (EditText) container.findViewById(R.id.enterBarCode);
                barcodeEntered = enterBarCode.getText().toString();
                Toast.makeText(ScanningPage.this, "Entered Barcode: "+barcodeEntered, Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Log.d("MainActivity", "Cancelled scan");
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Log.d("MainActivity", "Scanned");
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
            }
        } else {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void scanStart(){
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Scan");
        integrator.setCameraId(0);
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(false);
        integrator.initiateScan();
    }

    public void closeActivity(View view){
        finish();
    }
}
