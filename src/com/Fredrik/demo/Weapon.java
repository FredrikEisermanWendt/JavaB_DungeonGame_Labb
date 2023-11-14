package com.Fredrik.demo;

public class Weapon extends Item {

    public Weapon(){
        super(10, 30);
    }

    @Override
    public void use(Player player) {
        player.setWeapon(this);
    }


    public int getDamage() {
        return super.getVALUE();

    }


}
