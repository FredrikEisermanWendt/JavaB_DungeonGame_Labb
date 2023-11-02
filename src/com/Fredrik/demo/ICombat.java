package com.Fredrik.demo;

public interface ICombat {

    void attack(Character character);
    int calculateDamage( int weaponDamage);
    boolean didCriticalHit(int intelligence);
    boolean didDodge(int agility);


}
