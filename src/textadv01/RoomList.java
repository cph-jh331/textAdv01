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
                + "", 1, -1, -1, -1, rand.randomGold());
        getRoomList().add(r);
        //rum 1
        r = new Room(" walks into a dark room, which seems\n"
                + "a little less in decay. Light seems to\n"
                + "come from the ceiling somehow…\n"
                + "you are not sure how that is possible.\n"
                + ""
                + "", 3, 0, 2, -1, rand.randomGold());
        getRoomList().add(r);
        //rum 2
        r = new Room(" enters a room filled with broken glass and pottery.\n"
                + "Who goes around breaking glass and pottery, one wonders...\n"
                + ""
                + "", 4, -1, -1, 1, rand.randomGold());
        getRoomList().add(r);
        //rum 3
        r = new Room(" found another dark room...\n"
                + ""
                + "", 5, 1, 4, 6, rand.randomGold());
        getRoomList().add(r);
        //rum 4
        r = new Room(" found a somewhat lit room\n"
                + ""
                + "", -1, 2, -1, 3, rand.randomGold());
        getRoomList().add(r);
        //rum 5
        r = new Room(" entered a dead end!\n"
                + ""
                + "", -1, 3, -1, -1, rand.randomGold());
        getRoomList().add(r);
        //rum 6
        r = new Room(" have entered a small room\n"
                + ""
                + "", -1, -1, 3, 7, rand.randomGold());
        getRoomList().add(r);
        //rum 7
        r = new Room(" have entered a large room\n"
                + "", 8, 9, 6, -1, rand.randomGold());
        getRoomList().add(r);
        //rum 8
        r = new Room(" have entered a dead end!\n"
                + ""
                + "", -1, 7, -1, -1, rand.randomGold());
        getRoomList().add(r);
        //rum 9
        r = new Room(" have entered a large and light room.\n"
                + "", 7, 10, -1, -1, rand.randomGold());
        getRoomList().add(r);
        //rum 10
        r = new Room(""
                + " have reached the end of the Dungeon.\n"
                + "", -1, -1, -1, -1, rand.randomGold());
        getRoomList().add(r);

    }

    /**
     * @return the roomList
     */
    public ArrayList<Room> getRoomList() {
        return roomList;
    }

}
