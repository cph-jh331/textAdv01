package textadv01;

public class Broom extends Weapons {
    
    private String[] names = {"Very Dirty Broom","Awkward Broom","Deadly Broom","Prestine Broom"};

    public Broom(String name, String desc, boolean acq, int dmg, int numb) {
        super(name, desc, acq, dmg, numb);
    }



    /**
     * @return the names
     */
    public String[] getNames() {
        return names;
    }
    
    

}
