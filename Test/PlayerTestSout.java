import com.Fredrik.demo.Monster;
import com.Fredrik.demo.Player;
import com.Fredrik.demo.Weapon;

public class PlayerTestSout {

    private static Player p = new Player("Benny", 5, 5, 5);
    private static Weapon w = new Weapon();

    public static void main(String[] args) {

//        test of writeFile();


        p.setWeapon(w);
        System.out.println(p.getWeapon());
        p.writeFile();

        String kalle = "Kalle";
        System.out.println(kalle);

        kalle = kalle.concat("strop och grodan boll");
        System.out.println(kalle);


        Monster monster = new Monster(10);
        System.out.println(monster);


    }
}
