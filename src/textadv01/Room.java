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
    
    public Room(){
        
    }

    public Room(String desc, int north, int south, int east, int west, int gold) {
        this.east = east;
        this.south = south;
        this.west = west;
        this.north = north;
        this.gold = gold;
        this.roomDesc = desc;
    }

    public String roomDirection() {
        sb.delete(0, sb.length());
        sb.append("You can go: ");
        if (rl.getRoomList().get(pl.getRoom()).getNorth() >= 0) {
            sb.append("North,");
        }
        if (rl.getRoomList().get(pl.getRoom()).getSouth() >= 0) {
            sb.append(" South,");
        }
        if (rl.getRoomList().get(pl.getRoom()).getEast() >= 0) {
            sb.append(" East,");
        }
        if (rl.getRoomList().get(pl.getRoom()).getWest() >= 0) {
            sb.append(" West");
        }
        return sb.toString();
    }

    public void goTo() {
        while (1 < 2) {
        String input = scan.nextLine();
            if (input.equalsIgnoreCase("north") && rl.getRoomList().get(pl.getRoom()).north >= 0) {
                pl.setRoom(rl.getRoomList().get(pl.getRoom()).north);
                break;
            } else if (input.equalsIgnoreCase("south") && rl.getRoomList().get(pl.getRoom()).south >= 0) {
                pl.setRoom(rl.getRoomList().get(pl.getRoom()).south);
                break;
            } else if (input.equalsIgnoreCase("east") && rl.getRoomList().get(pl.getRoom()).east >= 0) {
                pl.setRoom(rl.getRoomList().get(pl.getRoom()).east);
                break;
            } else if (input.equalsIgnoreCase("west") && rl.getRoomList().get(pl.getRoom()).west >= 0) {
                pl.setRoom(rl.getRoomList().get(pl.getRoom()).west);
                break;
            } else {
                out.doorNotThere();
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

    /**
     * @param gold the gold to set
     */
    public void setGold(int gold) {
        this.gold = gold;
    }
}
