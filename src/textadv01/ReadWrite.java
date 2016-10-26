package textadv01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadWrite {

    Player pl;

    public ReadWrite(Player p) {
        pl = p;
    }

    private Text st = new Text();

    private Scanner scan;
    private String fileName = "highscore.txt";

    public void write(String playerName, int gold) {

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        writer.println(playerName + ": " + gold);

        writer.close();

    }

    public void openFile() {
        try {
            scan = new Scanner(new File("highscore.txt"));
        } catch (Exception e) {
            System.out.println("FAILURE!!!! RED LIGHT AND STUFF");
        }

    }

    public String readFile() {
        openFile();
        String a = "";
        String b = "";
        while (scan.hasNext()) {
            a = scan.next();
            b = scan.next();

            if (Integer.parseInt(b) >= pl.getGold()) {
                st.out("The highscore so far is: \n" + a + " " + b);
            } else if (Integer.parseInt(b) < pl.getGold()) {
                st.out("\t The current highscore is: " + pl.getName() + ": " + pl.getGold());
            }

            return b;

        }

        return a + b;

    }

    public void closeScan() {
        scan.close();
    }

}
