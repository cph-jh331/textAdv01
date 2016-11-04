package Items;

import Items.Item;

public class Gold extends Item {

    public Gold(String name, String desc, boolean acq, int numb) {
        super(name, desc, acq, numb);

    }

    @Override
    public String toString() {
        return "" + getNumb() + " " + getName() + ".";
    }

}
