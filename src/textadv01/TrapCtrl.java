/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadv01;

public class TrapCtrl {

    private Text text = new Text();
    Trap trap;
    Player pl;
    Combat com;
    RoomList rl;

    public TrapCtrl(Trap trap, Player pl, Combat com, RoomList rl) {
        this.com = com;
        this.pl = pl;
        this.trap = trap;
        this.rl = rl;
    }

    public TrapCtrl() {

    }

    public void gloriousTrap() {

        if (rl.getRoomList().get(pl.getRoom()).isTrap() == true) {
            trap.genTrapName();
            text.textDivider();
            text.trapThere(pl.getName(), trap.getName());
            text.textDivider2();
        }
        
        while (rl.getRoomList().get(pl.getRoom()).isTrap() == true) {
            text.trapWhatToDo();

            while (com.checkHealth(pl.getHealth()) == false && rl.getRoomList().get(pl.getRoom()).isTrap() == true) {
                text.enterText();

                switch (text.getInput()) {
                    case "jump":
                        com.calcDmg();
                        com.calcHealth();
                        text.trapDealtDmg(trap.getName(), pl.getName(), com.getTrapDamage());
                        rl.getRoomList().get(pl.getRoom()).setTrap(false);
                        break;
                    case "use health pot":
                        com.useHealthPot();
                        break;

                    default:
                        text.invalid();
                }
                com.checkTooMuchDamage();
                break;

            }
            if (rl.getRoomList().get(pl.getRoom()).isTrap() == false) {
                text.survivedTrap(pl.getName(), trap.getName(), pl.getHealth());
                if (com.checkPotDrop() == true) {
                    com.addPot();
                    text.droppedPot(trap.getName());
                } else {
                    text.droppedNothing(trap.getName());
                }
            }
        }
    }

}
