package com.Fredrik.demo;

public abstract class Character {

    private int health = 10;
    private int strength = 2;
    private int intelligence = 2;
    private int agility = 2;
    private int level = 1;
    private int experience = 10;
    private int money  = 10;
    private final int BASE_DAMAGE = 10;

    public Character(){

    }

    public Character(int health, int strength, int intelligence, int agility, int level, int experience, int money) {
        this.health = health;
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.level = level;
        this.experience = experience;
        this.money = money;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getBASE_DAMAGE() {
        return BASE_DAMAGE;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
