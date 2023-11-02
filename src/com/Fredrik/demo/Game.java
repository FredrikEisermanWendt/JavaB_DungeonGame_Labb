package com.Fredrik.demo;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Monster> monsterList = new ArrayList<>();
    private CustomScanner scan = new CustomScanner();
    private Player player;
    private Shop shop = new Shop();

    public Game(){
        titleMenu();
        System.out.println("Welcome adventurer");
        setPlayer();
        titleMenu();
    }

    private void setPlayer() {
        int statPoints = 15;
        String name = scan.registerString("What is your name");
        System.out.println("You have 15 points to distribute between, Strength, Intelligence and Agility, chose wisely");
        int strength = getPlayerSatsFromUser("Strength", statPoints);
        int intelligence = getPlayerSatsFromUser("Intelligence", statPoints);
        player = new Player(name, strength, intelligence, statPoints);

    }
    private int getPlayerSatsFromUser(String stat, int statPoints) {
        do {
            int temp = scan.registerInt("For " + stat + ", give me a number between 1 and " + statPoints);
            if (temp > statPoints){
                System.out.println("Are you trying to cheat my friend, try again!");
            }else{
                return temp;
            }
        } while (true);
    }

    private void titleMenu(){
        System.out.println("""
                1: Start the game
                2: Quit the game
                """);
        do {
            switch (scan.registerString("")){
                case "1" -> gameMenu();
                case "2" -> System.exit(0);
                default -> System.out.println("Error: wrong input");
            }
        } while (true);
    }

    private void gameMenu() {
        switch (scan.registerString("")) {
            case "1" -> fightMonster();
            case "2" -> figthBoss();
            case "3" -> System.out.println(player);
            case "4" -> shop.buyItems;
            case "5" -> titleMenu();
        }
    }

    private void fightMonster() {
        Monster m = monsterList.get(0);
    }


}
