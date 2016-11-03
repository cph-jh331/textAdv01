/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadv01;

import java.util.ArrayList;

public class Player {

    private Inventory2 inv = new Inventory2();
    private Equip equip = new Equip();

    private int health = 100;
    private int dmg = 5;
    private int def = 15;
    private String name;
    private int room = 0;
    private int previousRoom;

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    public ArrayList<Item> getInventory() {
        return inv.getInv();
    }

    public int getGold() {
        return inv.getGold(inv.getInv());
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }

    public int getNumberOfHpot() {
        return inv.getNumberOfItem(inv.getInv(), "health potion");
    }
    
    public int getHealFromPot(){
        return inv.getHealingAmount();
    }

    /**
     * @return the dmg
     */
    public int getDmg() {
        return dmg + equip.getBody().get(0).getDmg() + equip.getBody().get(1).getDmg();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the room
     */
    public int getRoom() {
        return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(int room) {
        this.room = room;
    }

    /**
     * @param dmg the dmg to set
     */
    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    /**
     * @return the def
     */
    public int getDef() {
        return def + equip.getBody().get(0).getDef()
                + equip.getBody().get(1).getDef()
                + equip.getBody().get(2).getDef();
    }

    /**
     * @param def the def to set
     */
    public void setDef(int def) {
        this.def = def;
    }

    /**
     * @return the previousRoom
     */
    public int getPreviousRoom() {
        return previousRoom;
    }

    /**
     * @param previousRoom the previousRoom to set
     */
    public void setPreviousRoom(int previousRoom) {
        this.previousRoom = previousRoom;
    }

    /**
     * @return the inv
     */
    public Inventory2 getInv() {
        return inv;
    }

    /**
     * @return the equip
     */
    public Equip getEquip() {
        return equip;
    }

}
