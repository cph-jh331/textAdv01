package Items;

import Items.Item;

public class HealthPot extends Item {

    private int healAmount = 25;

    public HealthPot(String name, String desc, boolean acq, int numb) {
        super(name, desc, acq, numb);

    }

    /**
     * @return the healAmount
     */
    @Override
    public int getHealAmount() {
        return healAmount;
    }

    @Override
    public String toString() {
        return "" + getNumb() + " " + getName();
    }

}
