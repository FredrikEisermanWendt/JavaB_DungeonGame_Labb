package com.Fredrik.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.Fredrik.demo.ColorSetter.RED;
import static com.Fredrik.demo.ColorSetter.RESET;

public class Game {

    private final int BOSS_LEVEL = 12;
    private final Monster boss = new Monster(BOSS_LEVEL);
    private final CustomScanner scan = new CustomScanner();
    private final Shop shop;
    private List<Monster> monsterList = new ArrayList<>();
    private Player player;


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
        shuffleMonsterList();
    }


    private void shuffleMonsterList() {
        Collections.shuffle(monsterList);
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
            System.out.println("""
                    What would you like to do?
                    1: Fight a monster
                    2: Fight the boss
                    3: Get your status
                    4: Buy items
                    5: End game, all progress will be lost?""");
            switch (scan.registerString("")) {
                case "1" -> fightMonster(getMonster());
                case "2" -> fightBoss(getBoss());
                case "3" -> System.out.println(player);
                case "4" -> {
                    shop.buyItems(); player.useItems();
                }
                case "5" -> endGame();
//                case for testing
                case "6" -> fightMonsterMenu(getBoss());

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
        if (monster.equals(getBoss())) {
            playWonGameScene();
        }
    }


    private boolean escapeFight(Monster monster) {
        if (player.didDodge()) {
            System.out.println("You got away");
            return true;
        } else {
            System.out.println("You failed to escape");
            monster.attack(player);
            if (!player.isAlive()) {
                playLostGameScene();
            }
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
            monster.attack(player);
            if (!player.isAlive()) {
                playLostGameScene();
            }
        }
    }


    private void playWonGameScene() {
        printVictoryMessage();
        player.writeFile();
        endGame();
    }


    private void playLostGameScene() {
        printLoosingMessage();
        endGame();
    }


    private void endGame() {
        System.out.println("Thank you for playing!");
        System.exit(0);
    }


    private Monster getBoss() {
        return boss;
    }


    private Monster getMonster() {
        shuffleMonsterList();
        return !monsterList.isEmpty() ? monsterList.get(0) : null;
    }


    private void printVictoryMessage() {
        System.out.println("***************");
        System.out.println("The great adventurer " + player.getName() + " has beaten all the evils of th land");
        System.out.println("They will forever be remembered för their bravery and might");
        System.out.println("We will likely never see another hero quite as strong");
    }


    private void printLoosingMessage() {
        System.out.println("***************");
        System.out.println("The brave adventurer " + player.getName() + " has lost in the fight against evil");
        System.out.println("Like many before has this adventurer bitten of more than they could chew");
        System.out.println("The bravery will be remembered by those who cross paths with thw adventurer");
        System.out.println("But sadly, their name will be forgotten by history");
    }


}
