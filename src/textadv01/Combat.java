/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadv01;

public class Combat {
    
    private Randomness rand = new Randomness();
    private Text text = new Text();
    
    Player pl;
    Trap trap;
    
    private int damage;
    private int potDropChance = 25;
    
    public Combat(Player pl, Trap trap) {
        this.pl = pl;
        this.trap = trap;
    }
    //sets trap dmg from a random number from 0 to trap maxDmg
    public void calcDmg() {
        damage = rand.genDmgDealt(trap.getMaxDmg());
    }
    //removes the damage from player heathl.
    public void calcHealth() {
        pl.setHealth(pl.getHealth() - damage);
    }
    //sees if you have pots
    public boolean checkNumPots(int numPot) {
        if (numPot > 0) {
            return true;
        } else {
            return false;
        }
    }
    //adds potHeal value to player health and romoves 1 pot from player.
    public void healYourself() {
        pl.setHealth(pl.getHealth() + pl.getPotHeal());
        pl.setHealthPotAmount(pl.getNumPots() - 1);
    }
    //checks if healht is bigger than 0.
    public boolean checkHealth(int health) {
        if (health <= 0) {
            return true;
        } else {
            return false;
        }
    }
    //checks if a pot is dropped.    
    public boolean checkPotDrop() {
        if (rand.genPotDrop() < potDropChance) {
            return true;
        } else {
            return false;
        }
    }
    //checks if you have any health pots and uses healYourself() if true.
    public void useHealthPot() {
        if (checkNumPots(pl.getNumPots()) == true) {
            healYourself();
            text.healed(pl.getName(), pl.getNumPots(), pl.getPotHeal(), pl.getHealth());
        } else {
            text.noPots(pl.getName());
        }
    }
    
    //adds a health pot to player.
    public void addPot() {
        pl.setHealthPotAmount(pl.getNumPots() + 1);
    }
    
    //checks if you have taken to much damage.
    public void checkTooMuchDamage() {
        if (checkHealth(pl.getHealth()) == true) {
            text.deathLooms(pl.getName());
            trap.setKilledPlayer(true);
        }
    }

    /**
     * @return the trapDamage
     */
    public int getTrapDamage() {
        return damage;
    }
    
}
