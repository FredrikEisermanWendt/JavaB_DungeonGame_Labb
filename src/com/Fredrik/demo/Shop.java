package com.Fredrik.demo;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private List<Item> itemList = new ArrayList<>();
    private List<Item> shoppinCart = new ArrayList<>();
    private int totalPrice;
    private Player player;
    CustomScanner scan = new CustomScanner();

    public Shop(Player player) {
        genarateItemList();
        this.player = player;
    }

    private void genarateItemList() {
        addArmorToList(3);
        addPotionToList(5);
        addWeaponToList(1);

    }


    public void buyItems() {
        boolean isShopping = true;
        Item i = null;
        do{
            printItemList();
            System.out.println("""
                    1: Armor
                    2: Potion
                    3: Weapon""");
            switch (scan.registerString("")){
                case "1" -> addToShoppingCart("armor");
                case "2" -> addToShoppingCart("potion");
                case "3" -> addToShoppingCart("weapon");
                default -> System.out.println("Wrong input " + player.getName());
            }


        }while (isShopping);
    }
//     i = getItemByType("healthpotion"); i.use(player); itemList.remove(i);

    private void addToShoppingCart(String type) {
        Item item = getItemByType(type);
        if (item == null){
            System.out.println("Im sorry adventurer, but I seem to be out of that item");
        }else {
            shoppinCart.add(item);
            totalPrice += item.getPrice();
            itemList.remove(item);
        }
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

    public void printItemList(){
        System.out.println(itemList);
    }

    public Item getItemByType(String type){
        for (Item i : itemList) {
            if(i.getTYPE().equalsIgnoreCase(type)){
                return i;
            }
        }
        return null;
    }


}

