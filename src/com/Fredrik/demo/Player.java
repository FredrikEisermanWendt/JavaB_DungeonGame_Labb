package com.Fredrik.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.Fredrik.demo.ColorSetter.*;

public class Player extends Character {

    private final String name;
    private int intelligence;
    private int agility;
    private Weapon weapon = null;
    private List<Item> itemList = new ArrayList<>();
    private WriteScore ws = new WriteScore();
    private int monsterCount;


    //    användaren får 15 poäng att dela på strength agility och intelligence
    public Player(String name, int strength, int agility, int intelligence) {
        super(30, strength, 1, 0, 0);
        this.name = name;
        this.agility = agility;
        this.intelligence = intelligence;
    }


    @Override
    public String toString() {
        return WHITE_BOLD + name +
                BLUE + "\nLevel: " + getLevel() +
                GREEN + "\nHealth: " + getHealth() + "/" + getFullHealth() +
                RED + "\nStrength: " + getStrength() +
                CYAN + "\nAgility: " + getAgility() +
                PURPLE + "\nIntelligence: " + getIntelligence() +
                WHITE + "\nExperience: " + getExperience() + "/100" +
                YELLOW + "\nMoney: " + getMoney() + RESET;
    }


    @Override
    public void attack(Character monster) {
        int damage = calculateDamage();
        monster.looseHealth(damage);
        System.out.println("You did " + damage + " damage to the monster");
    }


    @Override
    public int calculateDamage() {
        int damage = getStrength() + getWeaponDamage();
        return didCriticalHit() ? (int) (damage * 1.5) : damage;
    }


    public int getWeaponDamage() {
        return getWeapon() == null ? 0 : getWeapon().getDamage();
    }


    public boolean didCriticalHit() {
        return isSuccessful(20 + intelligence);
    }


    @Override
    public boolean looseHealth(int damage) {
        if (didDodge()) {
            return false;
        } else {
            super.setHealth(getHealth() - damage);
            System.out.println("You have " + getHealth() + " health left");
            return true;
        }
    }


    public boolean didDodge() {
        return isSuccessful(20 + getAgility());
    }


    private boolean isSuccessful(int numberToGet) {
        Random rand = new Random();
        return rand.nextInt(0, 101) <= numberToGet;

    }


    public void getReward(Monster monster) {
        setExperience(getExperience() + monster.getExperience());
        setMoney(getMoney() + monster.getMoney());
        setMonsterCount(getMonsterCount() + 1);
        if (getExperience() >= 100) {
            levelUp();
        }
    }


    public void levelUp() {
        int temp = getExperience() % 100;
        setLevel(getLevel() + 1);
        setExperience(temp);
        setFullHealth(getFullHealth() + 10);
        setHealth(getFullHealth());
        setStrength(getStrength() + 5);
        setAgility(getAgility() + 5);
        setIntelligence(getIntelligence() + 5);
        System.out.println("You gained a level");
    }


    @Override
    public boolean isAlive() {
        if (super.isAlive()) {
            return super.isAlive();
        }
        writeFile();
        return false;
    }


    public void writeFile() {
        ws.writeScoreFile(this);
    }


    public void useItems() {
        for (Item i : itemList) {
            i.use(this);

        }
        itemList.clear();
    }


    @Override
    public String getName() {
        return name;
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


    public void setItemList(List<Item> itemList) {
        this.itemList.addAll(itemList);
    }


    public int getMonsterCount() {
        return monsterCount;
    }


    public void setMonsterCount(int monsterCount) {
        this.monsterCount = monsterCount;
    }
}
