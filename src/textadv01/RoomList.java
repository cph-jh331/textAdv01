/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadv01;

import java.util.ArrayList;

public class RoomList {

    private ArrayList<Room> roomList = new ArrayList<>();
    private Gold g = new Gold("Gold", "Gold coins", true);

    public void createRooms() {
        Randomness rand = new Randomness();
        //String desc, int north, int south, int east, int west, int gold, boolean trap, boolean endRoom;
        //rum 0
        Room r = new Room(" stands inside the entrance of the Barrow.\n"
                + "\tThe entrance is in decay, but maybe there is\n"
                + "\tsomething valuable in here..."
                + ""
                + "", 1, -1, -1, -1, g.getNumbOfGold(), true, false, rand.chanceOfItem());
        getRoomList().add(r);
        //rum 1
        r = new Room(" walks into a dark room, which seems\n"
                + "\ta little less in decay. Light seems to\n"
                + "\tcome from the ceiling somehow…\n"
                + "\tyou are not sure how that is possible."
                + ""
                + "", 3, 0, 2, -1, g.getNumbOfGold(), false, false, rand.chanceOfItem());
        getRoomList().add(r);
        //rum 2
        r = new Room(" enters a room filled with broken glass and pottery.\n"
                + "\tWho goes around breaking glass and pottery, one wonders..."
                + ""
                + "", 4, -1, -1, 1, g.getNumbOfGold(), rand.genTrap(), false, rand.chanceOfItem());
        getRoomList().add(r);
        //rum 3
        r = new Room(" enters a room filled with murals,\n"
                + "\twhich seem to show a story of whoever is\n"
                + "\tburied in the Barrow."
                + ""
                + "", 5, 1, 4, 6, g.getNumbOfGold(), rand.genTrap(), false, rand.chanceOfItem());
        getRoomList().add(r);
        //rum 4
        r = new Room(" walks slowly into a room, where light\n"
                + "\temanates from a small horse statue."
                + ""
                + "", -1, 2, -1, 3, g.getNumbOfGold(), rand.genTrap(), false, rand.chanceOfItem());
        getRoomList().add(r);
        //rum 5
        r = new Room(" goes into an alcove with a small rusty chest.\n"
                + "\tThe light from the previous room plays with the rust,\n"
                + "\tmaking the chest seem alive."
                + ""
                + "", -1, 3, -1, -1, g.getNumbOfGold(), rand.genTrap(), false, rand.chanceOfItem());
        getRoomList().add(r);
        //rum 6
        r = new Room(" enters a tiny room with axes, swords and a mural\n"
                + "\tof a fearsome goat on the wall. The goat is covered\n"
                + "\tin blood and seems incredibly evil."
                + ""
                + "", -1, -1, 3, 7, g.getNumbOfGold(), rand.genTrap(), false, rand.chanceOfItem());
        getRoomList().add(r);
        //rum 7
        r = new Room(" walks into a large room filled with mixture of\n"
                + "\tmurals and statues of all kinds of farm animals.\n"
                + "\tAll of the creates does seem to like the presence\n"
                + "\tof an uninvited guest."
                + "", 8, 9, 6, -1, g.getNumbOfGold(), rand.genTrap(), false, rand.chanceOfItem());
        getRoomList().add(r);
        //rum 8
        r = new Room(" walks into an alcove with a statue of\n"
                + "\ta bloodthirsty bat. The bat seems to\n"
                + "\tlook at the uninvited guest with a deep\n"
                + "\thunger."
                + ""
                + "", -1, 7, -1, -1, g.getNumbOfGold(), rand.genTrap(), false, rand.chanceOfItem());
        getRoomList().add(r);
        //rum 9
        r = new Room(" enters a massive room made up by black polished marble.\n"
                + "\tThe room is filled with murals of bloodthirsty\n"
                + "\tfarm animals, even bunnies. Light emanates from\n"
                + "\ta small whole at the top of the room."
                + "", 7, 10, -1, -1, g.getNumbOfGold(), rand.genTrap(), false, rand.chanceOfItem());
        getRoomList().add(r);
        //rum 10
        r = new Room(""
                + " enters a room with a massive black throne, on it sits a\n"
                + "\tcreature in full plate. The creature almost seems alive.\n"
                + "\n"
                + "\tThe tunnel leading to the room suddenly collapses and\n"
                + "\tdarkness fills the room.\n"
                + "\tThis is the end…"
                + "", -1, -1, -1, -1, g.getNumbOfGold(), false, true, rand.chanceOfItem());
        getRoomList().add(r);

    }

    /**
     * @return the roomList
     */
    public ArrayList<Room> getRoomList() {
        return roomList;
    }

}
