package textadv01;

public class RoomInv extends Inventory2 {

    public void populateRandomInv() {
        addGold(getInventory(), getRand().randomGold(5000));
        addRandomAxe(getInventory(), getRand().genItem(getRand().getAxeChance()));        
        addRandomBroom(getInventory(), getRand().genItem(getRand().getBroomChance()));        
        addRandomSword(getInventory(), getRand().genItem(getRand().getSwordChance()));        
        addRandomChestPlate(getInventory(), getRand().genItem(getRand().getChestPlateChance()));        
        addRandomShield(getInventory(), getRand().genItem(getRand().getShieldChance()));        
        addRandomHorseShoe(getInventory(), getRand().genItem(getRand().getHorseShoeChance()));
        

    }

}
