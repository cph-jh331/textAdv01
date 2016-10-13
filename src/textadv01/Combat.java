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

    public void calcDmg() {
        damage = rand.genDmgDealt(trap.getMaxDmg());
    }

    public void calcHealth() {
        pl.setHealth(pl.getHealth() - damage);
    }

    public boolean checkNumPots(int numPot) {
        if (numPot > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void healYourself() {
        pl.setHealth(pl.getHealth() + pl.getPotHeal());
        pl.setHealthPotAmount(pl.getNumPots() - 1);
    }

    public boolean checkHealth(int health) {
        if (health <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPotDrop() {
        if (rand.genPotDrop() < potDropChance) {
            return true;
        } else {
            return false;
        }
    }

    public void useHealthPot() {
        if (checkNumPots(pl.getNumPots()) == true) {
            healYourself();
            text.healed(pl.getName(), pl.getNumPots(), pl.getPotHeal(), pl.getHealth());
        } else {
            text.noPots(pl.getName());
        }
    }

    public void addPot() {
        pl.setHealthPotAmount(pl.getNumPots() + 1);
    }

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
