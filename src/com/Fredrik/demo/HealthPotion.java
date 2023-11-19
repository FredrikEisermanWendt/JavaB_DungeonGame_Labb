package com.Fredrik.demo;

public class HealthPotion extends Item {

    public HealthPotion() {
        super(15, 10, "healthPotion");
    }


    public int hpToRevive() {
        return getValue();
    }


    @Override
    public void use(Player p) {
        p.setHealth(Math.min(p.getHealth() + hpToRevive(), p.getFullHealth()));
    }


    @Override
    public String toString() {
        return "Health potion, price: " + getPrice();
    }
}
