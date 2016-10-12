package textadv01;

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
        
        st.textDivider();
        while (true) {
            st.intro();
            st.enterName();

            if (!st.getInput().equals("")) {
                pl.setName(st.getInput());
                st.settedName();
                break;
            }

        }
        
        st.textDivider();
        st.roomDescription(pl.getRoom());
        st.whatToDo();
        while (2 > 1 && rl.getRoomList().get(pl.getRoom()).theEnd() == false) {
            st.enterText();
            switch (st.getInput()) {

                    //gets what dir you can go from the current room.
                case "move":
                    st.roomDir();
                    room.goTo();
                    st.textDivider();
                    st.roomDescription(pl.getRoom());
                    break;
                    
                    //checks the gold amount of the current room.
                case "look for gold":
                    st.lookingForGold();
                    st.goldCheck();
                    break;
                    
                    //prints takes gold from the room and adds it to player gold.
                case "take gold":
                    st.takesTheGold();
                    pl.setGold(pl.getGold() + rl.getRoomList().get(pl.getRoom()).getGold());
                    rl.getRoomList().get(pl.getRoom()).setGold(0);
                    break;

                    //prints what in the player inventory
                case "inventory":
                    st.checkInventory();
                    break;
                    
                    //prints out what to do.
                case "help":
                    st.whatToDo();
                    break;
                    
                    //quits
                case "quit":
                    st.quitting();
                    return;
                    
                    //admin hax!!! Takes you to the end.
                case "teleport":
                    st.textDivider();
                    pl.setRoom(10);
                    st.roomDescription(pl.getRoom());
                    break;

                default:
                    st.invalid();

            }
        }
        pl.setGold(pl.getGold() + rl.getRoomList().get(pl.getRoom()).getGold());
        st.theEnd();
    }
}
