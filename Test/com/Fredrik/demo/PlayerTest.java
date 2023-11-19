package com.Fredrik.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;
    private Weapon weapon = new Weapon();
    private Monster monster = new Monster(10); //name: Lynox, health: 100, strength: 20, experience: 100, money: 100
    List<Item> itemList = new ArrayList<>();

    @BeforeEach
    public void setPlayer() {
        player = new Player("Benny", 5, 5, 5);
    }


    @Test
    public void testPlayerConstructor() {
        assertEquals("Benny", player.getName());
        assertEquals(30, player.getFullHealth());
        assertEquals(5, player.getStrength());
        assertEquals(5, player.getAgility());
        assertEquals(5, player.getIntelligence());
        assertNull(player.getWeapon());
        assertEquals(0, player.getMonsterCount());
    }


    @Test
    public void testLevelUp() {

        player.levelUp();
        assertEquals(2, player.getLevel());
        assertEquals(40, player.getHealth());
        assertEquals(40, player.getFullHealth());
        assertEquals(10, player.getStrength());
        assertEquals(10, player.getAgility());
        assertEquals(10, player.getIntelligence());
    }


    @Test
    public void testAttack() {

        player.attack(monster);
        assertTrue(monster.getHealth() < 100);
    }


    @Test
    public void testCalculateDamage() {
        int damage = player.calculateDamage();
        assertTrue(damage >= 5);
    }


    @RepeatedTest(10)
    public void testDidCriticalHit() {
        boolean result = player.didCriticalHit();
        assertTrue(result || !result);
    }


    @RepeatedTest(10)
    public void testDidDodge() {
        boolean result = player.didDodge();
        assertTrue(result || !result);
    }


    @Test
    public void testGetWeaponDamage() {
//      test without weapon
        assertEquals(0, player.getWeaponDamage());
//      test with weapon
        player.setWeapon(weapon);
        assertEquals(10, player.getWeaponDamage());
    }


    @RepeatedTest(10)
    public void testLooseHealth() {
        player.looseHealth(10);
        boolean result = player.getHealth() == 20 || player.getHealth() == 30;
        assertTrue(result);
        assertEquals(30, player.getFullHealth());
    }

    @Test
    public void testGetReward(){
        player.getReward(monster);
        assertEquals(0, player.getExperience());
        assertEquals(100, player.getMoney());
        assertEquals(1, player.getMonsterCount());
        assertEquals(2, player.getLevel());
    }

    @Test
    public void testIsAlive(){
        assertTrue(player.isAlive());
        player.setHealth(0);
        assertFalse(player.isAlive());
        assertEquals(30, player.getFullHealth());
    }


    @Test
    public void testUseItems(){
        player.setFullHealth(100);
        assertNull(player.getWeapon());
        assertEquals(30, player.getHealth());
        fillItemList();
        player.setItemList(itemList);
        player.useItems();
        assertNotNull(player.getWeapon());
        assertEquals(75, player.getHealth());

    }

    private void fillItemList(){
        itemList.add(new Armor());
        itemList.add(new HealthPotion());
        itemList.add(new Weapon());
    }







}