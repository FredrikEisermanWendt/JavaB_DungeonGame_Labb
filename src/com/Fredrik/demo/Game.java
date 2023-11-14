package com.Fredrik.demo;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Monster> monsterList = new ArrayList<>();
    private Monster boss = new Monster(20);
    private CustomScanner scan = new CustomScanner();
    private Player player;
    private Shop shop = new Shop();

    public Game() {
        titleMenu();
        System.out.println("Welcome adventurer");
        setPlayer();
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
        System.out.println("You have 15 points to distribute between, Strength, Intelligence and Agility, chose wisely");
        int strength = getPlayerStatsFromUser("Strength", statPoints);
        statPoints -= strength;
        int intelligence = getPlayerStatsFromUser("Intelligence", statPoints);
        statPoints -= intelligence;
        player = new Player(name, strength, intelligence, statPoints);

    }

    private int getPlayerStatsFromUser(String stat, int statPoints) {
        do {
            int temp = scan.registerInt("For " + stat + ", give me a number between 1 and " + statPoints);
            if (temp > statPoints) {
                System.out.println("Are you trying to cheat my friend, try again!");
            } else {
                return temp;
            }
        } while (true);
    }

    private void titleMenu() {
        boolean isPlaying = true;
        System.out.println("""
                1: Start the game
                2: Quit the game""");
        do {
            switch (scan.registerString("")) {
                case "1" -> {
                    System.out.println("Lets get started!");
                    isPlaying = false;
                }
                case "2" -> System.exit(0);
                default -> System.out.println("Error: wrong input");
            }
        } while (isPlaying);
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
                case "1" -> fightMonsterMenu(0);
                case "2" -> fightMonsterMenu(1);
                case "3" -> System.out.println(player);
//                case "4" -> shop.buyItems;
                case "5" -> {
                    titleMenu();
                    isPlaying = false;
                }
                default -> System.out.println("Wrong input " + player.getName());
            }
        } while (isPlaying);
    }

    private void fightMonsterMenu(int i) {
        boolean isPlaying = true;
        Monster monster = getMonster(i);
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
                case "3" -> isPlaying = !escapeFight(monster);
                default -> System.out.println("Wrong input " + player.getName());
            }
            isPlaying = monster.isAlive();

        } while (isPlaying);
    }

    // TODO: 2023-11-09 Felhantera att monstererna är slut i listan
    private Monster getMonster(int i) {
        return i == 1 ? boss : monsterList.get(0);
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
            player.getReward(monster);
            monsterList.remove(monster);
        } else {
//            behöver fixa vad som händer om player dör
            monster.attack(player);
        }
    }


}
