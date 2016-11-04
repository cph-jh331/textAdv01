package textadv01;

import java.util.Scanner;

public class Text {

    private Player pl;
    private Room room;
    private RoomList rl;
    private Scanner scan = new Scanner(System.in);
    private String input;

    public Text() {
    }

    public Text(RoomList r, Room ro, Player p) {
        rl = r;
        room = ro;
        pl = p;
    }

    public int parseInput() {
        int numb;
        numb = Integer.parseInt(input) - 1;
        return numb;
    }

    public void out(String str) {
        System.out.println(str);
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

    public void startsLooking(String invList) {
        String look = "----------------------------------------------------------------------------\n"
                + "\t" + pl.getName() + " starts looking around the room and sees:\n"
                + invList + "\n"
                + "----------------------------------------------------------------------------";

        System.out.println(look);
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
                + "- look: to look for valuables\n"
                + "- take all: to take all the valuables\n"
                + "- inv: to check inventory\n"
                + "- equip: to equip an item\n"
                + "- hpot: use a health potion\n"
                + "- stats: to check your current stats\n"
                + "- highscore: to check the highscore\n"
                + "- help: to get commands\n"
                + "- quit: to quit!\n"
                + "");
    }

    public void roomDir() {
        System.out.println("\t" + pl.getName() + " moves around the room to find out\n"
                + "\twhat direction one can go from here...");
        System.out.println(room.roomDirection());
        System.out.println("\n- back: to stay in the current room.");
    }

    public void checkInventory(String weaponList) {
        System.out.println("\t" + pl.getName() + " currently have:\n"
                + weaponList);

    }

    public void checkStats() {
        System.out.println("\t Your stats are:\n"
                + "----------------------------------------------------------------------------\n"
                + "\tDmg: " + pl.getDmg() + "\n"
                + "\tDef: " + pl.getDef() + "\n"
                + "\tHp: " + pl.getHealth() + "\n"
                + pl.getEquip().equipWithoutCounter() + "\n"
                + "----------------------------------------------------------------------------");
    }

    public void quitting() {
        System.out.println("\n\t" + pl.getName() + " have had enough and runs head first\n"
                + "\tat full speed into a nearby wall,"
                + "\n\tshattering the skull...");
    }

    public void theEnd() {
        String end = "";
        if (pl.getHealth() > 0) {
            end = "\t" + pl.getInv().takeAll(rl.getRoomList().get(pl.getRoom()).getInventoryList(), pl.getInventory(), pl.getName()) + "\n";
        }
        end += "\t" + pl.getName() + " ended the game with: " + pl.getGold() + " gold pieces!";
        System.out.println(end);
    }

    public void trapThere(String playerName, String trapName) {
        String str = "\t" + playerName + " activated a damn " + trapName + "!";
        System.out.println(str.toUpperCase());
    }

    public void equipWhatToDo(String plInv) {
        String what = ""
                + "----------------------------------------------------------------------------\n"
                + "\tWhat item do you want to equip?\n"
                + "----------------------------------------------------------------------------"
                + "" + plInv + "\n"
                + "\n>back - to stop equipping.";

        System.out.println(what);
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

    public void notEquiping() {
        System.out.println("----------------------------------------------------------------------------\n"
                + "\tYou decided to not equip anything.\n"
                + "----------------------------------------------------------------------------\n");
    }

    public void alreadyEquiped(String itemName) {
        System.out.println("----------------------------------------------------------------------------\n"
                + "\t" + itemName + " is already equiped!\n"
                + "----------------------------------------------------------------------------");

    }

    public void equiping(String itemName, String invToString) {
        String equip = "----------------------------------------------------------------------------\n"
                + "\tWhere do you want to equip the " + itemName + "?\n"
                + "----------------------------------------------------------------------------"
                + invToString
                + "\n----------------------------------------------------------------------------";
        System.out.println(equip);
    }

    public void equipReplace(String itemName, String equipedItem, String body) {
        System.out.println(""
                + "----------------------------------------------------------------------------\n"
                + "\tYou equip the " + itemName + " on your " + body + ".\n"
                + "\tReplacing " + equipedItem + ".\n"
                + "----------------------------------------------------------------------------");
    }

    public void cannotEquip(String itemName, String bodyName) {

        System.out.println("----------------------------------------------------------------------------\n"
                + "\tYou cannot put " + itemName + " on your " + bodyName + ".\n"
                + "----------------------------------------------------------------------------");
    }

    public void enterADamnNumber() {
        System.out.println("----------------------------------------------------------------------------"
                + "\n\tYou need to write a number\n"
                + "----------------------------------------------------------------------------");
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
