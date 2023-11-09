package com.Fredrik.demo;

public class Monster extends Character {
//level i monster och experience kommer att påverka damage, intelligence och agility;

    public Monster(int level) {
        super(level);

    }


    @Override
    public String toString() {
        return "Monster Level: " + getLevel() + "\nHealth: " + getHealth() + "\nStrength: " + getStrength()
                + "\nExperience: " + getExperience() + "\nMoney: " + getMoney();
    }

    @Override
    public void attack(Character player) {
        if (player.looseHealth(getStrength())) {
            System.out.println("Monster connects with his attack");
        } else {
            System.out.println("Monster is to slow and misses with it's attack");
        }
    }

    @Override
    public int calculateDamage() {
        return getStrength();
    }

}
