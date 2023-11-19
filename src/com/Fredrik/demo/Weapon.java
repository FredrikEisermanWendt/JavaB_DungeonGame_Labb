package com.Fredrik.demo;

public class Weapon extends Item {

    private final String name = "Travelers sword";


    public Weapon() {
        super(10, 30, "weapon");
    }


    @Override
    public void use(Player player) {
        player.setWeapon(this);
    }


    public int getDamage() {
        return super.getValue();

    }


    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Weapon, " + name + ", price: " + getPrice();
    }
}
