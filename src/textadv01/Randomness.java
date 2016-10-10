/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadv01;
import java.util.Random;

public class Randomness {
    Random rand = new Random();
    
    public int randomGold(){
        return rand.nextInt(2000);
    }
    
}
