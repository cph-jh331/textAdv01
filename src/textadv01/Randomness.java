package textadv01;

import Enemy.Hest;
import Enemy.Ged;
import Enemy.Enhjoerning;
import Enemy.Enemies;
import java.util.Random;

public class Randomness {

    private Random rand = new Random();

    private final int trapChance = 25;
    private final int swordChance = 25;
    private final int axeChance = 25;
    private final int broomChance = 25;
    private final int shieldChance = 25;
    private final int chestPlateChance = 25;
    private final int treasureChance = 65;
    private final int horseShoeChance = 25;

    public int randomGold(int maxGold) {
        return getRand().nextInt(maxGold);        
    }

    public int genItem(int itemChance) {
        int chance = getRand().nextInt(100);
        if (chance < itemChance) {
            return 1;
        } else {
            return 0;
        }
    }

    public String RandomItemName(String[] names) {
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

    public int randomDmgStat(int minDmg) {
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
        if (chance <= 25) {
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

    /**
     * @return the horseShoeChance
     */
    public int getHorseShoeChance() {
        return horseShoeChance;
    }

}
