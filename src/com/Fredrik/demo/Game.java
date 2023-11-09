package com.Fredrik.demo;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Monster> monsterList = new ArrayList<>();
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
        int strength = getPlayerSatsFromUser("Strength", statPoints);
        statPoints -= strength;
        int intelligence = getPlayerSatsFromUser("Intelligence", statPoints);
        statPoints -= intelligence;
        player = new Player(name, strength, intelligence, statPoints);

    }

    private int getPlayerSatsFromUser(String stat, int statPoints) {
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
                case "1" -> fightMonsterMenu();
//                case "2" -> figthBoss();
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

    private void fightMonsterMenu() {
        boolean isPlaying = true;
        Monster monster = monsterList.get(0);
            System.out.println("You Stumbled upon a " + monster);
        do {
            System.out.println("""
                    1: Attack
                    2: Show Battle status
                    3: try to run
                    """);
            switch (scan.registerString("")) {
                case "1" -> fight(monster);
                case "2" -> System.out.println(player + "\n" + monster);
                case "3" -> System.out.println();
                default -> System.out.println("Wrong input " + player.getName());
            }
            if (monster.getHealth() <= 0){
                isPlaying = false;
            }
        } while (isPlaying);
    }

    private void fight(Monster monster) {
        player.attack(monster);
        if (monster.getHealth() <= 0){
            player.getReward(monster);
            player.levelUp();
        }else {
            monster.attack(player);
        }
    }


}
