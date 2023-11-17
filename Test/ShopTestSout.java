import com.Fredrik.demo.Player;
import com.Fredrik.demo.Shop;

public class ShopTestSout {

    static Player p = new Player("Kalle", 5,5,5);
    static Shop shop = new Shop(p);

    public static void main(String[] args) {

        shop.printItemList();


//        test of buyItems()
        System.out.println(p);
        p.setHealth(10);
        p.setMoney(10000);
        System.out.println(p);

        shop.buyItems();

    }
}
