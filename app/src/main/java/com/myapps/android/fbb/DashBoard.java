package com.myapps.android.fbb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DashBoard extends AppCompatActivity {

    Button instoreLocater, barcodeScanner, myTransaction, myWallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(myToolbar);
        //getSupportActionBar().setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        final Activity activity = this;

        instoreLocater = (Button)findViewById(R.id.instore_locater);
        barcodeScanner = (Button)findViewById(R.id.barcode_scanner);
        myTransaction = (Button)findViewById(R.id.my_transaction);
        myWallet= (Button)findViewById(R.id.my_wallet);

        instoreLocater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashBoard.this, R.string.no_implementation, Toast.LENGTH_SHORT).show();
            }
        });

        barcodeScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, ScanningPage.class);
                startActivity(intent);
            }
        });

        myTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this,MyCart.class);
                startActivity(intent);
            }
        });

        myWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashBoard.this, R.string.no_implementation, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dashboard,menu);
        //return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.menu_logout:
                Toast.makeText(this,R.string.no_implementation, Toast.LENGTH_LONG).show();
                return true;

            case R.id.menu_about_app:
                Toast.makeText(this,R.string.no_implementation, Toast.LENGTH_LONG).show();
                return true;

            case R.id.menu_help:
                Toast.makeText(this,R.string.no_implementation, Toast.LENGTH_LONG).show();
                return true;

            case R.id.menu_home:
                Toast.makeText(this,R.string.no_implementation, Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_my_account:
                Toast.makeText(this,R.string.no_implementation, Toast.LENGTH_LONG).show();
                return true;

            case R.id.menu_notif_pref:
                Toast.makeText(this,R.string.no_implementation, Toast.LENGTH_LONG).show();
                return true;

            case R.id.menu_rate:
                Toast.makeText(this,R.string.no_implementation, Toast.LENGTH_LONG).show();
                return true;

            case R.id.user:
                Toast.makeText(this,R.string.no_implementation, Toast.LENGTH_LONG).show();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
