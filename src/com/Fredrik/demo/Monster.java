package com.Fredrik.demo;

public class Monster extends Character {
//level i monster och experience kommer att påverka damage, intelligence och agility;

    public Monster( int level) {
        super(level);

    }

    @Override
    public String toString() {
        return "Monster Level: " + getLevel() + "\nHealth: " + getHealth() + "\nStrength: " + getStrength() +
                "\nAgility: " + getAgility() + "\nIntelligence: " + getIntelligence() +
                "\nExperience: " + getExperience() + "\nMoney: " + getMoney();
    }

    @Override
    public void attack(Character player) {

    }

    @Override
    public int calculateDamage(int strength, int weaponDamage) {
        return 0;
    }

    @Override
    public boolean didCriticalHit(int intelligence) {
        return false;
    }

    @Override
    public boolean didDodge(int agility) {
        return false;
    }
}
