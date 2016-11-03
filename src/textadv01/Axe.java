package textadv01;

public class Axe extends Weapons {
    
    private String[] names = {"Dane Axe", "Blunt Axe", "Woodsman Axe", "Flint Axe",};

    public Axe(String name, String desc, boolean acq, int dmg, int numb) {
        super(name, desc, acq, dmg, numb);
    }

    /**
     * @return the names
     */
    public String[] getNames() {
        return names;
    }

}



    

