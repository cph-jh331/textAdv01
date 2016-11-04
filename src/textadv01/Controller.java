package textadv01;

public class Controller {

    private RoomList rl = new RoomList();
    private Player pl = new Player();
    private Room room = new Room(rl, pl);    
    private Trap trap = new Trap();
    private Combat com = new Combat(pl, trap, rl);
    private TrapCtrl trapCtrl = new TrapCtrl(trap, pl, com, rl);
    private Text st = new Text(rl, room, pl);
    private Highscore hs = new Highscore();

    public void run() {
        hs.readFileToArrays();
        pl.getInv().populatePlayerInv();        
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
                    pl.setPreviousRoom(pl.getRoom());
                    st.textDivider2();
                    st.roomDir();
                    st.textDivider2();
                    room.goTo();
                    com.FightEnemy();
                    st.textDivider();
                    st.roomDescription(pl.getRoom());
                    st.textDivider2();
                    break;

                case "look":
                    st.startsLooking(rl.getRoomList().get(pl.getRoom()).getInv().toString());
                    break;

                case "take all":
                    st.out(pl.getInv().takeAll(rl.getRoomList().get(pl.getRoom()).getInventoryList(), pl.getInventory(), pl.getName()));
                    rl.getRoomList().get(pl.getRoom()).setTreasure(false);
                    trapCtrl.gloriousTrap();
                    break;
                //prints what in the player inventory
                case "inv":
                    st.textDivider2();
                    st.checkInventory(pl.getInv().toString());
                    st.textDivider2();
                    break;
                //uses a health potion...
                case "hpot":
                    st.textDivider2();
                    com.useHealthPot();
                    st.textDivider2();
                    break;

                case "equip":
                    pl.getEquip().equip(pl.getInventory());
                    break;

                case "stats":
                    st.textDivider2();
                    st.checkStats();
                    break;

                //prints out what to do.
                case "help":
                    st.whatToDo();
                    break;

                case "highscore":
                    st.out(hs.highScoreToString(pl.getName(), pl.getGold()));
                    break;

                //quits
                case "quit":
                    st.death();
                    st.quitting();
                    st.out(hs.highscoreNew(pl.getName(), pl.getGold()));
                    st.out(hs.highScoreToString(pl.getName(), pl.getGold()));
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
            st.theEnd();

        } else if (pl.getHealth() <= 0 && trap.hasKilledPlayer() == true) {
            st.death();
            st.gotKilled(pl.getName(), trap.getName());

        }
        st.out(hs.highscoreNew(pl.getName(), pl.getGold()));
        st.out(hs.highScoreToString(pl.getName(), pl.getGold()));

    }

}
