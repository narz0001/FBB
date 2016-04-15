package com.myapps.android.fbb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DashBoard extends AppCompatActivity {

    Button instoreLocater, barcodeScanner, myTransaction, myWallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        instoreLocater = (Button)findViewById(R.id.instore_locater);
        barcodeScanner = (Button)findViewById(R.id.barcode_scanner);
        myTransaction = (Button)findViewById(R.id.my_transaction);
        myWallet= (Button)findViewById(R.id.my_wallet);

        instoreLocater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashBoard.this, "Will Open Instore Locater", Toast.LENGTH_SHORT).show();
            }
        });

        barcodeScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, BarcodeScanner.class);
                startActivity(intent);
            }
        });

    }
}
