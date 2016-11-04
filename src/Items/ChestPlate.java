package Items;

import Items.Armor;

public class ChestPlate extends Armor {
    private String[] names = {"Wooden Chest Plate", "Rusty Chest Plate", "Awkward Chest Plate", "Copper Chest Plate"};

    public ChestPlate(String name, String desc, boolean acq, int hpIncr, int def, int numb) {
        super(name, desc, acq, hpIncr, def, numb);
    }



    /**
     * @return the names
     */
    public String[] getNames() {
        return names;
    }


    
    

}
