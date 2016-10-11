/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadv01;

import java.util.Scanner;

public class Text {
    
    Player pl;
    Room room;
    RoomList rl;
    Scanner scan = new Scanner(System.in);
    private String input;
    private String outDesc;

    public Text() {

    }

    public Text(RoomList r, Room ro, Player p) {
        rl = r;
        room = ro;
        pl = p;
    }

    public void outDescOfRoom(String name, String roomDesc) {
        System.out.println(name + roomDesc);
    }

    public void enterText() {
        input = scan.nextLine().toLowerCase();
    }

    public void roomDescription(int roomnr) {
        System.out.println(rl.getRoomList().get(roomnr).getRoomDesc());
    }

    public void allDirections() {
        System.out.println("You can walk North, South, East and West.");
    }

    public void directionNotWest() {
        System.out.println("You can walk North, South and East.");
    }

    public void directionNotEast() {
        System.out.println("You can walk North, South and West.");
    }

    public void directionNotSouth() {
        System.out.println("You can walk North, West and East.");
    }

    public void directionNotNorth() {
        System.out.println("You can walk South, West and East.");
    }

    public void directionNotSouthWest() {
        System.out.println("You can walk North and East.");
    }

    public void directionNotNorthWest() {
        System.out.println("You can walk South and East.");
    }

    public void directionNotEastWest() {
        System.out.println("You can walk North and South.");
    }

    public void directionNotSouthEast() {
        System.out.println("You can walk North and West.");
    }

    public void directionNotNorthEast() {
        System.out.println("You can walk South and West");
    }

    public void directionNotNorthSouth() {
        System.out.println("You can walk East and West.");
    }

    public void directionOnlyNorth() {
        System.out.println("You can only walk North.");
    }

    public void directionOnlySouth() {
        System.out.println("You can only walk South.");
    }

    public void directionOnlyWest() {
        System.out.println("You can only walk West.");
    }

    public void directionOnlyEast() {
        System.out.println("You can only walk East.");
    }

    public void noExit() {
        System.out.println("There is no exit!!!");
    }

    public void askForName() {
        System.out.println("Please name youself...");
    }

    public void doorNotThere() {
        System.out.println("There is no door there...");
    }

    public void invalid() {
        System.out.println("Invalid command...");
    }

    public void whatToDo() {
        System.out.println("\n What do you want to do? \n"
                + "type in any of these commands:\n"
                + "- move: to move the next room\n"
                + "- look for gold: to look for gold\n"
                + "- take gold: to take gold\n"
                + "- inventory: to check inventory\n"
                + "- help: to get commands\n"
                + "");
    }

    public void roomDir() {
        System.out.println(room.roomDirection());
    }
    
    public void goldCheck(){
        System.out.println("There is " + rl.getRoomList().get(pl.getRoom()).getGold() + " gold in this room");
    }
    
    public void checkInventory(){
        System.out.println("You currently have: " + pl.getGold() + " gold\n"
                + "");
        
    }

    /**
     * @return the input
     */
    public String getInput() {
        return input;
    }

}
