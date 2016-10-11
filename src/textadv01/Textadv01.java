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
        Text st = new Text(rl);
        Room room = new Room(rl, pl);
        rl.createRooms();
        
        
//        System.out.println(rl.getRoomList().get(2).roomDirection());
//        room.goTo();
//        System.out.println(pl.getRoom());
        
        
        st.roomDescription(pl.getRoom());
        st.enterText();
        st.whatToDo();
        switch (st.getInput()){
            
            case "move":
                    room.roomDirection();
                    room.goTo();
                    
                        
                    
                   
           
        }
    }
}