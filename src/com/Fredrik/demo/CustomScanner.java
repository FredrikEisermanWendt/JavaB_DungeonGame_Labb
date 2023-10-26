package com.Fredrik.demo;
import java.util.Scanner;

public class CustomScanner {

    private final Scanner INPUT = new Scanner(System.in);


    public int registerInt(String header) {
        int result = 0;
        while (result < 1) {
            System.out.println(header);
            result = intChecker();
        }
        INPUT.nextLine();
        return result;
    }

    private int intChecker() {
        if (INPUT.hasNextInt()) {
            int i = INPUT.nextInt();
            return i;
        } else {
            System.out.println("Error: wrong datatype");
            INPUT.nextLine();
            return -100;
        }
    }

    public String registerString(String header) {
        String string;
        do {
            string = inputString(header);
            if (string == null || string.isBlank()) {
                System.out.println("Error: not an accepted word");
            }
        } while (string == null);
        return string;
    }

    private String inputString(String header) {
        System.out.println(header);
        String string = INPUT.nextLine();
        if (string.isEmpty()) {
            return null;
        }
        string = formatFixer(string);
        return string;
    }

    public void inputReturn(String header) {
        System.out.print(header);
        INPUT.nextLine();
    }

    private String formatFixer(String input) {

        String string = input.toLowerCase();
        String capital = string.substring(0, 1).toUpperCase();
        string = capital + string.substring(1);


        return string;
    }
}
