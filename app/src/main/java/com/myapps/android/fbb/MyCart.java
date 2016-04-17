package com.myapps.android.fbb;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;

public class MyCart extends AppCompatActivity {

    private CartAdapter myCart;

    String sampleString[] = {
        "Pant 42 2 560 1400",
            "Shirt 36 1 480 1200",
            "Shoes 9 1 4800 8000"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);


        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_cart_tool_bar);
        setSupportActionBar(myToolbar);

        myCart = new CartAdapter(
                this,new ArrayList<CartItem>());


        ListView listView = (ListView)findViewById(R.id.cart);
        listView.setAdapter(myCart);

        GetData getData = new GetData();

        getData.execute(sampleString);
    }


    //Database Related Work Here
    //  Have included a sample String
    private class GetData extends AsyncTask<String[], Void, String[][]>{
        @Override
        protected String[][] doInBackground(String[]... params) {

            String answer[][] = new String[params[0][0].length()][5];

            for(int i=0; i<params[0].length; i++){
                String temp[] = params[0][i].split(" ");
                for(int j=0 ; j< temp.length; j++){
                    answer[i][j] = temp[j];
                }
            }
            return answer;
        }

        @Override
        protected void onPostExecute(String[][] strings) {
            if(strings!=null){
                myCart.clear();
                CartItem cartItem;
                for (int i=0; i<3 ; i++){
                    cartItem = new CartItem(strings[i]);
                    myCart.add(cartItem);
                }
            }
        }
    }

}
