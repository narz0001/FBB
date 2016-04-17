package com.myapps.android.fbb;

import android.app.Activity;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CartAdapter extends ArrayAdapter<CartItem> {

    public CartAdapter(Activity context, List<CartItem> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CartItem cartItem = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cart_item,parent,false);
        }

        TextView itemName, size, qty, price, numItems,origPrice;

        itemName = (TextView)convertView.findViewById(R.id.cartItem);
        itemName.setText(cartItem.itemName);

        size = (TextView)convertView.findViewById(R.id.size);
        size.setText(cartItem.itemSize);

        qty = (TextView)convertView.findViewById(R.id.quantity);
        qty.setText(cartItem.itemQty);

        price = (TextView)convertView.findViewById(R.id.price);
        price.setText("Rs. "+cartItem.itemPrice);

        float discount = (Float.parseFloat(cartItem.itemPrice)/Float.parseFloat(cartItem.origPrice))*100;
        int discountInt = (int)discount;
        String origPriceText = "Rs. "+cartItem.origPrice+ "("+discountInt+"% off)";

        origPrice = (TextView)convertView.findViewById(R.id.origPrice);
        origPrice.setText(origPriceText);
        origPrice.setPaintFlags(origPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        origPrice.setTextColor(convertView.getResources().getColor(R.color.red));

        return convertView;
    }
}
