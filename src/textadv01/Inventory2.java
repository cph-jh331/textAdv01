package textadv01;

import java.util.ArrayList;

public class Inventory2 {

    private Randomness rand = new Randomness();
    private ArrayList<Item> inv = new ArrayList<>();

    public void populatePlayerInv() {
        AddHealthPot(inv, 3);
    }

    public void moveEverything(ArrayList<Item> taker, ArrayList<Item> giver) {
        if (!giver.isEmpty()) {
            for (int i = 0; i < giver.size(); i++) {
                taker.add(giver.get(i));
            }
        }
    }

    public int getGold(ArrayList<Item> inv) {
        int number = 0;
        for (int i = 0; i < inv.size(); i++) {
            String name = inv.get(i).getName().toLowerCase();
            if (name.equals("gold")) {
                number = inv.get(i).getNumb();
            }
        }
        return number;
    }

    public String takeAll(ArrayList<Item> giver, ArrayList<Item> taker, String playerName) {
        String taking = "----------------------------------------------------------------------------\n"
                + "\t" + playerName + " franticly takes:\n";
        if (!giver.isEmpty()) {
            taking += invListString(giver);
            moveGold(taker, giver);
            moveHealthPot(taker, giver);
            for (int i = 0; i < giver.size(); i++) {
                taker.add(giver.get(i));
                giver.remove(i);
                i--;
            }

        } else {
            taking = "----------------------------------------------------------------------------\n"
                    + "\tNothing to take!";
        
        }
        taking += "\n----------------------------------------------------------------------------";
        return taking;
    }

    public void addRandomAxe(ArrayList<Item> anyInv, int numb) {
        int i = 1;
        while (i <= numb) {
            System.out.println("adding a axe");
            Axe axe = new Axe("Meh", "Desc", true, 22, numb);
            axe.setName(getRand().RandomItemName(axe.getNames()));
            axe.setDmg(getRand().randomDmgStat(15));
            getInv().add(axe);
            i++;
            if (i > numb) {

            }
        }
    }

    public void addSpecificAxe(ArrayList<Item> taker, String name, String desc, Boolean acq, int numb, int dmg) {
        int i = 1;
        while (i <= numb) {
            Axe axe = new Axe("Meh", "Desc", true, 22, numb);
            axe.setDmg(dmg);
            taker.add(axe);
            i++;
            if (i > numb) {
                break;
            }
        }
    }

    public void moveAxe(ArrayList<Item> taker, ArrayList<Item> giver) {
        if (!giver.isEmpty()) {
            for (int i = 0; i < giver.size(); i++) {
                String name = giver.get(i).getName().toLowerCase();
                if (name.contains("axe")) {
                    addSpecificAxe(taker, giver.get(i).getName(),
                            giver.get(i).getDesc(), giver.get(i).isAcquired(),
                            giver.get(i).getNumb(), giver.get(i).getDmg());
                    removeItemFromArray(giver, i);
                    i--;
                }
            }
        }
    }

    public void addRandomSword(ArrayList<Item> anyInv, int numb) {
        int i = 1;
        while (i <= numb) {
            Sword sword = new Sword("Meh", "Desc", true, 22, numb);
            sword.setName(getRand().RandomItemName(sword.getSwordNames()));
            sword.setDmg(getRand().randomDmgStat(20));
            anyInv.add(sword);
            i++;
            if (i > numb) {
                break;
            }
        }
    }

    public void addSpecificSword(ArrayList<Item> taker, String name, String desc, Boolean acq, int numb, int dmg) {
        int i = 1;
        while (i <= numb) {
            Sword sword = new Sword(name, desc, true, dmg, numb);
            sword.setDmg(dmg);
            taker.add(sword);
            i++;
            if (i > numb) {
                break;
            }
        }
    }

    public void moveSword(ArrayList<Item> taker, ArrayList<Item> giver) {
        if (!giver.isEmpty()) {
            for (int i = 0; i < giver.size(); i++) {
                String name = giver.get(i).getName().toLowerCase();
                if (name.contains("sword")) {
                    addSpecificSword(taker, giver.get(i).getName(),
                            giver.get(i).getDesc(), giver.get(i).isAcquired(),
                            giver.get(i).getNumb(), giver.get(i).getDmg());
                    removeItemFromArray(giver, i);
                    i--;
                }
            }
        }
    }

    public void addRandomBroom(ArrayList<Item> anyInv, int numb) {
        int i = 1;
        while (i <= numb) {
            Broom broom = new Broom("Meh", "Desc", true, 22, numb);
            broom.setName(getRand().RandomItemName(broom.getNames()));
            broom.setDmg(getRand().randomDmgStat(45));
            anyInv.add(broom);
            i++;
            if (i > numb) {
                break;
            }
        }
    }

    public void addSpecificBroom(ArrayList<Item> taker, String name, String desc, Boolean acq, int numb, int dmg) {
        int i = 1;
        while (i <= numb) {
            Broom broom = new Broom(name, desc, true, dmg, numb);
            broom.setDmg(dmg);
            taker.add(broom);
            i++;
            if (i > numb) {
                break;
            }
        }
    }

    public void moveBroom(ArrayList<Item> taker, ArrayList<Item> giver) {
        if (!giver.isEmpty()) {
            for (int i = 0; i < giver.size(); i++) {
                String name = giver.get(i).getName().toLowerCase();
                if (name.contains("sword")) {
                    addSpecificBroom(taker, giver.get(i).getName(),
                            giver.get(i).getDesc(), giver.get(i).isAcquired(),
                            giver.get(i).getNumb(), giver.get(i).getDmg());
                    removeItemFromArray(giver, i);
                    i--;
                }
            }
        }
    }

    public void addRandomShield(ArrayList<Item> anyInv, int numb) {
        int i = 1;
        while (i <= numb) {
            Shield shield = new Shield("shield", "some shield", true, 25, 25, numb);
            shield.setName(getRand().RandomItemName(shield.getNames()));
            System.out.println("adding shield");
            anyInv.add(shield);
            i++;
            if (i > numb) {
                break;
            }
        }
    }

    public void addSpecificShield(ArrayList<Item> taker, String name, String desc, boolean acq, int hpIncr, int def, int numb) {
        int i = 1;
        while (i <= numb) {
            Shield shield = new Shield(name, desc, acq, hpIncr, def, numb);
            taker.add(shield);
            i++;
            if (i > numb) {
                break;
            }
        }
    }

    public void moveShield(ArrayList<Item> taker, ArrayList<Item> giver) {
        if (!giver.isEmpty()) {
            for (int i = 0; i < giver.size(); i++) {
                String name = giver.get(i).getName().toLowerCase();
                if (name.contains("shield")) {
                    addSpecificShield(taker, giver.get(i).getName(), giver.get(i).getDesc(),
                            giver.get(i).isAcquired(), giver.get(i).getHpIncr(),
                            giver.get(i).getDef(), giver.get(i).getNumb());
                    removeItemFromArray(giver, i);
                }
            }
        }
    }

    public void addRandomChestPlate(ArrayList<Item> anyInv, int numb) {
        int i = 1;
        while (i <= numb) {
            ChestPlate chest = new ChestPlate("Chest Plate", "Some Chest Plate", true, 25, 25, numb);
            chest.setName(getRand().RandomItemName(chest.getNames()));
            anyInv.add(chest);
            i++;
            if (i > numb) {

            }
        }
    }

    public void addSpecificChestPlate(ArrayList<Item> taker, String name, String desc, boolean acq, int hpIncr, int def, int numb) {

        int i = 1;
        while (i <= numb) {
            ChestPlate chest = new ChestPlate(name, desc, acq, hpIncr, def, numb);
            taker.add(chest);
            i++;
            if (i > numb) {
                break;
            }
        }
    }

    public void moveChestPlate(ArrayList<Item> taker, ArrayList<Item> giver) {
        if (!giver.isEmpty()) {
            for (int i = 0; i < giver.size(); i++) {
                String name = giver.get(i).getName().toLowerCase();
                if (name.contains("chest plate")) {
                    addSpecificChestPlate(taker, giver.get(i).getName(),
                            giver.get(i).getDesc(), giver.get(i).isAcquired(),
                            giver.get(i).getHpIncr(), giver.get(i).getDef(),
                            giver.get(i).getNumb());
                    removeItemFromArray(giver, i);
                    i--;
                }
            }
        }
    }

    public void addGold(ArrayList<Item> anyInv, int numb) {
        Gold gold = new Gold("Gold", "Coins of Gold", true, numb);
        boolean allready = false;
        int i;
        for (i = 0; i < anyInv.size(); i++) {
            if (anyInv.get(i).getName().equalsIgnoreCase("gold")) {
                allready = true;
                break;
            }
        }
        if (allready == true) {
            anyInv.get(i).setNumb(anyInv.get(i).getNumb() + numb);
            System.out.println(anyInv.get(i).getNumb() + "!!!!!!!!!");
            System.out.println("adding to gold");

        } else {
            anyInv.add(gold);
            System.out.println("Adding new Gold object");
        }
    }

    public void moveGold(ArrayList<Item> taker, ArrayList<Item> giver) {
        if (!giver.isEmpty()) {
            for (int i = 0; i < giver.size(); i++) {
                String name = giver.get(i).getName().toLowerCase();
                if (name.equals("gold")) {
                    addGold(taker, giver.get(i).getNumb());
                    removeItemFromArray(giver, i);
                    break;
                }
            }
        }
    }

    public int getNumberOfItem(ArrayList<Item> inv, String itemName) {
        int numb = 0;
        String name = itemName.toLowerCase();
        for (int i = 0; i < inv.size(); i++) {
            String invItemName = inv.get(i).getName().toLowerCase();
            if (invItemName.equals(name)) {
                numb = inv.get(i).getNumb();
                break;
            }
        }
        return numb;
    }

    public void minus1OfItem(String itemName) {
        String name = itemName.toLowerCase();
        for (int i = 0; i < inv.size(); i++) {
            if (inv.get(i).getName().equalsIgnoreCase(name)) {
                inv.get(i).setNumb(inv.get(i).getNumb() - 1);
                break;
            }
        }
    }

    public void AddHealthPot(ArrayList<Item> anyInv, int numb) {
        HealthPot hPot = new HealthPot("Health Potion", "Heals for 25 hp", true, numb);
        boolean already = false;
        int i;
        for (i = 0; i < anyInv.size(); i++) {
            if (anyInv.get(i).getName().equalsIgnoreCase(hPot.getName())) {
                already = true;
                break;
            }
        }
        if (already == true) {
            anyInv.get(i).setNumb(anyInv.get(i).getNumb() + numb);
        } else {
            anyInv.add(hPot);
        }
    }

    public int getHealingAmount() {
        int numb = 0;
        for (int i = 0; i < inv.size(); i++) {
            if (inv.get(i).getName().equalsIgnoreCase("health potion")) {
                numb = inv.get(i).getHealAmount();
                break;
            }
        }
        return numb;
    }

    public void moveHealthPot(ArrayList<Item> taker, ArrayList<Item> giver) {
        if (!giver.isEmpty()) {
            for (int i = 0; i < giver.size(); i++) {
                String name = giver.get(i).getName().toLowerCase();
                if (name.equals("health potion")) {
                    AddHealthPot(taker, giver.get(i).getNumb());
                    removeItemFromArray(giver, i);
                }
            }
        }
    }

    public void moveEntireInv(ArrayList<Item> taker, ArrayList<Item> giver) {
        if (!giver.isEmpty()) {

        }
    }

    public void removeItemFromArray(ArrayList<Item> inv, int index) {
        inv.remove(index);
    }

    /**
     * @return the inv
     */
    public ArrayList<Item> getInv() {
        return inv;
    }

    /**
     * @return the rand
     */
    public Randomness getRand() {
        return rand;
    }

    public String invListString(ArrayList<Item> inv) {
        String li = "";
        for (Item item : inv) {
            li += "\n\t" + item.toString();
        }
        return li;
    }

    public String equipWithoutCounter() {
        return "";
    }

    public String toString() {

        String li = "";
        if (!inv.isEmpty()) {
            for (Item item : inv) {
                li += "\n\t" + item.toString();
            }
        } else {
            li += "\n\tNothing of value in the rooom...";
        }
        return li;
    }

    public String equipToString() {
        return "";
    }

    public String invToString(ArrayList<Item> inv) {
        return "";
    }

}
