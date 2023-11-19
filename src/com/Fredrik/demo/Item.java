package com.Fredrik.demo;

public abstract class Item {

    final int VALUE;
    final int PRICE;
    final String TYPE;


    public Item(int value, int price, String type) {
        VALUE = value;
        PRICE = price;
        TYPE = type;
    }


    public int getValue() {
        return VALUE;
    }


    public int getPrice() {
        return PRICE;
    }


    public String getTYPE() {
        return TYPE;
    }


    public abstract void use(Player player);
}
