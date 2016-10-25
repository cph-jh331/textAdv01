package textadv01;

public class Gold extends Item {

    private Randomness rand = new Randomness();

    private int numb;

    public Gold(String name, String desc, boolean acq) {
        super(name, desc, acq);
    }

    /**
     * @return the numb
     */
    public int getNumbOfGold() {
        numb = rand.randomGold();
        return numb;
    }

    /**
     * @param numb the numb to set
     */
}
