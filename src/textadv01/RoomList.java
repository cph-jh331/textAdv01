/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadv01;

import java.util.ArrayList;

public class RoomList {

    private ArrayList<Room> roomList = new ArrayList<>();

    public void createRooms() {
        Randomness rand = new Randomness();
        //String desc, int north, int south, int east, int west, int gold
        //rum 0
        Room r = new Room(" stands inside the entrance of the Barrow.\n"
                + "The entrance is in decay, but maybe there is\n"
                + "something valuable in here...\n"
                + ""
                + "", 1, -1, -1, -1, rand.randomGold(), false);
        getRoomList().add(r);
        //rum 1
        r = new Room(" walks into a dark room, which seems\n"
                + "a little less in decay. Light seems to\n"
                + "come from the ceiling somehow…\n"
                + "you are not sure how that is possible.\n"
                + ""
                + "", 3, 0, 2, -1, rand.randomGold(), false);
        getRoomList().add(r);
        //rum 2
        r = new Room(" enters a room filled with broken glass and pottery.\n"
                + "Who goes around breaking glass and pottery, one wonders...\n"
                + ""
                + "", 4, -1, -1, 1, rand.randomGold(), false);
        getRoomList().add(r);
        //rum 3
        r = new Room(" enters a room filled with murals,\n"
                + "which seem to show a story of whoever is\n"
                + "buried in the Barrow.\n"
                + ""
                + "", 5, 1, 4, 6, rand.randomGold(), false);
        getRoomList().add(r);
        //rum 4
        r = new Room(" walks slowly into a room, where light\n"
                + "emanates from a small horse statue.\n"
                + ""
                + "", -1, 2, -1, 3, rand.randomGold(), false);
        getRoomList().add(r);
        //rum 5
        r = new Room(" goes into an alcove with a small rusty chest.\n"
                + "The light from the previous room plays with the rust,\n"
                + "making the chest seem alive.\n"
                + ""
                + "", -1, 3, -1, -1, rand.randomGold(), false);
        getRoomList().add(r);
        //rum 6
        r = new Room(" enters a tiny room with axes, swords and a mural\n"
                + "of a fearsome goat on the wall. The goat is covered\n"
                + "in blood and seems incredibly evil.\n"
                + ""
                + "", -1, -1, 3, 7, rand.randomGold(), false);
        getRoomList().add(r);
        //rum 7
        r = new Room(" walks into a large room filled with mixture of\n"
                + "murals and statues of all kinds of farm animals.\n"
                + "All of the creates does seem to like the presence\n"
                + " of an uninvited guest.\n"
                + "", 8, 9, 6, -1, rand.randomGold(), false);
        getRoomList().add(r);
        //rum 8
        r = new Room(" walks into an alcove with a statue of\n"
                + "a bloodthirsty bat. The bat seems to\n"
                + "look at the uninvited guest with a deep\n"
                + "hunger.\n"
                + ""
                + "", -1, 7, -1, -1, rand.randomGold(), false);
        getRoomList().add(r);
        //rum 9
        r = new Room(" enters a massive room made up by black polished marble.\n"
                + "The room is filled with murals of bloodthirsty\n"
                + "farm animals, even bunnies. Light emanates from\n"
                + "a small whole at the top of the room.\n"
                + "", 7, 10, -1, -1, rand.randomGold(), false);
        getRoomList().add(r);
        //rum 10
        r = new Room(""
                + " enters a room with a massive black throne, on it sits a\n"
                + "creature in full plate. The creature almost seems alive.\n"
                + "\n"
                + "The tunnel leading to the room suddenly collapses and\n"
                + "darkness fills the room.\n"
                + " This is the end…"
                + "", -1, -1, -1, -1, rand.randomGold(), true);
        getRoomList().add(r);

    }

    /**
     * @return the roomList
     */
    public ArrayList<Room> getRoomList() {
        return roomList;
    }

}
