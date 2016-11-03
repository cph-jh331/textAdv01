/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadv01;

public class Armor extends Item {

    private int hpIncr;
    private int def;

    public Armor(String name, String desc, boolean acq, int hpIncr, int def, int numb) {
        super(name, desc, acq, numb);
        this.hpIncr = hpIncr;
        this.def = def;
    }

    /**
     * @return the hpIncr
     */
    @Override
    public int getHpIncr() {
        return hpIncr;
    }

    /**
     * @param hpIncr the hpIncr to set
     */
    public void setHpIncr(int hpIncr) {
        this.hpIncr = hpIncr;
    }

    /**
     * @return the def
     */
    @Override
    public int getDef() {
        return def;
    }

    /**
     * @param def the def to set
     */
    public void setDef(int def) {
        this.def = def;
    }
    
    public String toString(){
        return super.toString() + " Defence: " + def + " Hp increase: " + hpIncr;
    }

}
