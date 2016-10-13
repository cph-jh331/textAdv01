/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadv01;

/**
 *
 * @author Bloch
 */
public class Trap {

    private Randomness rand = new Randomness();

    private String[] trapNames = {"Orange trap", "Spring trap", "Trip trap", "Boulder trap"};
    private String name;
    private boolean isThere;
    private int maxDmg = 1000;
    private int health = 10;
    private int room = 0;
    private boolean killedPlayer= false;

    public void genTrapName() {
        name = rand.trapNames(trapNames);
    }

    /**
     * @return the maxDmg
     */
    public int getMaxDmg() {
        return maxDmg;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the isThere
     */
    public boolean isItThere() {
        return isThere;
    }

    /**
     * @param isThere the isThere to set
     */
    public void setIsThere(boolean isThere) {
        this.isThere = isThere;
    }

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
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
     * @return the killedPlayer
     */
    public boolean isKilledPlayer() {
        return killedPlayer;
    }

    /**
     * @param killedPlayer the killedPlayer to set
     */
    public void setKilledPlayer(boolean killedPlayer) {
        this.killedPlayer = killedPlayer;
    }

}
