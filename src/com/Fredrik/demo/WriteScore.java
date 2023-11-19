package com.Fredrik.demo;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class WriteScore {

    public void writeScoreFile(Player p) {
        try (

                Writer writer = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream("TheGameScoreFile.txt"), StandardCharsets.UTF_8))) {

            String message = String.format("%s the brave adventurer is left with %d health %nThey have slain %d monsters %n%s reached the level of %d %n",
                    p.getName(), p.getHealth(), p.getMonsterCount(), p.getName(), p.getLevel());

            if (p.getWeapon() != null) {
                message = message.concat(String.format("And ended the game with the mighty %s in their hand", p.getWeapon().getName()));
            }

            writer.write(message);

        } catch (IOException e) {
            System.out.println("Error: an IOException has occured");
            e.printStackTrace();

        } catch (Exception e) {
            System.out.println("Error: an unexpected Exeption has occured");

        }

    }
}
