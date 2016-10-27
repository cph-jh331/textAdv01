package textadv01;

import java.util.Random;

public class Randomness {

    private Random rand = new Random();

    private int trapChance = 25;

    public int randomGold() {
        return rand.nextInt(2000);
    }

    public String trapNames(String[] names) {
        String name = names[rand.nextInt(names.length)];
        return name;
    }

    public int genDmgDealt(int maxDmg) {
        int dmgDealt = rand.nextInt(maxDmg) + 1;
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

    public Item genItem() {
        int chance = rand.nextInt(30);
        if (chance <= 10) {
            return new Broom("Broom", "Very dirty broom", false, rand.nextInt(100));
        } else if (chance > 10 && chance <= 20) {
            return new Sword("Sword", "Rusty Sword", false, rand.nextInt(100));
        } else {
            return new Shield("Shield", "Cardboard shield", false, rand.nextInt(25) + 1, rand.nextInt(25) + 1);
        }
    }

    public Item chanceOfItem() {
        int chance = rand.nextInt(100);
        if (chance <= 30) {
            return genItem();
        }
        return null;
    }

    public boolean survived() {
        return rand.nextInt(100) < 50;
    }

}
