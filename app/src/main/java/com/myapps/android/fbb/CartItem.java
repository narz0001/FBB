package com.myapps.android.fbb;

public class CartItem {

    String itemName, itemSize, itemQty, itemPrice, origPrice;

    public CartItem(String result[]) {
        itemName = result[0];
        itemSize = result[1];
        itemQty = result[2];
        itemPrice = result[3];
        origPrice = result[4];
    }


}
