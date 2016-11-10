package textadv01;

import java.util.ArrayList;
import Enemy.SlutBoss;

public class Testing {

    private static Equip equip = new Equip();
    private static StringBuilder sb = new StringBuilder();
    private static Text text = new Text();

    public static String testSetName() {
        Player player = new Player();

        while (true) {
            String name = "Ged";
            if (!name.equals("")) {
                player.setName(name);
                return player.getName();
            }
        }
    }

    public static String testTakeAll() {
        ArrayList<Room> rl = new ArrayList<>();
        Inventory2 inv = new Inventory2();
        Player pl = new Player();
        pl.setName("Ged");

        int gold = 2000;
        Room r = new Room(" stands inside the entrance of the Barrow.\n"
                + "\tThe entrance is in decay, but maybe there is\n"
                + "\tsomething valuable in here..."
                + ""
                + "", 1, -1, -1, -1, true, true, false, null);
        rl.add(r);
        rl.get(0).getInv().addGold(rl.get(0).getInvItem(), gold);

        String taking = pl.getName() + " franticly takes: ";
        if (!rl.get(0).getInvItem().isEmpty()) {
            taking += inv.invListString(rl.get(0).getInvItem());
            inv.moveGold(pl.getInventory(), rl.get(0).getInvItem());
            inv.moveHealthPot(pl.getInventory(), rl.get(0).getInvItem());
            for (int i = 0; i < rl.get(0).getInvItem().size(); i++) {
                pl.getInventory().add(rl.get(0).getInvItem().get(i));
                pl.getInventory().remove(i);
                i--;
            }

        } else {
            taking = "\tNothing to take!";
        }
        return taking;
    }

    public static String testLookInv() {
        String bag = "";
        Player player = new Player();

        player.setName("Ged");

        player.getInv().populatePlayerInv();

        bag = player.getName() + player.getInv().toString();
        return bag;

    }

    public static String testMove() {
        ArrayList<Room> rl = new ArrayList<>();
        Player player = new Player();;
        player.setName("Ged");

        Room r = new Room(" stands inside the entrance of the Barrow.\n"
                + "\tThe entrance is in decay, but maybe there is\n"
                + "\tsomething valuable in here..."
                + ""
                + "", 1, -1, -1, -1, false, true, false, null);
        rl.add(r);
        //rum 1
        r = new Room(" walks into a dark room, which seems\n"
                + "\ta little less in decay. Light seems to\n"
                + "\tcome from the ceiling somehow…\n"
                + "\tyou are not sure how that is possible."
                + ""
                + "", -1, 0, -1, -1, false, false, false, null);
        rl.add(r);

        player.setRoom(0);

        sb.delete(0, sb.length());
        sb.append("\tYou can go: ");
        if (rl.get(player.getRoom()).getNorth() >= 0) {
            sb.append("North...");
        }
        if (rl.get(player.getRoom()).getSouth() >= 0) {
            sb.append(" South...");
        }
        if (rl.get(player.getRoom()).getEast() >= 0) {
            sb.append(" East...");
        }
        if (rl.get(player.getRoom()).getWest() >= 0) {
            sb.append(" West...");
        }
        return sb.toString();

    }

    public static String moveToNextRoom() {

        ArrayList<Room> rl = new ArrayList<>();
        Player pl = new Player();
        pl.setName("Ged");

        Room r = new Room(" stands inside the entrance of the Barrow.\n"
                + "\tThe entrance is in decay, but maybe there is\n"
                + "\tsomething valuable in here..."
                + ""
                + "", 1, -1, -1, -1, false, true, false, null);
        rl.add(r);
        //rum 1
        r = new Room(" walks into a dark room, which seems\n"
                + "\ta little less in decay. Light seems to\n"
                + "\tcome from the ceiling somehow…\n"
                + "\tyou are not sure how that is possible."
                + ""
                + "", -1, 0, -1, -1, false, false, false, null);
        rl.add(r);

        while (1 < 2) {
            String input = "North";
            if (input.equalsIgnoreCase("north") && rl.get(pl.getRoom()).getNorth() >= 0) {
                pl.setRoom(rl.get(pl.getRoom()).getNorth());
                break;
            } else if (input.equalsIgnoreCase("south") && rl.get(pl.getRoom()).getSouth() >= 0) {
                pl.setRoom(rl.get(pl.getRoom()).getSouth());
                break;
            } else if (input.equalsIgnoreCase("east") && rl.get(pl.getRoom()).getEast() >= 0) {
                pl.setRoom(rl.get(pl.getRoom()).getEast());
                break;
            } else if (input.equalsIgnoreCase("west") && rl.get(pl.getRoom()).getWest() >= 0) {
                pl.setRoom(rl.get(pl.getRoom()).getWest());
                break;
            } else if (input.equalsIgnoreCase("back")) {
                break;
            } else {

            }
        }
        return rl.get(pl.getRoom()).getRoomDesc();
    }

    public static String testingFirstEquip() {
        Player pl = new Player();
        pl.getInv().populatePlayerInv();
        String resultat = "";
        String input = "0";

        boolean invalid = true;
        if (!pl.getInv().getInventory().isEmpty()) {
            while (invalid == true) {

                if (tryParsing(input) == true && (pl.getInv().getInventory().size() - 1) < (Integer.parseInt(input))) {
                } else if (tryParsing(input) == true && (pl.getInv().getInventory().size() - 1) >= (Integer.parseInt(input))) {
                    String name = pl.getInv().getInventory().get(Integer.parseInt(input)).getName().toLowerCase();
                    if (name.equals("gold") || name.equals("health potion")) {
                        resultat = pl.getInv().getInventory().get(Integer.parseInt(input)).getName() + " is already equiped";
                        return resultat;
                    } else if (!name.equals("gold") || !name.equals("health potion")) {
                        int index = text.parseInput();
                        resultat = "next step";
                        break;
                    }
                } else if (text.getInput().equalsIgnoreCase("back")) {
                    text.notEquiping();
                    break;
                } else {
                    text.invalid();
                }
            }
        }
        return "Something went horribly wrong";

    }

    public static String testSecondEquip() {
        Player pl = new Player();
        pl.getInv().AddHealthPot(pl.getInventory(), 1);
        pl.getInv().addGold(pl.getInventory(), 1);
        pl.getInv().addSpecificAxe(pl.getInventory(), "Axe", "axe", true, 1, 25);
        int index = 1;

        boolean invalid = true;
        while (invalid == true) {

            String input = "1";
            if (tryParsing(input) == true && pl.getEquip().getBody().size() > Integer.parseInt(input)) {

                int inputNumb = Integer.parseInt(input);
                String invItemName = pl.getInventory().get(index).getName().toLowerCase();
                String bodyItemName = pl.getEquip().getBody().get(inputNumb).getName().toLowerCase();

                switch (inputNumb) {
                    case 0:
                        if (!invItemName.contains("chest plate")) {
                            if (bodyItemName.equalsIgnoreCase("nothing")) {
                                pl.getEquip().getBody().set(inputNumb, pl.getInventory().get(index));
                                pl.getInventory().remove(index);
                                invalid = false;
                                break;

                            } else {
                                pl.getInventory().add(pl.getEquip().getBody().get(inputNumb));
                                pl.getEquip().getBody().set(inputNumb, pl.getInventory().get(index));
                                pl.getInv().removeItemFromArray(pl.getInventory(), index);
                                invalid = false;
                                break;
                            }
                        } else {

                        }
                        break;
                    case 1:
                        if (!invItemName.contains("chest plate")) {
                            if (bodyItemName.equalsIgnoreCase("nothing")) {
                                pl.getEquip().getBody().set(inputNumb, pl.getInventory().get(index));
                                pl.getInventory().remove(index);
                                invalid = false;
                                return pl.getEquip().getBody().get(1).getName() + " was added to body";

                            } else {

                                pl.getInventory().add(pl.getEquip().getBody().get(inputNumb));
                                pl.getEquip().getBody().set(inputNumb, pl.getInventory().get(index));
                                pl.getInv().removeItemFromArray(pl.getInventory(), index);
                                invalid = false;
                                break;
                            }
                        } else {

                        }
                        break;
                    case 2:
                        if (invItemName.contains("chest plate")) {
                            if (bodyItemName.equalsIgnoreCase("nothing")) {

                                pl.getEquip().getBody().set(inputNumb, pl.getInventory().get(index));
                                pl.getInventory().remove(index);
                                invalid = false;
                                break;
                            } else {

                                pl.getInventory().add(pl.getEquip().getBody().get(inputNumb));
                                pl.getEquip().getBody().set(inputNumb, pl.getInventory().get(index));
                                pl.getInv().removeItemFromArray(pl.getInventory(), index);
                                invalid = false;
                                break;
                            }
                        } else {
                        }
                        break;
                    default:
                        text.invalid();
                        break;
                }

            } else if (invalid == false) {
                break;
            } else {
            }

        }

        return "Something went horribly wrong";
    }

    public static boolean tryParsing(String input) {
        boolean candoit = true;
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            candoit = false;
        }
        return candoit;
    }

    public static String testFightEnemy() {
        ArrayList<Room> rl = new ArrayList<>();
        Player pl = new Player();
        Trap trap = new Trap();
        Combat com = new Combat(pl);
        pl.setName("Ged");
        String input = "attack";

        Room r = new Room(" stands inside the entrance of the Barrow.\n"
                + "\tThe entrance is in decay, but maybe there is\n"
                + "\tsomething valuable in here..."
                + ""
                + "", 1, -1, -1, -1, false, true, false, new SlutBoss("Slutty Boss", 100, 100));
        rl.add(r);
        pl.setRoom(0);

        if (rl.get(pl.getRoom()).getrEnemies() != null) {

            while (rl.get(pl.getRoom()).getrEnemies() != null && rl.get(pl.getRoom()).getrEnemies().getHealth() > 0 && pl.getHealth() > 0) {

                

                switch (input) {

                    case "attack":

                        if (rl.get(pl.getRoom()).getrEnemies().getHealth() > 0) {
                            
                        }
                        
                        return "Player attacked";

                    case "defend":
                        com.block();
                        com.hpOverview();
                        break;
                    case "hpot":
                        com.useHealthPot();
                        com.hpOverview();
                        break;
                    case "run away":
                        com.flee();
                        break;
                    default:
                        com.enemyAttack();
                        com.hpOverview();
                        break;
                }

            }
            if (rl.get(pl.getRoom()).getrEnemies() != null && rl.get(pl.getRoom()).getrEnemies().getHealth() <= 0) {
                String enemyName = rl.get(pl.getRoom()).getrEnemies().getName();
                rl.get(pl.getRoom()).setrEnemies(null);
                if (com.checkPotDrop() == true) {
                    com.addPot();
                    text.droppedPot(enemyName);
                } else {
                    text.droppedNothing(enemyName);
                }
            }

        }
        return "Dieded";
    }

}
