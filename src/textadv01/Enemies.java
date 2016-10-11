/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadv01;

import java.util.Random;

public class Enemies {
    private Random rand = new Random();
    private int dmg = 75;
    private int maxHealth = 80;
    private String[] names = {"Goat", "Bat", "Horse"};
    private String name;
    public void names() {

        name = names[rand.nextInt(names.length)];

    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
}
