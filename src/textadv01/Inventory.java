package textadv01;

import java.util.ArrayList;

public class Inventory {

    private Text st = new Text();
    private ArrayList<Item> weaponList = new ArrayList<>();
    private ArrayList<Item> armorList = new ArrayList<>();
    private RoomList rl;
    private Player pl;

    public Inventory(RoomList rl, Player pl) {
        this.pl = pl;
        this.rl = rl;
    }

    public void addToInv() {
        if (rl.getRoomList().get(pl.getRoom()).getrItem().getDmg() > 0) {
            getWeaponList().add(rl.getRoomList().get(pl.getRoom()).getrItem());

        } else {
            getArmorList().add(rl.getRoomList().get(pl.getRoom()).getrItem());
            addStats();

        }
    }

    public void addStats() {
        pl.setDef(pl.getDef() + rl.getRoomList().get(pl.getRoom()).getrItem().getDef());
        pl.setHealth(pl.getHealth() + rl.getRoomList().get(pl.getRoom()).getrItem().getHpIncr());
    }

    public String weaponListString() {

        String li = "";
        if (!weaponList.isEmpty()) {
            li = "Nr\tWeapons\n";
            int counter = 1;
            for (Item item : getWeaponList()) {
                li += counter + "\t" + item.toString() + "\n";
                counter++;
            }
            li += "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n";
        }

        return li;
    }

    public String armorListString() {
        String li = "";
        if (!armorList.isEmpty()) {
            li = "\tArmor\n";
            for (Item item : getArmorList()) {
                li += "\t" + item.toString() + "\n";
            }
        }
        return li;

    }

    public int getDmg(int index) {
        return weaponList.get(index).getDmg();
    }

    /**
     * @return the weaponList
     */
    public ArrayList<Item> getWeaponList() {
        return weaponList;
    }

    /**
     * @return the armorList
     */
    public ArrayList<Item> getArmorList() {
        return armorList;
    }
}
