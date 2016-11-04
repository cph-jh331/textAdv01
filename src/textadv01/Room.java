package textadv01;

import Enemy.Enemies;
import Items.Item;
import java.util.ArrayList;
import java.util.Scanner;

public class Room {
    

    private RoomInv inv = new RoomInv();

    private Text out = new Text();
    private RoomList rl;
    private Player pl;

    private StringBuilder sb = new StringBuilder();

    private Scanner scan = new Scanner(System.in);

    private String roomDesc;
    private Enemies rEnemies = null;
    private int north;
    private int south;
    private int east;
    private int west;
    private boolean end;
    private boolean trap;
    private boolean treasure = false;

    // -1 er vores "null".
    public Room() {
    }

    public Room(RoomList r, Player p) {
        rl = r;
        pl = p;

    }

    public Room(String desc, int north, int south, int east, int west, boolean treasure, boolean trap, boolean end, Enemies enemy) {
        this.east = east;
        this.south = south;
        this.west = west;
        this.north = north;
        this.roomDesc = desc;
        this.end = end;
        this.trap = trap;
        this.rEnemies = enemy;
        this.treasure = treasure;
    }

    //if there is a room north, south, east or west, then it appends to the stringBuilder.
    public String roomDirection() {
        sb.delete(0, sb.length());
        sb.append("\tYou can go: ");
        if (rl.getRoomList().get(pl.getRoom()).getNorth() >= 0) {
            sb.append("North...");
        }
        if (rl.getRoomList().get(pl.getRoom()).getSouth() >= 0) {
            sb.append(" South...");
        }
        if (rl.getRoomList().get(pl.getRoom()).getEast() >= 0) {
            sb.append(" East...");
        }
        if (rl.getRoomList().get(pl.getRoom()).getWest() >= 0) {
            sb.append(" West...");
        }
        return sb.toString();
    }

    //if there is a room next to the "current" player room, then set the player room to that
    //if player writes "north","east","south","west".
    //if the player writes back, you go back to the switch in main.
    //if there is no door, then it prints out door not there.
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
            } else if (input.equalsIgnoreCase("back")) {
                break;
            } else {
                out.doorNotThere();
            }
        }
    }

    // checks if the room is the end.
    public boolean theEnd() {
        if (this.end == true) {
            return true;
        }
        return false;
    }

    /**
     * @return the roomDesc
     */
    public String getRoomDesc() {
        return roomDesc;
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
     * @return the trap
     */
    public boolean isTrap() {
        return trap;
    }

    /**
     * @param trap the trap to set
     */
    public void setTrap(boolean trap) {
        this.trap = trap;
    }

    /**
     * @return the rEnemies
     */
    public Enemies getrEnemies() {
        return rEnemies;
    }

    /**
     * @param rEnemies the rEnemies to set
     */
    public void setrEnemies(Enemies rEnemies) {
        this.rEnemies = rEnemies;
    }

    /**
     * @return the inv
     */
    public RoomInv getInv() {
        return inv;
    }
    
    public ArrayList<Item> getInventoryList(){
        return inv.getInv();
    }

    /**
     * @return the treasure
     */
    public boolean hasTreasure() {
        return treasure;
    }

    /**
     * @param treasure the treasure to set
     */
    public void setTreasure(boolean treasure) {
        this.treasure = treasure;
    }
}
