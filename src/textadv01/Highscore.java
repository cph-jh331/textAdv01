package textadv01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Highscore {

    private Scanner scan;
    private String fileName = "highscore.txt";
    private PrintWriter writer;
    private String[] nameScoreArray = new String[5];
    private String[] nameArray = new String[5];
    private int[] scoreArray = new int[5];

    public void openFile() {
        try {
            scan = new Scanner(new File(fileName));
        } catch (Exception e) {
            System.out.println("FAILURE!!!");
        }
    }

    public void closeFile() {
        scan.close();
    }

    public String highscoreNew(String playerName, int gold) {
        readFileToArray();
        String nameScore = playerName + " " + gold;
        int i;
        boolean addScore = false;

        for (i = 0; i < scoreArray.length; i++) {
            int score = scoreArray[i];
            if (gold >= score) {
                addScore = true;
                break;
            }
        }
        if (addScore == true) {

            switch (i) {
                case 0:
                    nameScoreArray[4] = nameScoreArray[3];
                    nameScoreArray[3] = nameScoreArray[2];
                    nameScoreArray[2] = nameScoreArray[1];
                    nameScoreArray[1] = nameScoreArray[0];
                    nameScoreArray[0] = nameScore;
                    emptyTheFile();
                    writeFromArrayToFile();
                    break;
                case 1:
                    nameScoreArray[4] = nameScoreArray[3];
                    nameScoreArray[3] = nameScoreArray[2];
                    nameScoreArray[2] = nameScoreArray[1];
                    nameScoreArray[1] = nameScore;
                    emptyTheFile();
                    writeFromArrayToFile();
                    break;
                case 2:
                    nameScoreArray[4] = nameScoreArray[3];
                    nameScoreArray[3] = nameScoreArray[2];
                    nameScoreArray[2] = nameScore;
                    emptyTheFile();
                    writeFromArrayToFile();
                    break;
                case 3:
                    nameScoreArray[4] = nameScoreArray[3];
                    nameScoreArray[3] = nameScore;
                    emptyTheFile();
                    writeFromArrayToFile();
                    break;
                case 4:
                    nameScoreArray[4] = nameScore;
                    emptyTheFile();
                    writeFromArrayToFile();
                    break;
                default:
                    break;
            }

            return "****************************************************************************\n"
                    + "\t" + playerName.toUpperCase() + " HAVE BEEN ADDED TO THE HIGHSCORE!\n"
                    + "****************************************************************************";


        }return "****************************************************************************\n"
                + "\tNot a new highScore...\n"
                + "****************************************************************************";

    }

    public void readFileToArray() {
        openFile();
        String a = "";
        String b = "";
        int c;
        int counter = 0;

        while (scan.hasNextLine()) {
            if (scan.hasNext() != false) {
                a = scan.next();
                b = scan.next();
                c = Integer.parseInt(b);
                nameArray[counter] = a;
                scoreArray[counter] = c;
                nameScoreArray[counter] = a + " " + b;
                counter++;
            } else {
                break;
            }
        }
        scan.close();
    }

    public void writeFromArrayToFile() {
        readFileToArray();
        for (int i = 0; i < nameScoreArray.length; i++) {
            String string = nameScoreArray[i];
            try {
                writer = new PrintWriter(new FileOutputStream(new File(fileName), true));

            } catch (FileNotFoundException e) {
                System.out.println("FAIIILURE!");
            }
            writer.println(string);
            writer.close();
        }

    }

    public void emptyTheFile() {
        try {
            writer = new PrintWriter(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("MUHHSH");
        }
        writer.close();
    }

    public String highScoreToString(String playerName, int gold) {
        readFileToArray();
        String high = "----------------------------------------------------------------------------\n"
                + "\t" + playerName + " have collected " + gold + " gold.\n"
                + "\tHighscore list:\n"
                + "----------------------------------------------------------------------------";
        for (int i = 0; i < nameScoreArray.length; i++) {
            high += "\n\t" + nameScoreArray[i];
        }
        high += "\n----------------------------------------------------------------------------";
        return high;

    }

    public String readFile() {
        openFile();
        String a = "";
        String b = "";
        String c = "";

        while (scan.hasNext()) {
            if (scan.hasNext() != false) {
                a = scan.next();
                b = scan.next();
                c += "\n" + a + " " + b;
            } else {
                break;
            }
        }
        scan.close();
        return c;
    }

    /**
     * @return the name
     */
    public String[] getName() {
        return nameArray;
    }

    /**
     * @return the score
     */
    public int[] getScore() {
        return scoreArray;
    }

    /**
     * @return the nameScore
     */
    public String[] getNameScore() {
        return nameScoreArray;
    }

}
