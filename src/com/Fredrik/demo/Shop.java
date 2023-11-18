package com.Fredrik.demo;

import java.util.ArrayList;
import java.util.List;

import com.Fredrik.demo.ColorSetter.*;

import static com.Fredrik.demo.ColorSetter.RESET;
import static com.Fredrik.demo.ColorSetter.WHITE_BOLD;

public class Shop {

    private final Player player;
    private final CustomScanner scan = new CustomScanner();
    private final int ORIGINAL_ARMOR_STOCK = 3;
    private final int ORIGINAL_POTION_STOCK = 5;
    private final int ORIGINAL_WEAPON_STOCK = 1;
    private List<Item> itemList = new ArrayList<>();
    private List<Item> shoppingCart = new ArrayList<>();
    private int playersNoOfVisits = 0;

    public Shop(Player player) {
        generateItemList();
        this.player = player;
    }

    private void generateItemList() {
        addArmorToList(ORIGINAL_ARMOR_STOCK);
        addPotionToList(ORIGINAL_POTION_STOCK);
        addWeaponToList(ORIGINAL_WEAPON_STOCK);

    }


    public void buyItems() {
        boolean isShopping = true;
        Item i = null;
        printWelcomeMessage();
        do {
            printList(itemList, "Right now this is our stock:\n");
            printPlayerMoney();
            System.out.println("""
                    How may I help you?
                    1: Armor
                    2: Potion
                    3: Weapon
                    4: Pay and leave
                    5: Leave without Items""");
            switch (scan.registerString("")) {
                case "1" -> addToShoppingCart("armor");
                case "2" -> addToShoppingCart("healthpotion");
                case "3" -> addToShoppingCart("weapon");
                case "4" -> {
                    isShopping = false;
                    checkOut();
                }
                case "5" -> {
                    isShopping = false;
                    leave();
                }
                default -> System.out.println("Wrong input " + player.getName());
            }


        } while (isShopping);
        playersNoOfVisits++;
    }

    private void addToShoppingCart(String type) {
        Item item = getItemByType(type);

        if (item == null) {
            System.out.println("I'm sorry adventurer " + WHITE_BOLD + player.getName() + RESET + ", but I seem to be out of that item");
            return;
        }

        if (isPlayerToPoor(item)) {
            return;
        }

        System.out.println("I added a " + item.getTYPE() + " to your shopping cart");
        shoppingCart.add(item);
        itemList.remove(item);

    }

    private boolean isPlayerToPoor(Item item) {
        if (player.getMoney() >= getTotalPrice() + item.getPrice()) {
            return false;
        } else {
            System.out.println("You cant afford that item I'm afraid");
            return true;
        }
    }


    public Item getItemByType(String type) {
        for (Item i : itemList) {
            if (i.getTYPE().equalsIgnoreCase(type)) {
                return i;
            }
        }
        return null;
    }


    private void checkOut() {
        player.setMoney(player.getMoney() - getTotalPrice());
        System.out.println("Thank you for your purchase, it's a pleasure doing business with you adventurer  " + WHITE_BOLD + player.getName() + RESET);
        printRecept();
        giveItemsToPlayer();
        shoppingCart.clear();
        leave();
    }

    private void printRecept() {
        System.out.println("***************");
        System.out.println("Thank you for buying:");
        printList(shoppingCart, "");
        System.out.println("***************");
    }

    private void leave() {
        if (!shoppingCart.isEmpty()) {
            itemList.addAll(shoppingCart);
            shoppingCart.clear();
        }
        System.out.println("Thank you for stopping by, you're always welcome here!");
    }

    private void giveItemsToPlayer() {
        player.getItemList(shoppingCart);
    }


    private void printList(List<Item> list, String message) {
        System.out.print(message);
        for (Item i : list) {
            System.out.println(i);
        }
    }

    private void printWelcomeMessage() {
        if (playersNoOfVisits == 0) {
            System.out.println("Welcome... What you are " + player.getName() + " aren't you? ");
            System.out.println("Thank you for blessing my simple shop with your presence");
        } else if (playersNoOfVisits == 1) {
            System.out.println("Welcome back " + player.getName() + " I hope I may use your name so casually");
        } else {
            System.out.println("Welcome back " + player.getName());
        }

    }


    public int getTotalPrice() {
        int price = 0;
        for (Item i : shoppingCart) {
            price += i.getPrice();
        }
        return price;
    }

    private void printPlayerMoney() {
        System.out.println("You seem to have " + (player.getMoney() - getTotalPrice()) + " money left");

    }

    private void addWeaponToList(int x) {
        for (int i = 0; i < x; i++) {
            itemList.add(new Weapon());
        }
    }

    private void addPotionToList(int x) {
        for (int i = 0; i < x; i++) {
            itemList.add(new HealthPotion());
        }
    }

    private void addArmorToList(int x) {
        for (int i = 0; i < x; i++) {
            itemList.add(new Armor());
        }
    }


}

