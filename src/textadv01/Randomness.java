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
        int chance = rand.nextInt(100);
        if (chance <= 20) {
            return new Broom("Broom", "Very dirty broom", false, rand.nextInt(100));
        } else if (chance > 20 && chance <= 40) {
            return new Sword("Sword", "Rusty Sword", false, rand.nextInt(100));
        } else if (chance > 40 && chance <= 60) {
            return new Axe("Axe", "Woodsmen axe", false, rand.nextInt(100));
        } else if (chance > 60 && chance <= 80) {
            return new ChestPlate("Chest plate", "Shiny Chest Plate", false, rand.nextInt(25), rand.nextInt(25));
        } else {
            return new Shield("Shield", "Cardboard shield", false, rand.nextInt(25) + 1, rand.nextInt(25) + 1);
        }
    }

    public Item chanceOfItem() {
        int chance = rand.nextInt(100);
        if (chance <= 35) {
            return genItem();
        }
        return null;
    }

    public Enemies genEnemy() {
        int chance = rand.nextInt(30);
        if (chance <= 10) {
            return new Hest("Hest", 20 + rand.nextInt(20), rand.nextInt(25) + 1);
        } else if (chance > 10 && chance <= 20) {
            return new Enhjoerning("Enhjorning", 20 + rand.nextInt(20), rand.nextInt(25) + 1);
        } else {
            return new Ged("Ged", 20 + rand.nextInt(20), rand.nextInt(25) + 1);
        }
    }

    public Enemies chanceOfEnemy() {
        int chance = rand.nextInt(100);
        if (chance <= 15) {
            return genEnemy();
        }
        return null;
    }

    public int blockChance() {
        return rand.nextInt(100);
    }

    public boolean survived() {
        return rand.nextInt(100) < 50;
    }

}
