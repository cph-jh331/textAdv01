/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadv01;

public class Player {
    private int health = 100;
    private int dmg;
    private int gold;
    private int healthPotAmount = 3;
    private int potHeal = 25;
    private String name; 
    private int room = 0;

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
     * @return the dmg
     */
    public int getDmg() {
        return dmg;
    }

    /**
     * @return the gold
     */
    public int getGold() {
        return gold;
    }

    /**
     * @param gold the gold to set
     */
    public void setGold(int gold) {
        this.gold = gold;
    }

    /**
     * @return the healthPotAmount
     */
    public int getHealthPotAmount() {
        return healthPotAmount;
    }

    /**
     * @param healthPotAmount the healthPotAmount to set
     */
    public void setHealthPotAmount(int healthPotAmount) {
        this.healthPotAmount = healthPotAmount;
    }

    /**
     * @return the potHeal
     */
    public int getPotHeal() {
        return potHeal;
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
    
}

