package com.Fredrik.demo;

import java.util.Random;

public class Player extends Character {

    private final String name;
    private int intelligence;
    private int agility;
    private Weapon weapon;


    //    användaren får 15 poäng att dela på strength agility och intelligence
    public Player(String name, int strength, int agility, int intelligence) {
        super(30, strength,  1, 0, 0);
        this.name = name;
        this.agility = agility;
        this.intelligence = intelligence;
    }


    public void fight() {

    }

    public void levelUp() {
        if (getExperience() > 100) {
            int temp = getExperience() % 100;
            setLevel(1);
        }
    }

    @Override
    public void setLevel(int level) {
        super.setLevel(getLevel() + level);
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nHealth: " + getHealth() + "\nLevel: " + getLevel() + "\nStrength: " + getStrength() +
                "\nAgility: " + getAgility() + "\nIntelligence: " + getIntelligence() +
                "\nExperience: " + getExperience() + "\nMoney: " + getMoney();
    }

    @Override
    public boolean looseHealth(int damage) {
        if(didDodge(getAgility())){
            return false;
        }else {
            super.setHealth(damage);
            return true;
        }
    }

    @Override
    public void attack(Character monster) {
        monster.looseHealth(calculateDamage());
    }

    @Override
    public int calculateDamage() {
        if(didCriticalHit()) {
            return (int) ((getStrength() + weapon.getDamage()) * 1.5);
        }
        return getStrength() + weapon.getDamage();
    }

    public boolean didCriticalHit() {
        return isSuccsessfull(20 + intelligence);
    }


    public boolean didDodge(int agility) {
        return isSuccsessfull(20 + getAgility());
    }


    private boolean isSuccsessfull(int numberToGet){
        Random rand = new Random();
        if (rand.nextInt(0, 101) <= numberToGet){
            return true;
        }else{
            return false;
        }

    }


    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
