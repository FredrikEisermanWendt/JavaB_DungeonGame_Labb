import com.Fredrik.demo.Monster;
import com.Fredrik.demo.Player;

import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Player p1 = new Player("Kalle", 5, 5, 5);
        Monster m1 = new Monster(1);

        System.out.println(p1);
        System.out.println("");
        System.out.println(m1);

    }
}
