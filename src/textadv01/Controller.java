package textadv01;

public class Controller {

    private RoomList rl = new RoomList();
    private Player pl = new Player();
    private Trap trap = new Trap();
    private Highscore hs = new Highscore();
    private Room room = new Room(rl, pl);
    private Text st = new Text(rl, room, pl);
    private Combat com = new Combat(pl, trap, rl);
    private TrapCtrl trapCtrl = new TrapCtrl(trap, pl, com, rl);

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

        st.roomDescription(pl.getRoom());
        st.whatToDo();
        while (pl.getHealth() > 0 && rl.getRoomList().get(pl.getRoom()).theEnd() == false) {

            st.enterText();
            switch (st.getInput()) {
                //gets what dir you can go from the current room.
                case "move":
                    pl.setPreviousRoom(pl.getRoom());
                    st.roomDir();
                    room.goTo();
                    st.roomDescription(pl.getRoom());
                    com.FightEnemy();
                    break;
                //list the inventory of the current room.
                case "look":
                    st.startsLooking(room.getInvToString());
                    break;
                //transfers the rooms items to the player.
                case "take all":
                    trapCtrl.gloriousTrap();
                    st.out(pl.getInv().takeAll(room.getCurrentRoomInv(), pl.getInventory(), pl.getName()));
                    rl.getRoomList().get(pl.getRoom()).setTreasure(false);
                    break;
                //prints what in the player inventory
                case "inv":
                    st.checkInventory(pl.getInv().toString());
                    break;
                //uses a health potion...
                case "hpot":
                    st.textDivider2();
                    com.useHealthPot();
                    st.textDivider2();
                    break;
                //opens a list of options to equip.
                case "equip":
                    pl.getEquip().equip(pl.getInventory());
                    break;
                //shows player stats.
                case "stats":
                    st.textDivider2();
                    st.checkStats();
                    break;
                //prints out what to do.
                case "help":
                    st.whatToDo();
                    break;
                //shows the highscore.
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
            st.theEnd();

        } else if (pl.getHealth() <= 0 && trap.hasKilledPlayer() == true) {
            st.death();
            st.gotKilled(pl.getName(), trap.getName());

        }
        st.out(hs.highscoreNew(pl.getName(), pl.getGold()));
        st.out(hs.highScoreToString(pl.getName(), pl.getGold()));

    }

}
