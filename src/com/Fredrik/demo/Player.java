package com.Fredrik.demo;

import java.util.Random;

public class Player extends Character {

    private final String name;
    private int intelligence;
    private int agility;
    private int weaponDamage = 0;
    private Weapon weapon;


    //    användaren får 15 poäng att dela på strength agility och intelligence
    public Player(String name, int strength, int agility, int intelligence) {
        super(30, strength,  1, 0, 0);
        this.name = name;
        this.agility = agility;
        this.intelligence = intelligence;
    }


    public void levelUp() {
            int temp = getExperience() % 100;
            setLevel(getLevel() + 1);
            setExperience(temp);
            setHealth( getHealth() + 10);
            setStrength(getStrength() + 5);
            setAgility(getAgility() + 5);
            setIntelligence(getIntelligence() + 5);
            System.out.println("You gained a level");
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
        if(didDodge()){
            return false;
        }else {
            super.setHealth(getHealth() - damage);
            return true;
        }
    }

    @Override
    public void attack(Character monster) {
        int damage = calculateDamage();
        monster.looseHealth(damage);
        System.out.println("You did " + damage + " damage to the monster");
    }

    @Override
    public int calculateDamage() {
        if(didCriticalHit()) {
            System.out.println("You got a critical hit!");
            return (int) ((getStrength() + weaponDamage) * 1.5);
        }
        return getStrength() + weaponDamage;
    }

    public boolean didCriticalHit() {
        return isSuccessful(20 + intelligence);
    }


    public boolean didDodge() {
        return isSuccessful(20 + getAgility());
    }


    private boolean isSuccessful(int numberToGet){
        Random rand = new Random();
        if (rand.nextInt(0, 101) <= numberToGet){
            return true;
        }else{
            return false;
        }

    }

    public void getReward(Monster monster) {
        setExperience(getExperience() + monster.getExperience());
        setMoney(getMoney() + monster.getMoney());
        if(getExperience() >= 100){
            levelUp();
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
