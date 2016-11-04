package Items;

public class Sword extends Weapons {
    private String[] swordNames = {"Rusty Sword", "Gold Sword", "Cobber Sword", "Bend Sword"};

    public Sword(String name, String desc, boolean acq, int dmg, int numb) {
        super(name, desc, acq, dmg, numb);
    }



    /**
     * @return the swordNames
     */
    public String[] getSwordNames() {
        return swordNames;
    }
        
    

}
