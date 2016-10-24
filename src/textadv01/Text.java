/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadv01;

import java.util.Scanner;

public class Text {

    Player pl;
    Room room;
    RoomList rl;
    Item item;
    private Scanner scan = new Scanner(System.in);
    private String input;
    private String out; //not used... remove?
    private String items;

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
        System.out.println("**************************************************************************");
    }

    public void intro() {
        System.out.println("While running from the evil people in the woods,\n"
                + "you find yourself outside the entrance of a large barrow\n"
                + " - You seem to have forgotten your name… what is it?\n");
    }

    public void settedName() {
        System.out.println("\n" + pl.getName() + "...\n"
                + " You are somewhat certain it is " + pl.getName() + ".\n"
                + pl.getName() + " decides to enter the barrow to hide from\n"
                + "the evil people in the woods.\n");
    }

    public void roomDescription(int roomnr) {
        System.out.println("\t" + pl.getName() + rl.getRoomList().get(roomnr).getRoomDesc());
    }

    public void lookingForGold() {
        System.out.println("\n" + pl.getName() + " starts looking around for gold...");
    }

    public void lookingForItem() {
        System.out.println("\n" + pl.getName() + " starts looking around for items...");
    }

    public void doorNotThere() {
        System.out.println("There is no door there...");
    }

    public void invalid() {
        System.out.println("Invalid command...");
    }

    public void whatToDo() {
        System.out.println("\n What do you want to do? \n"
                + "type in any of these commands:\n"
                + "- move: to move the next room\n"
                + "- look for gold: to look for gold\n"
                + "- look for items: to look for items\n"
                + "- take all: to take all the valuables\n"
                + "- inventory: to check inventory\n"
                + "- use health pot: use a health potion\n"
                + "- help: to get commands\n"
                + "- quit: to quit!\n"
                + "");
    }

    public void roomDir() {
        System.out.println("\n" + pl.getName() + " moves around the room to find out\n"
                + "what direction one can go from here...");
        System.out.println(room.roomDirection());
    }

    public void goldCheck() {
        System.out.println("There is " + rl.getRoomList().get(pl.getRoom()).getGold() + " gold in this room\n");
    }

    public void itemCheck() {
        System.out.println("There is " + rl.getRoomList().get(pl.getRoom()).getrItem().getName() + " gold in this room\n");
    }

    public void takesTheGold() {
        if (rl.getRoomList().get(pl.getRoom()).getGold() != 0) {
            System.out.println("\n" + pl.getName() + " franticly takes all of the " + rl.getRoomList().get(pl.getRoom()).getGold() + " pieces of gold.\n");
            items += rl.getRoomList().get(pl.getRoom()).getrItem().getName() + "\n";
        } else {
            System.out.println("\nThere is no gold here... that makes " + pl.getName() + " sad...\n");
        }
    }

    public void takesTheItem() {
        if (rl.getRoomList().get(pl.getRoom()).getrItem() != null) {
            System.out.println("\n" + pl.getName() + " franticly takes the " + rl.getRoomList().get(pl.getRoom()).getrItem().getName());
        } else {
            System.out.println("\nThere is no item... that makes " + pl.getName() + " sad...\n");
        }
    }

    public void checkInventory() {
        System.out.println("\n" + pl.getName() + " currently have:\n"
                + pl.getGold() + " gold\n"
                + pl.getNumPots() + " health portions\n"
                + item
                + "");

    }

    public void quitting() {
        System.out.println("\n" + pl.getName() + " have had enough and runs head first\n"
                + "at full speed into a nearby wall,"
                + "\nshattering the skull...");
    }

    public void theEnd() {
        System.out.println(pl.getName() + " collected the treasure of " + rl.getRoomList().get(pl.getRoom()).getGold() + " gold\n"
                + ""
                + "and ended the game with: " + pl.getGold() + " gold pieces!");
    }

    public void trapThere(String playerName, String trapName) {
        System.out.println("\t" + playerName + " activated a damn " + trapName + "!");
    }

    public void trapDealtDmg(String trapName, String playerName, int trapDmg) {
        String dealtDmg = trapName + " got activated on " + playerName + "!\n"
                + trapName + " did " + trapDmg + " damage to " + playerName + ".";
        System.out.println(dealtDmg);
    }

    public void healed(String playerName, int numPots, int healAmount, int playerHealth) {
        String health = playerName + " used a health potion for " + healAmount + ".\n"
                + playerName + " HP is now: " + playerHealth + ".\n"
                + playerName + " got " + numPots + " health potions left.\n"
                + "";
        System.out.println(health);
    }

    public void noPots(String playerName) {
        String noPots = playerName + " has no health potions left!\n";
        System.out.println(noPots);
    }

    public void trapWhatToDo() {
        String what = "What do you want to do?\n"
                + "- jump: to try to jump\n"
                + "- use health pot: to use health pot\n"
                + "";
        System.out.println(what);
    }

    public void deathLooms(String playerName) {
        String deathLooms = playerName + " has taken to much damage! Death looms...\n";
        System.out.println(deathLooms);
    }

    public void gotKilled(String playerName, String enemyName) {
        String gotKilled = playerName + " managed to get killed by a " + enemyName + ".\n"
                + "";
        System.out.println(gotKilled);
    }

    public void survivedTrap(String playerName, String enemyName, int playerHealth) {
        String survived = enemyName + " destroyed itself.\n"
                + playerName + " HP: " + playerHealth + ".\n";
        System.out.println(survived);
    }

    public void droppedPot(String enemyName) {
        String dropPot = enemyName + " dropped a health potion!\n";
        System.out.println(dropPot);
    }

    public void droppedNothing(String enemyName) {
        String droppedNothing = enemyName + " did not drop anything.\n";
        System.out.println(droppedNothing);
    }

    public void jumpedOver() {
        System.out.println("You jumped over the trap!");
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
