package textadv01;

public class Shield extends Armor {
    private String[] names = {"Wooden Shield", "Leather Shield", "Decaying Shield", "Copper Shield"};

    public Shield(String name, String desc, boolean acq, int hpIncr, int def, int numb) {
        super(name, desc, acq, hpIncr, def, numb);
    }



    /**
     * @return the names
     */
    public String[] getNames() {
        return names;
    }
    
    

}
