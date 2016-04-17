package com.myapps.android.fbb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class DashBoard extends AppCompatActivity {

    Button instoreLocater, barcodeScanner, myTransaction, myWallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        final Activity activity = this;

        instoreLocater = (Button) findViewById(R.id.instore_locater);
        barcodeScanner = (Button) findViewById(R.id.barcode_scanner);
        myTransaction = (Button) findViewById(R.id.my_transaction);
        myWallet = (Button) findViewById(R.id.my_wallet);

        instoreLocater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashBoard.this, R.string.no_implementation, Toast.LENGTH_SHORT).show();
            }
        });

        barcodeScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, BarcodeScanner.class);
                startActivity(intent);
            }
        });

        myTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashBoard.this, R.string.no_implementation, Toast.LENGTH_SHORT).show();
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
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

    public void displayToast(View view){
        Toast.makeText(getApplicationContext(),R.string.no_implementation, Toast.LENGTH_SHORT).show();
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

            case R.id.menu:
                popup(item.getItemId());
                item.setIcon(R.mipmap.ic_arrow_back_white_24dp);
                return true;

            case R.id.user:
                Toast.makeText(this,R.string.no_implementation, Toast.LENGTH_LONG).show();
                return true;

            case R.id.notifications:
                Toast.makeText(this,R.string.no_implementation, Toast.LENGTH_LONG).show();
                return true;

            case R.id.shopping_cart:
                Toast.makeText(this,R.string.no_implementation, Toast.LENGTH_LONG).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void popup(int itemId){
        PopupMenu popup = new PopupMenu(getSupportActionBar().getThemedContext(),findViewById(itemId));
        popup.getMenuInflater().inflate(R.menu.dropdown_menu,popup.getMenu());
        popup.show();
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item2) {
                switch (item2.getItemId()) {
                    case R.id.menu_about_app:
                        Toast.makeText(getApplicationContext(),R.string.no_implementation, Toast.LENGTH_LONG).show();
                        break;

                    case R.id.menu_help:
                        Toast.makeText(getApplicationContext(),R.string.no_implementation, Toast.LENGTH_LONG).show();
                        break;

                    case R.id.menu_home:
                        Toast.makeText(getApplicationContext(),R.string.no_implementation, Toast.LENGTH_LONG).show();
                        break;

                    case R.id.menu_logout:
                        Toast.makeText(getApplicationContext(),R.string.no_implementation, Toast.LENGTH_LONG).show();
                        break;

                    case R.id.menu_my_account:
                        Toast.makeText(getApplicationContext(),R.string.no_implementation, Toast.LENGTH_LONG).show();
                        break;

                    case R.id.menu_notif_pref:
                        Toast.makeText(getApplicationContext(),R.string.no_implementation, Toast.LENGTH_LONG).show();
                        break;

                    case R.id.menu_rate:
                        Toast.makeText(getApplicationContext(),R.string.no_implementation, Toast.LENGTH_LONG).show();
                        break;

                }

                return true;
            }
        });

    }
}
