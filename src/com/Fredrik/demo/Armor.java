package com.Fredrik.demo;

public class Armor extends Item {




    public Armor() {
        super(30, 15, "armor");
    }


    @Override
    public void use(Player player) {
        player.setHealth(player.getHealth() + getValue());
    }

    @Override
    public String toString() {
        return "Armor: price: " + getPrice();
    }
}
