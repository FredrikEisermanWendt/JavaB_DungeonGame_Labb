package com.Fredrik.demo;

public abstract class Character implements ICombat {

    // TODO: 2023-11-02 Ta bort intelligence och agility från Character och lägg  i Player
    private String name = "";
    private int fullHealth = 10;
    private int health = 10;
    private int strength = 2;
    private int level = 1;
    private int experience = 10;
    private int money = 10;



    public Character(int level) {
        this.level = level;
        health = health * level;
        fullHealth = health;
        strength = strength * level;
        experience = experience * level;
        money = money * level;


    }

    public Character(int health, int strength, int level, int experience, int money) {
        fullHealth = health;
        this.health = health;
        this.strength = strength;
        this.level = level;
        this.experience = experience;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFullHealth() {
        return fullHealth;
    }

    public void setFullHealth(int fullHealth) {
        this.fullHealth = fullHealth;
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

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
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

    public boolean looseHealth(int damage) {
        setHealth(getHealth() - damage);
        return true;
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }

}
