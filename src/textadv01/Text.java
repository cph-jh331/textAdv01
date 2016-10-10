/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadv01;

import java.util.Scanner;

public class Text {

    private Scanner input = new Scanner(System.in);

    RoomList rl;
    
    public Text(){
        
    }

    public Text(RoomList r) {
        rl = r;

    }

    public void roomDescription(int a) {
        System.out.println(rl.getRoomList().get(a).getRoomDesc());
    }
    
    public void allDirections(){
        System.out.println("You can walk in any direction.");        
    }

}
