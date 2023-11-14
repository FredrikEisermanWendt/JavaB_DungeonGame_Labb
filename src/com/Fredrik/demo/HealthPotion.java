package com.Fredrik.demo;

public class HealthPotion extends Item {

    public HealthPotion() {
        super(15, 10);
    }

    public int hpToRevive() {
        return getVALUE();
    }

    @Override
    public void use(Player p) {
        p.setHealth(Math.min(p.getHealth() + hpToRevive(), p.getFullHealth()));
    }
}
