package com.Fredrik.demo;

public class Player extends Character{

    private final String name;

//    användaren får 15 poäng att dela på strength agility och intelligence
    public Player(String name, int strength, int agility ,int intelligence) {
        this.name = name;
        super.setHealth(30);
        super.setLevel(1);
        super.setStrength(strength);
        super.setAgility(agility);
        super.setIntelligence(intelligence);
        super.setExperience(0);
        super.setMoney(0);
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nHealth: " + getHealth() + "\nLevel: " + getLevel() + "\nStrength: " + getStrength() +
                "\nAgility: " + getAgility() + "\nIntelligence: " + getIntelligence() +
                "\nExperience: " + getExperience() + "\nMoney: " + getMoney();
    }
}
