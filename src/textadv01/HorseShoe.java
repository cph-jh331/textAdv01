
package textadv01;

public class HorseShoe extends Weapons{
    private String[] names = {"Lucky Horse Shoe", "Unlucky Horse Shoe", "Gold Horse Shoe"};
    
    public HorseShoe(String name, String desc, boolean acq, int dmg, int numb) {
        super(name, desc, acq, dmg, numb);
    }

    /**
     * @return the names
     */
    public String[] getNames() {
        return names;
    }
    
}
