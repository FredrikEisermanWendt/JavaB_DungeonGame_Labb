package com.Fredrik.demo;

import java.util.ArrayList;
import java.util.List;

import static com.Fredrik.demo.ColorSetter.RED;
import static com.Fredrik.demo.ColorSetter.RESET;

public class Game {

    private List<Monster> monsterList = new ArrayList<>();
    private Monster boss = new Monster(20);
    private CustomScanner scan = new CustomScanner();
    private Player player;
    private Shop shop;


    public Game() {
        System.out.println("Welcome adventurer");
        setPlayer();
        shop = new Shop(player);
        setMonsterList();
        gameMenu();
    }


    private void setMonsterList() {
        for (int i = 0; i < 10; i++) {
            monsterList.add(new Monster(i + 1));
        }
    }


    private void setPlayer() {
        int statPoints = 15;
        String name = scan.registerString("What is your name");
        System.out.println(name + " What a distinguished name!");
        System.out.println("""
                You have 15 points to distribute between, Strength, Intelligence and Agility
                You must give each attribute at least 1 point
                Choose wisely""");
        int strength = getPlayerStatsFromUser("Strength", statPoints - 2);
        statPoints -= strength;
        int intelligence = getPlayerStatsFromUser("Intelligence", statPoints - 1);
        statPoints -= intelligence;
        System.out.println("What is left is added to your Agility: " + statPoints);
        player = new Player(name, strength, intelligence, statPoints);

    }


    private int getPlayerStatsFromUser(String stat, int statPoints) {
        do {
            int temp = scan.registerInt("For " + stat + ", give me a number between 1 and " + statPoints);
            if (temp > statPoints || temp < 1) {
                System.out.println("Are you trying to cheat my friend, try again!");
            } else {
                return temp;
            }
        } while (true);
    }


    private void gameMenu() {
        boolean isPlaying = true;
        do {
            // TODO: 2023-11-02 finish menu
            System.out.println("""
                    1: Fight a monster
                    2: Fight the boss
                    3: Get your status
                    4: Buy items
                    5: Go back to Title Menu, all progress will be lost""");
            switch (scan.registerString("")) {
                case "1" -> fightMonster(getMonster());
                case "2" -> fightBoss(getBoss());
                case "3" -> System.out.println(player);
                case "4" -> shop.buyItems();
                case "5" -> endGame();

                default -> System.out.println("Wrong input " + player.getName());
            }
        } while (isPlaying);
    }


    private void fightMonster(Monster monster) {
        if (monsterList == null) {
            System.out.println("You have beaten all the monsters, now please slay the " + RED + boss.getName() + RESET);
        } else {
            fightMonsterMenu(monster);
        }
    }


    private void fightBoss(Monster boss) {
        if (!monsterList.isEmpty()) {
            System.out.println("You must beat all the monsters before you can fight the boss");
        } else {
            fightMonsterMenu(boss);
        }
    }


    private void fightMonsterMenu(Monster monster) {
        boolean isFighting = true;
        System.out.println("You Stumbled upon a " + monster);
        do {
            System.out.println("""
                    1: Attack
                    2: Show Battle status
                    3: Try to run
                    """);
            switch (scan.registerString("")) {
                case "1" -> attackSequence(monster);
                case "2" -> System.out.println(player + "\n\n" + monster);
                case "3" -> {
                    if (escapeFight(monster)) {
                        return;
                    }
                }
                default -> System.out.println("Wrong input " + player.getName());
            }
            isFighting = monster.isAlive();

        } while (isFighting);
        if (monster.equals(getBoss())){
//            playWonGameScene();
        }
    }


    private boolean escapeFight(Monster monster) {
        if (player.didDodge()) {
            System.out.println("You got away");
            return true;
        } else {
            System.out.println("You failed to escape");
            monster.attack(player);
            return false;
        }

    }


    private void attackSequence(Monster monster) {
        player.attack(monster);
        if (!monster.isAlive()) {
            System.out.println("You defeated the monster");
            player.getReward(monster);
            monsterList.remove(monster);
        } else {
            // TODO: 2023-11-18  behöver fixa vad som händer om player dör
            monster.attack(player);
            if (!player.isAlive()){
//                playLostGameScene();
            }
        }
    }


    private void endGame() {
        System.out.println("Thank you for playing!");
        System.exit(0);
    }


    private Monster getBoss() {
        return boss;
    }


    private Monster getMonster() {
        return !monsterList.isEmpty() ? monsterList.get(0) : null;
    }


}
