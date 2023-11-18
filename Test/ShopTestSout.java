import com.Fredrik.demo.Player;
import com.Fredrik.demo.Shop;

import java.security.spec.RSAOtherPrimeInfo;

public class ShopTestSout {

    static Player p = new Player("Kalle", 5,5,5);
    static Shop shop = new Shop(p);

    public static void main(String[] args) {



////        test of buyItems()
//        System.out.println(p);
//        p.setHealth(10);
//        p.setMoney(10000);
//        System.out.println(p);
//
//        shop.buyItems();
//        System.out.println(p);
//        shop.buyItems();
//        System.out.println("health should be 100 after 3 armours");
//        System.out.println(p);
//        p.setHealth(10);
//        System.out.println(p);
//        shop.buyItems();
//        System.out.println(p);
//        System.out.println("Health shjould be 30 after two health potions");

//    test av isPlayerToPoor()
        p.setHealth(15);
        p.setMoney(10);
        System.out.println(p);

        shop.buyItems();
        System.out.println(p);
        System.out.println("health should be at 30, money should be at 0 after 1 health potion ");













    }
}
