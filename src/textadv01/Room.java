/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadv01;

/**
 *
 * @author bloch
 */
public class Room {
 Text out = new Text();
    // -1 er vores "null".
    
    private String roomDesc;
    private int gold;
    private int north;
    private int south;
    private int east;
    private int west;
    
    
    public Room (String desc, int north, int south, int east, int west, int gold){
        this.east = east;
        this.south = south;
        this.west = west;
        this.north = north;
        this.gold = gold;
        this.roomDesc = desc;        
    }

    public void roomDirection(){
    if (north <= 0 && south <=0 && east <= 0 && west <= 0){
        out.allDirections();
    } else if (north <=  ) {
        
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
