package textadv01;

import java.util.Scanner;

public class Room {

    Text out = new Text();
    RoomList rl;
    Player pl;
    TrapCtrl trapCtrl;

    StringBuilder sb = new StringBuilder();

    Scanner scan = new Scanner(System.in);

    private String roomDesc;
    private int gold;
    private int north;
    private int south;
    private int east;
    private int west;
    private boolean end;
    private boolean trap;
    // -1 er vores "null".

    public Room() {

    }

    public Room(RoomList r, Player p, TrapCtrl trapCtrl) {
        rl = r;
        pl = p;
        this.trapCtrl = trapCtrl;
    }

    public Room(String desc, int north, int south, int east, int west, int gold, boolean trap, boolean end) {
        this.east = east;
        this.south = south;
        this.west = west;
        this.north = north;
        this.gold = gold;
        this.roomDesc = desc;
        this.end = end;
        this.trap = trap;
    }

    //if there is a room north, south, east or west, then it appends to the stringBuilder.
    public String roomDirection() {
        sb.delete(0, sb.length());
        sb.append("You can go: ");
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
}
