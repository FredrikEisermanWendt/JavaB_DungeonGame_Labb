package com.Fredrik.demo;

public abstract class Item {

    final int VALUE;
    final int PRICE;


    public Item(int value, int price) {
        this.VALUE = value;
        this.PRICE = price;
    }

    protected int getVALUE() {
        return VALUE;
    }

    public abstract void use(Player player);
}
