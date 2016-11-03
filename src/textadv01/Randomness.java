package textadv01;

import java.util.Random;

public class Randomness {

    private Random rand = new Random();

    private int trapChance = 25;
    private int swordChance = 25;
    private int axeChance = 25;
    private int broomChance = 25;
    private int shieldChance = 25;
    private int chestPlateChance = 25;
    private int treasureChance = 50;
            


    public int randomGold(int maxGold) {
        return getRand().nextInt(maxGold);
    }
    
    public int genItem (int itemChance){
        int chance = getRand().nextInt(100);
        if(chance < itemChance){
            return 1;
        } else {
            return 0;
        }
    }
    
    public String RandomItemName(String[] names){
        String name = names[getRand().nextInt(names.length)];
        return name;
    }

    public String trapNames(String[] names) {
        String name = names[getRand().nextInt(names.length)];
        return name;
    }

    public int genDmgDealt(int maxDmg) {
        int dmgDealt = getRand().nextInt(maxDmg) + 1;
        return dmgDealt;
    }
    
    public int randomDmgStat(int minDmg){
        int dmg = getRand().nextInt(25) + minDmg;
        return dmg;
    }

    public int genPotDrop() {
        int potDrop = getRand().nextInt(100);
        return potDrop;
    }

    public boolean genTrap() {
        int chance = getRand().nextInt(100);
        boolean isTrapThere;
        if (chance < getTrapChance()) {
            isTrapThere = true;
            return isTrapThere;

        } else {
            isTrapThere = false;
            return isTrapThere;
        }
    }

//    public Item genItem() {
//        int chance = rand.nextInt(100);
//        if (chance <= 20) {
//            return new Broom("Broom", "Very dirty broom", false, rand.nextInt(100) + 1);
//        } else if (chance > 20 && chance <= 40) {
//            return new Sword("Sword", "Rusty Sword", false, rand.nextInt(100) + 1);
//        } else if (chance > 40 && chance <= 60) {
//            return new Axe("Axe", "Woodsmen axe", false, rand.nextInt(100) + 1);
//        } else if (chance > 60 && chance <= 80) {
//            return new ChestPlate("Chest plate", "Shiny Chest Plate", false, rand.nextInt(25), rand.nextInt(25));
//        } else {
//            return new Shield("Shield", "Cardboard shield", false, rand.nextInt(25) + 1, rand.nextInt(25) + 1);
//        }
//    }

//    public Item chanceOfItem() {
//        int chance = getRand().nextInt(100);
//        if (chance <= 35) {
//            return genItem();
//        }
//        return null;
//    }

    public Enemies genEnemy() {
        int chance = getRand().nextInt(30);
        if (chance <= 10) {
            return new Hest("Hest", 20 + getRand().nextInt(20), getRand().nextInt(25) + 1);
        } else if (chance > 10 && chance <= 20) {
            return new Enhjoerning("Enhjorning", 20 + getRand().nextInt(20), getRand().nextInt(25) + 1);
        } else {
            return new Ged("Ged", 20 + getRand().nextInt(20), getRand().nextInt(25) + 1);
        }
    }

    public Enemies chanceOfEnemy() {
        int chance = getRand().nextInt(100);
        if (chance <= 20) {
            return genEnemy();
        }
        return null;
    }

    public int blockChance() {
        return getRand().nextInt(100);
    }

    public boolean survived() {
        return getRand().nextInt(100) < 50;
    }

    /**
     * @return the rand
     */
    public Random getRand() {
        return rand;
    }

    /**
     * @return the trapChance
     */
    public int getTrapChance() {
        return trapChance;
    }

    /**
     * @return the swordChance
     */
    public int getSwordChance() {
        return swordChance;
    }

    /**
     * @return the axeChance
     */
    public int getAxeChance() {
        return axeChance;
    }

    /**
     * @return the broomChance
     */
    public int getBroomChance() {
        return broomChance;
    }

    /**
     * @return the shieldChance
     */
    public int getShieldChance() {
        return shieldChance;
    }

    /**
     * @return the chestPlateChance
     */
    public int getChestPlateChance() {
        return chestPlateChance;
    }

    /**
     * @return the treasureChance
     */
    public int getTreasureChance() {
        return treasureChance;
    }

}
