package com.Fredrik.demo;

public class Player extends Character{

    private final String name;

//    användaren får 15 poäng att dela på strength agility och intelligence
    public Player(String name, int strength, int agility ,int intelligence) {
        super(30, strength, intelligence, agility, 1,0, 0);
        this.name = name;
    }


    public void fight(){

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
