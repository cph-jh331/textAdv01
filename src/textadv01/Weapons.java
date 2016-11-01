package textadv01;

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
    
    public String toString(){
        return super.toString() + " - Damage: " + getDmg();
    }

}
