package textadv01;

import java.util.Random;

public class Randomness {

    Random rand = new Random();

    private int trapChance = 50;

    public int randomGold() {
        return rand.nextInt(2000);
    }

    public String trapNames(String[] names) {
        String name = names[rand.nextInt(names.length)];
        return name;
    }

    public int genDmgDealt(int maxDmg) {
        int dmgDealt = rand.nextInt(maxDmg);
        return dmgDealt;
    }

    public int genPotDrop() {
        int potDrop = rand.nextInt(100);
        return potDrop;
    }

    public boolean genTrap() {
        int chance = rand.nextInt(100);
        boolean isTrapThere;
        if (chance < trapChance) {
            isTrapThere = true;
            return isTrapThere;

        } else {
            isTrapThere = false;
            return isTrapThere;
        }
    }
    
    public boolean survived(){
        if(rand.nextInt(100) < 50){
            return true;
        }
        return false;
    }

}
