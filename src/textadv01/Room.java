/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadv01;

import java.util.Scanner;

/**
 *
 * @author bloch
 */
public class Room {

    Text out = new Text();
    RoomList rl;
    Player pl;

    public Room(RoomList r, Player p) {
        rl = r;
        pl = p;
    }
    StringBuilder sb = new StringBuilder();

    Scanner scan = new Scanner(System.in);
    // -1 er vores "null".

    private String roomDesc;
    private int gold;
    private int north;
    private int south;
    private int east;
    private int west;

    public Room(String desc, int north, int south, int east, int west, int gold) {
        this.east = east;
        this.south = south;
        this.west = west;
        this.north = north;
        this.gold = gold;
        this.roomDesc = desc;
    }

    public String roomDirection() {
        sb.append("You can go: ");
        if (this.north >= 0) {
            sb.append("North,");
        }
        if (this.south >= 0) {
            sb.append(" South,");
        }
        if (this.east >= 0) {
            sb.append(" East,");
        }
        if (this.west >= 0) {
            sb.append(" West");
        }
        return sb.toString();
    }

    public boolean goTo(String where) {
        while (1 < 2) {
            if (where.equalsIgnoreCase("north") && rl.getRoomList().get(pl.getRoom()).north >= 0) {
                pl.setRoom(rl.getRoomList().get(pl.getRoom()).north);
                return true;
            } else if (where.equalsIgnoreCase("south") && rl.getRoomList().get(pl.getRoom()).south >= 0) {
                pl.setRoom(rl.getRoomList().get(pl.getRoom()).south);
                return true;
            } else if (where.equalsIgnoreCase("east") && rl.getRoomList().get(pl.getRoom()).east >= 0) {
                pl.setRoom(rl.getRoomList().get(pl.getRoom()).east);
                return true;
            } else if (where.equalsIgnoreCase("west") && rl.getRoomList().get(pl.getRoom()).west >= 0) {
                pl.setRoom(rl.getRoomList().get(pl.getRoom()).west);
                return true;
            } else {
                out.doorNotThere();
                return false;
            }
        }
    }

    /**
     * @return the roomDesc
     */
    public String getRoomDesc() {
        return roomDesc;
    }

    /**
     * @return the gold
     */
    public int getGold() {
        return gold;
    }

    /**
     * @return the north
     */
    public int getNorth() {
        return north;
    }

    /**
     * @return the south
     */
    public int getSouth() {
        return south;
    }

    /**
     * @return the east
     */
    public int getEast() {
        return east;
    }

    /**
     * @return the west
     */
    public int getWest() {
        return west;
    }
}