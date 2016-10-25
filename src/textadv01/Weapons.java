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
public class Weapons extends Item {

    private int dmg;

    public Weapons(String name, String desc, boolean acq, int dmg) {
        super(name, desc, acq);
        this.dmg = dmg;

    }

    /**
     * @return the dmg
     */
    @Override
    public int getDmg() {
        return dmg;
    }

    /**
     * @param dmg the dmg to set
     */
    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

}
