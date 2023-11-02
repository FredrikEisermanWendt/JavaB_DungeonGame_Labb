package com.Fredrik.demo;

public class Monster extends Character {
//level i monster och experience kommer att påverka damage, intelligence och agility;

    public Monster(int level) {

        super.setLevel(level);
    }

    @Override
    public int getHealth() {
        return super.getHealth() * getLevel();
    }

    @Override
    public int getStrength() {
        return super.getStrength() * getLevel();
    }

    @Override
    public int getIntelligence() {
        return super.getIntelligence() * getLevel();
    }

    @Override
    public int getAgility() {
        return super.getAgility() * getLevel();
    }

    @Override
    public int getLevel() {
        return super.getLevel();
    }

    @Override
    public int getExperience() {
        return super.getExperience() * getLevel();
    }

    @Override
    public int getMoney() {
        return super.getMoney() * getLevel();
    }


    @Override
    public String toString() {
        return "Monster Level: " + getLevel() + "\nHealth: " + getHealth() + "\nStrength: " + getStrength() +
                "\nAgility: " + getAgility() + "\nIntelligence: " + getIntelligence() +
                "\nExperience: " + getExperience() + "\nMoney: " + getMoney();
    }
}
