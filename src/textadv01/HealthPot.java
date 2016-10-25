package textadv01;

public class HealthPot extends Item {

    private int healAmount = 25;
    private int numb;

    public HealthPot(String name, String desc, boolean acq) {
        super(name, desc, acq);
    }

    /**
     * @return the healAmount
     */
    public int getHealAmount() {
        return healAmount;
    }

    /**
     * @return the numb
     */
    public int getNumb() {
        return numb;
    }

}
