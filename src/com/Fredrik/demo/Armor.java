package com.Fredrik.demo;

public class Armor extends Item  {


    public Armor() {
        super(30, 15);
    }


    @Override
    public void use(Player player) {
        player.setHealth( player.getHealth() + getVALUE());
    }
}
