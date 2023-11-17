package com.Fredrik.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Monster extends Character {

    List<String> monsterNameList = Arrays.asList("Keese", "ChuChu", "Octorok", "Bokoblin", "Moblin", "Lizalfos", "Horriblin", "Gibdo", "Stone Tallus", "Lynox", "King Gleok");

    public Monster(int level) {
        super(level);
        setName(getName());

    }


    @Override
    public String toString() {
        return getName() + "\nHealth: " + getHealth() + "\nStrength: " + getStrength()
                + "\nExperience: " + getExperience() + "\nMoney: " + getMoney();
    }

    @Override
    public void attack(Character player) {
        if (player.looseHealth(getStrength())) {
            System.out.println("Monster connects with his attack");
            System.out.println("You lost " + calculateDamage() + " health");
        } else {
            System.out.println("Monster is to slow and misses with it's attack");
        }
    }

    @Override
    public int calculateDamage() {
        return getStrength();
    }

    @Override
    public String getName() {
        if (getLevel() == 20){
            return monsterNameList.get(monsterNameList.size() - 1);
        }else if (getLevel() > monsterNameList.size() && getLevel() != 20){
            return "Error; Monster name not found";
        }else {
            return monsterNameList.get(getLevel()-1);
        }

    }


}
