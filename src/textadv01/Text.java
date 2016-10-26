package textadv01;

import java.util.Scanner;

public class Text {

    private Player pl;
    private Room room;
    private RoomList rl;
    private Item item;
    private Scanner scan = new Scanner(System.in);
    private String input;
    private String out; //not used... remove?
    private String items = "\t";

    StringBuilder sb = new StringBuilder();

    public Text() {

    }

    public Text(RoomList r, Room ro, Player p, Item item) {
        rl = r;
        room = ro;
        pl = p;
        this.item = item;
    }

    public void outDescOfRoom(String name, String roomDesc) {
        System.out.println(name + roomDesc);
    }

    public void enterName() {
        input = scan.nextLine();
    }

    public void enterText() {
        input = scan.nextLine().toLowerCase();
    }

    public void textDivider() {
        System.out.println("\n**************************************************************************");
    }

    public void textDivider2() {
        System.out.println("----------------------------------------------------------------------------");
    }

    public void intro() {
        System.out.println("\tWhile running from the evil people in the woods,\n"
                + "\tyou find yourself outside the entrance of a large barrow\n"
                + "\t- You seem to have forgotten your name… what is it?\n");
    }

    public void settedName() {
        System.out.println("\n\t" + pl.getName() + "...\n"
                + "\tYou are somewhat certain it is " + pl.getName() + ".\n"
                + "\t" + pl.getName() + " decides to enter the barrow to hide from\n"
                + "\tthe evil people in the woods.\n");
    }

    public void roomDescription(int roomnr) {
        System.out.println("\t" + pl.getName() + rl.getRoomList().get(roomnr).getRoomDesc());
    }

    public void lookingForGold() {
        System.out.println("\t" + pl.getName() + " starts looking around for gold...");
    }

    public void lookingForItem() {
        System.out.println("\t" + pl.getName() + " starts looking around for items...");
    }

    public void doorNotThere() {
        System.out.println("\tThere is no door there...");
    }

    public void invalid() {
        String str = ""
                + "----------------------------------------------------------------------------\n"
                + "\tInvalid command...\n"
                + "\tType help for a list of commands\n"
                + "----------------------------------------------------------------------------";
        System.out.println(str);
    }

    public void whatToDo() {
        System.out.println(""
                + "\ttype in any of these commands:\n"
                + "----------------------------------------------------------------------------\n"
                + "- move: to move the next room\n"
                + "- look for gold: to look for gold\n"
                + "- look for items: to look for items\n"
                + "- take all: to take all the valuables\n"
                + "- inventory: to check inventory\n"
                + "- use health pot: use a health potion\n"
                + "- stats: to check your current stats\n"
                + "- help: to get commands\n"
                + "- quit: to quit!\n"
                + "");
    }

    public void roomDir() {
        System.out.println("\t" + pl.getName() + " moves around the room to find out\n"
                + "\twhat direction one can go from here...");
        System.out.println(room.roomDirection());
    }

    public void goldCheck() {
        System.out.println("\tThere is " + rl.getRoomList().get(pl.getRoom()).getGold() + " gold in this room.");
    }

    public void itemCheck() {
        if (rl.getRoomList().get(pl.getRoom()).getrItem() != null) {
            System.out.println("\tThere is " + rl.getRoomList().get(pl.getRoom()).getrItem().getName() + " in this room.");
        } else {
            System.out.println("\tThere is no items and that makes " + pl.getName() + " very sad.");
        }
    }

    public void takesTheGold() {
        if (rl.getRoomList().get(pl.getRoom()).getGold() != 0) {
            System.out.println("\t" + pl.getName() + " franticly takes all of the " + rl.getRoomList().get(pl.getRoom()).getGold() + " pieces of gold.");

            if (rl.getRoomList().get(pl.getRoom()).getrItem() != null) {
                items += "\n\t" + rl.getRoomList().get(pl.getRoom()).getrItem().getName()
                        + " - Dmg: " + rl.getRoomList().get(pl.getRoom()).getrItem().getDmg()
                        + " - Def: " + rl.getRoomList().get(pl.getRoom()).getrItem().getDef()
                        + " - Hp Increase: " + rl.getRoomList().get(pl.getRoom()).getrItem().getHpIncr() + "\t";
            }
        } else {
            System.out.println("\tThere is no gold here... that makes " + pl.getName() + " sad...");
        }
    }

    public void takesTheItem() {
        if (rl.getRoomList().get(pl.getRoom()).getrItem() != null) {
            System.out.println("\n\t" + pl.getName() + " franticly takes the " + rl.getRoomList().get(pl.getRoom()).getrItem().getName() + ".");
        } else {
            System.out.println("\n\tThere is no item... that makes " + pl.getName() + " sad...");
        }
    }

    public void checkInventory() {
        System.out.println("\t" + pl.getName() + " currently have:\n"
                + "\t" + pl.getGold() + " gold\n"
                + "\t" + pl.getNumPots() + " health portions"
                + items
                + "");

    }

    public void checkStats() {
        System.out.println("\t Your stats are:\n"
                + "----------------------------------------------------------------------------\n"
                + "\t Dmg: " + pl.getDmg() + "\n"
                + "\t Def: " + pl.getDef() + "\n"
                + "\t Hp: " + pl.getHealth() + "\n"
                + "----------------------------------------------------------------------------");
    }

    public void quitting() {
        System.out.println("\n\t" + pl.getName() + " have had enough and runs head first\n"
                + "\tat full speed into a nearby wall,"
                + "\n\tshattering the skull...");
    }

    public void theEnd() {
        System.out.println("\t" + pl.getName() + " collected the treasure of " + rl.getRoomList().get(pl.getRoom()).getGold() + " gold\n"
                + ""
                + "\tand ended the game with: " + pl.getGold() + " gold pieces!");
    }

    public void trapThere(String playerName, String trapName) {
        String str = "\t" + playerName + " activated a damn " + trapName + "!";
        System.out.println(str.toUpperCase());
    }

    public void trapDealtDmg(String trapName, String playerName, int trapDmg) {
        String dealtDmg = "\t" + trapName + " got activated on " + playerName + "!\n"
                + "\t" + trapName + " did " + trapDmg + " damage to " + playerName + ".";
        System.out.println(dealtDmg);
    }

    public void healed(String playerName, int numPots, int healAmount, int playerHealth) {
        String health = "\t" + playerName + " used a health potion for " + healAmount + ".\n"
                + "\t" + playerName + " HP is now: " + playerHealth + ".\n"
                + "\t" + playerName + " got " + numPots + " health potions left."
                + "";
        System.out.println(health);
    }

    public void noPots(String playerName) {
        String noPots = "\t" + playerName + " has no health potions left!\n";
        System.out.println(noPots);
    }

    public void trapWhatToDo() {
        String what = "\tWhat do you want to do?\n"
                + "----------------------------------------------------------------------------\n"
                + "- jump: to try to jump\n"
                + "- use health pot: to use health pot\n"
                + "";
        System.out.println(what);
    }

    public void deathLooms(String playerName) {
        String deathLooms = "\t" + playerName + " has taken to much damage! Death looms...\n";
        System.out.println(deathLooms);
    }

    public void gotKilled(String playerName, String enemyName) {
        String gotKilled = "\t" + playerName + " managed to get killed by a " + enemyName + ".\n"
                + "";
        System.out.println(gotKilled);
    }

    public void survivedTrap(String playerName, String enemyName, int playerHealth) {
        String survived = "\t" + enemyName + " destroyed itself.\n"
                + "\t" + playerName + " HP: " + playerHealth + ".\n";
        System.out.println(survived);
    }

    public void droppedPot(String enemyName) {
        String dropPot = "\t" + enemyName + " dropped a health potion!";
        System.out.println(dropPot);
    }

    public void droppedNothing(String enemyName) {
        String droppedNothing = "\t" + enemyName + " did not drop anything.";
        System.out.println(droppedNothing);
    }

    public void jumpedOver() {
        System.out.println("\tYou jumped over the trap!");
    }

    /**
     * @return the input
     */
    public String getInput() {
        return input;
    }

    public void introArt() {

        System.out.println("                                  _ \n"
                + "                        .-.      / \\        _ \n"
                + "            ^^         /   \\    /^./\\__   _/ \\ \n"
                + "          _        .--'\\/\\_ \\__/.      \\ /    \\  ^^  ___ \n"
                + "         / \\_    _/ ^      \\/  __  :'   /\\/\\  /\\  __/   \\ \n"
                + "        /    \\  /    .'   _/  /  \\   ^ /    \\/  \\/ .`'\\_/\\ \n"
                + "       /\\/\\  /\\/ :' __  ^/  ^/    `--./.'  ^  `-.\\ _    _:\\ _ \n"
                + "      /    \\/  \\  _/  \\-' __/.' ^ _   \\_   .'\\   _/ \\ .  __/ \\ \n"
                + "    /\\  .-   `. \\/     \\ / -.   _/ \\ -. `_/   \\ /    `._/  ^  \\ \n"
                + "   /  `-.__ ^   / .-'.--'    . /    `--./ .-'  `-.  `-. `.  -  `. \n"
                + " @/        `.  / /      `-.   /  .-'   / .   .'   \\    \\  \\  .-  \\% \n"
                + " @(88%@)@%% @)&@&(88&@.-_=_-=_-=_-=_-=_.8@% &@&&8(8%@%8)(8@%8 8%@)% \n"
                + " @88:::&(&8&&8::JGS:&`.~-_~~-~~_~-~_~-~~=.'@(&%::::%@8&8)::&#@8:::: \n"
                + " `::::::8%@@%:::::@%&8:`.=~~-.~~-.~~=..~'8::::::::&@8:::::&8::::::' \n"
                + "  `::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::' \n");

    }

    public void death() {

        System.out.println(""
                + "                    `\"-._   \n"
                + "                      `. \"-._ \n"
                + "                        T.   \"-.  \n"
                + "                         $$p.   \"-.   \n"
                + "                         $$$$b.    `,   \n"
                + "                      .g$$$$$$$b    ;    \n"
                + "                    .d$$$$$$$$$$;   ;    \n"
                + "                 __d$$$$$$P\"\"^T$$   :   \n"
                + "               .d$$$$P^^\"\"___       :        \n"
                + "              d$P'__..gg$$$$$$$$$$; ;    \n"
                + "             d$$ :$$$$$$$$$$$$$$$$;  ;   \n"
                + "            :$$; $$$$$$$$$$$$$$$$P  :$  \n"
                + "            $$$  $$$$$$$$$$$$$$$$b  $$   \n"
                + "           :$$$ :$$$$$$$$$$$$$$$$$; $$; \n"
                + "           $$$; $$$$$$$$$$$$$$$$$$; $$;  \n"
                + "          :$$$  $$$$$$$$$^$$$$$$$$$ :$$   \n"
                + "          $$$; :$$$p__gP' `Tp__g$$$ :$$   \n"
                + "         :$$$  $$P`T$P' .$. `T$P'T$; $$;   \n"
                + "         $$$; :$$;     :P^T;     :$; $$; \n"
                + "        :$$$  $$$$-.           .-$$$ :$$    \n"
                + "        $$$$ :$$$$; \\   T$P   / :$$$  $$   \n"
                + "       :$$$; $$$$$$  ; b:$;d :  $$$$; $$;    \n"
                + "       $$$$; $$$$$$; : T T T ; :$$$$$ :$$    \n"
                + "    .g$$$$$  :$$$$$$  ;' | ':  $$$$$$  T$b   \n"
                + " .g$$$$$$$$   $$$$$$b :     ; d$$$$$;   `Tb \n"
                + ":$$$$$$$$$;   :$$$$$$$;     :$$$$$$P       \\ \n"
                + ":$$$$$$$$$;    T$$$$$$$p._.g$$$$$$P         ;\n"
                + "$$$P^^T$$$$p.   `T$$$$$$$$$$$$$$P'     _/`. :\n"
                + "       `T$$$$$b.  `T$$$$$$$$$$P'    .g$P   \\; \n"
                + "  bug    `T$$$$$b.  \"^T$$$$P^\"     d$P'      \n"
                + "           `T$$$$$b.             .dP'   \n"
                + "             \"^T$$$$b.        .g$P' \n"
                + "                \"^T$$$b    .g$P^\"       \n"
                + "                   \"^T$b.g$P^\"   \n"
                + "                      \"^$^\" \n");

    }

}
