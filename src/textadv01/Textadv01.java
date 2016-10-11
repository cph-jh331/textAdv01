/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadv01;

/**
 *
 * @author bloch
 */
public class Textadv01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RoomList rl = new RoomList();
        Player pl = new Player();
        Room room = new Room(rl, pl);
        Text st = new Text(rl, room, pl);
        rl.createRooms();

//        System.out.println(rl.getRoomList().get(2).roomDirection());
//        room.goTo();
//        System.out.println(pl.getRoom());
        st.roomDescription(pl.getRoom());
        while (2 > 1) {
        st.whatToDo();
        st.enterText();
            switch (st.getInput()) {
               
                case "move":
                    st.roomDir();
                    room.goTo();
                    st.roomDescription(pl.getRoom());
                    break;
                    
                case "look for gold":
                    st.goldCheck();
                    break;
                    
                case "take gold":
                    pl.setGold(pl.getGold() + rl.getRoomList().get(pl.getRoom()).getGold());
                    rl.getRoomList().get(pl.getRoom()).setGold(0);
                    break;
                    
                case "inventory":
                    st.checkInventory();
                    break;
                    

            }
        }
    }
}
