/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadv01;

import java.util.ArrayList;

/**
 *
 * @author bloch
 */
public class RoomList {

    private ArrayList<Room> roomList = new ArrayList<>();

    public void createRooms() {
        Randomness rand = new Randomness();
    //String desc, int north, int south, int east, int west, int gold
    //rum 0
        Room r = new Room("You stand in a doorway to a dungeon...\n" 
                + "To go north, type north\n"
                + "To go south, type south\n"
                + "To go East, type east\n"
                + "To go West, type west\n"
                + "You can only walk North"
                + "", 1, -1, -1, -1, rand.randomGold());
        getRoomList().add(r);
        //rum 1
        r = new Room("You have entered a dark room!\n"
                + ""
                + "You can walk North, South and East.", 3, 0, 2, -1, rand.randomGold());
        getRoomList().add(r);
        //rum 2
        r = new Room("You enter another dark room!\n" 
                + ""
                + "You can walk North and South.", 4, -1, -1, 1, rand.randomGold());
        getRoomList().add(r);
        //rum 3
        r = new Room("You found another dark room...\n"
                + ""
                + "You can walk North, South, West and East", 5, 1, 4, 6, rand.randomGold());
        getRoomList().add(r);
        //rum 4
        r = new Room("You found a somewhat lit room\n"
                + ""
                + "You can walk South and West.", -1, 2, -1, 3, rand.randomGold());
        getRoomList().add(r);
        //rum 5
        r = new Room("You entered a dead end!\n"
                + ""
                + "You can only walk South.", -1, 3, -1, -1, rand.randomGold());
        getRoomList().add(r);
        //rum 6
        r = new Room("You have entered a small room\n"
                + ""
                + "You can walk East and West.", -1, -1, 3, 7, rand.randomGold());
        getRoomList().add(r);
        //rum 7
        r = new Room("You have entered a large room\n"
                + "You walk North, South and East.", 8, 9, 6, -1, rand.randomGold());
        getRoomList().add(r);
        //rum 8
        r = new Room("You have entered a dead end!\n"
                + ""
                + "You can only walk South", -1, 7, -1, -1, rand.randomGold());
        getRoomList().add(r);
        //rum 9
        r = new Room("You have entered a large and light room.\n"
                + "You can walk to North and South.", 7, 10, -1, -1, rand.randomGold());
        getRoomList().add(r);
        //rum 10
        r = new Room(""
                + "You have reached the end of the Dungeon.\n"
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