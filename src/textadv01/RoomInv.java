package textadv01;

public class RoomInv extends Inventory2 {

    public void populateRandomInv() {
        addGold(getInv(), getRand().randomGold(5000));
        addRandomAxe(getInv(), getRand().genItem(getRand().getAxeChance()));
        System.out.println("checking axe");
        addRandomBroom(getInv(), getRand().genItem(getRand().getBroomChance()));
        System.out.println("checking broom");
        addRandomSword(getInv(), getRand().genItem(getRand().getSwordChance()));
        System.out.println("checking sword");
        addRandomChestPlate(getInv(), getRand().genItem(getRand().getChestPlateChance()));
        System.out.println("checking plate");
        addRandomShield(getInv(), getRand().genItem(getRand().getShieldChance()));
        System.out.println("checking shield");

    }

}
