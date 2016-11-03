package textadv01;

public class RoomInv extends Inventory2 {

    public void populateRandomInv() {
        addGold(getInv(), getRand().randomGold(5000));
        addRandomAxe(getInv(), getRand().genItem(getRand().getAxeChance()));        
        addRandomBroom(getInv(), getRand().genItem(getRand().getBroomChance()));        
        addRandomSword(getInv(), getRand().genItem(getRand().getSwordChance()));        
        addRandomChestPlate(getInv(), getRand().genItem(getRand().getChestPlateChance()));        
        addRandomShield(getInv(), getRand().genItem(getRand().getShieldChance()));        
        addRandomHorseShoe(getInv(), getRand().genItem(getRand().getHorseShoeChance()));
        

    }

}
