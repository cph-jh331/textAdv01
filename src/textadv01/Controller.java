/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadv01;

public class Controller {

    private RoomList rl = new RoomList();
    private Player pl = new Player();
    private Trap trap = new Trap();
    private Item item = new Item();
    private Combat com = new Combat(pl, trap);
    private TrapCtrl trapCtrl = new TrapCtrl(trap, pl, com, rl);
    private Room room = new Room(rl, pl, trapCtrl, item);
    private Text st = new Text(rl, room, pl, item);

    public void run() {

        rl.createRooms();
        st.introArt();

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
        st.textDivider2();
        st.whatToDo();
        while (pl.getHealth() > 0 && rl.getRoomList().get(pl.getRoom()).theEnd() == false) {

            st.enterText();
            switch (st.getInput()) {

                //gets what dir you can go from the current room.
                case "move":
                    st.roomDir();
                    room.goTo();
                    st.textDivider();
                    st.roomDescription(pl.getRoom());
                    st.textDivider2();
                    break;

                //checks the gold amount of the current room.
                case "look for gold":
                    st.textDivider2();
                    st.lookingForGold();
                    st.goldCheck();
                    st.textDivider2();
                    break;

                case "look for items":
                    st.textDivider2();
                    st.lookingForItem();
                    st.itemCheck();
                    st.textDivider2();
                    break;

                //prints takes gold from the room and adds it to player gold.
                case "take all":
                    st.textDivider2();
                    st.takesTheGold();
                    pl.setGold(pl.getGold() + rl.getRoomList().get(pl.getRoom()).getGold());
                    rl.getRoomList().get(pl.getRoom()).setGold(0);
                    st.takesTheItem();
                    if (rl.getRoomList().get(pl.getRoom()).getrItem() != null) {
                        pl.setDmg(pl.getDmg() + rl.getRoomList().get(pl.getRoom()).getrItem().getDmg());
                        pl.setDef(pl.getDef() + rl.getRoomList().get(pl.getRoom()).getrItem().getDef());
                        pl.setHealth(pl.getHealth() + rl.getRoomList().get(pl.getRoom()).getrItem().getHpIncr());
                        rl.getRoomList().get(pl.getRoom()).getrItem().setAcquired(true);
                    }
                    trapCtrl.gloriousTrap();
                    break;

                //prints what in the player inventory
                case "inventory":
                    st.checkInventory();
                    break;
                //uses a health potion...
                case "use health pot":
                    com.useHealthPot();
                    break;

                case "stats":
                    st.checkStats();
                    break;

                //prints out what to do.
                case "help":
                    st.whatToDo();
                    break;

                //quits
                case "quit":
                    st.death();
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
        if (rl.getRoomList().get(pl.getRoom()).theEnd() == true) {
            st.textDivider2();
            pl.setGold(pl.getGold() + rl.getRoomList().get(pl.getRoom()).getGold());
            st.theEnd();

        } else if (pl.getHealth() <= 0 && trap.hasKilledPlayer() == true) {
            st.death();
            st.gotKilled(pl.getName(), trap.getName());

        }

    }

}