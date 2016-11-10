package textadv01;

public class Combat {

    private Randomness rand = new Randomness();
    private Text text = new Text();
    private RoomList rl;

    private Player pl;
    private Trap trap;

    private int damage;
    private int potDropChance = 99;
    private int previousRoom = 0;

    public Combat(Player pl, Trap trap, RoomList rl) {
        this.rl = rl;
        this.pl = pl;
        this.trap = trap;
    }

    public void FightEnemy() {
        if (rl.getRoomList().get(pl.getRoom()).getrEnemies() != null) {
            text.out("----------------------------------------------------------------------------\n"
                    + "\tAn evil " + rl.getRoomList().get(pl.getRoom()).getrEnemies().getName() + " appeared!"
                    + "\n----------------------------------------------------------------------------");
            text.out("what to do:\n"
                    + "> attack - to attack.\n"
                    + "> defend - to try to block.\n"
                    + "> run away - to bravely run away.\n"
                    + "> hpot - to use a health potion.\n");
            while (rl.getRoomList().get(pl.getRoom()).getrEnemies() != null && rl.getRoomList().get(pl.getRoom()).getrEnemies().getHealth() > 0 && pl.getHealth() > 0) {

                text.enterText();

                switch (text.getInput()) {

                    case "attack":
                        text.out(playerAttack());
                        if (rl.getRoomList().get(pl.getRoom()).getrEnemies().getHealth() > 0) {
                            enemyAttack();
                        }
                        hpOverview();
                        break;
                    case "defend":
                        block();
                        hpOverview();
                        break;
                    case "hpot":
                        useHealthPot();
                        hpOverview();
                        break;
                    case "run away":
                        flee();
                        break;
                    default:
                        text.invalid();
                        enemyAttack();
                        hpOverview();
                        break;
                }

            }
            if (rl.getRoomList().get(pl.getRoom()).getrEnemies() != null && rl.getRoomList().get(pl.getRoom()).getrEnemies().getHealth() <= 0) {
                text.out("\tYou defeated " + rl.getRoomList().get(pl.getRoom()).getrEnemies().getName() + "\n");
                String enemyName = rl.getRoomList().get(pl.getRoom()).getrEnemies().getName();
                rl.getRoomList().get(pl.getRoom()).setrEnemies(null);
                if (checkPotDrop() == true) {
                    addPot();
                    text.droppedPot(enemyName);
                } else {
                    text.droppedNothing(enemyName);
                }
            }
        }
    }

    public void hpOverview() {
        text.out("\t" + pl.getName() + " HP: " + pl.getHealth() + "\n"
                + "\t" + rl.getRoomList().get(pl.getRoom()).getrEnemies().getName()
                + " HP: " + rl.getRoomList().get(pl.getRoom()).getrEnemies().getHealth()
                + "\n----------------------------------------------------------------------------");
    }

    public void enemyAttack() {
        text.out("\tEnemy hits you for " + rl.getRoomList().get(pl.getRoom()).getrEnemies().getDmg()
                + "\n----------------------------------------------------------------------------");
        pl.setHealth(pl.getHealth() - rl.getRoomList().get(pl.getRoom()).getrEnemies().getDmg());

    }

    public String playerAttack() {
        String attack = "----------------------------------------------------------------------------\n";

        if (pl.getEquip().getBody().get(0).getName().equalsIgnoreCase("Nothing") && pl.getEquip().getBody().get(1).getName().equalsIgnoreCase("Nothing")) {
            attack += "\t" + pl.getName() + " attacks the " + rl.getRoomList().get(pl.getRoom()).getrEnemies().getName() + " with his bare hands,\n"
                    + "\tdoing " + pl.getDmg() + " damage to it!";
        } else if (pl.getEquip().getBody().get(0).getDmg() > 0 || pl.getEquip().getBody().get(1).getDmg() > 0) {
            attack += "\t" + pl.getName() + " attacks the " + rl.getRoomList().get(pl.getRoom()).getrEnemies().getName()
                    + " with a " + pl.getEquip().getBody().get(0).getName()
                    + " and a " + pl.getEquip().getBody().get(1).getName() + ",\n"
                    + "\tdoing " + pl.getDmg() + " to the " + rl.getRoomList().get(pl.getRoom()).getrEnemies().getName() + "!";
        }

        rl.getRoomList().get(pl.getRoom()).getrEnemies().setHealth(rl.getRoomList().get(pl.getRoom()).getrEnemies().getHealth() - pl.getDmg());
        return attack;

    }

    public void block() {
        if (pl.getDef() >= rand.blockChance()) {
            text.out("----------------------------------------------------------------------------\n"
                    + "\tYou blocked the attack!\n"
                    + "----------------------------------------------------------------------------");
        } else {
            pl.setHealth(pl.getHealth() - rl.getRoomList().get(pl.getRoom()).getrEnemies().getDmg());
            text.out("----------------------------------------------------------------------------\n"
                    + "\tYou failed at blocking the attack!\n"
                    + "\tEnemy hits yout for " + rl.getRoomList().get(pl.getRoom()).getrEnemies().getDmg()
                    + "\n----------------------------------------------------------------------------");
        }

    }

    public void flee() {
        text.out("----------------------------------------------------------------------------\n"
                + "\tYou bravely run away!\n"
                + "----------------------------------------------------------------------------");
        pl.setRoom(pl.getPreviousRoom());

    }

    //sets trap dmg from a random number from 0 to trap maxDmg
    public void calcDmg() {
        damage = rand.genDmgDealt(trap.getMaxDmg());
    }

    //removes the damage from player heathl.
    public void calcHealth() {
        pl.setHealth(pl.getHealth() - damage);
    }

    //sees if you have pots
    public boolean checkNumPots(int numPot) {
        if (numPot > 0) {
            return true;
        } else {
            return false;
        }
    }

    //adds potHeal value to player health and romoves 1 pot from player.
    public void healYourself() {
        pl.setHealth(pl.getHealth() + pl.getHealFromPot());
        pl.getInv().minus1OfItem("health potion");
    }

    //checks if healht is bigger than 0.
    public boolean checkHealth(int health) {
        if (health <= 0) {
            return true;
        } else {
            return false;
        }
    }

    //checks if a pot is dropped.    
    public boolean checkPotDrop() {
        if (rand.genPotDrop() < potDropChance) {
            return true;
        } else {
            return false;
        }
    }

    //checks if you have any health pots and uses healYourself() if true.
    public void useHealthPot() {
        if (checkNumPots(pl.getNumberOfHpot()) == true) {
            healYourself();
            text.healed(pl.getName(), pl.getNumberOfHpot(), pl.getHealFromPot(), pl.getHealth());
        } else {
            text.noPots(pl.getName());
        }
    }

    //adds a health pot to player.
    public void addPot() {
        rl.getRoomList().get(pl.getRoom()).getInv().AddHealthPot(rl.getRoomList().get(pl.getRoom()).getInvItem(), 1);
        rl.getRoomList().get(pl.getRoom()).setTreasure(true);
    }

    //checks if you have taken to much damage.
    public void checkTooMuchDamage() {
        if (checkHealth(pl.getHealth()) == true) {
            text.deathLooms(pl.getName());
            trap.setKilledPlayer(true);
        }
    }

    /**
     * @return the trapDamage
     */
    public int getTrapDamage() {
        return damage;
    }

    /**
     * @return the previousRoom
     */
    public int getPreviousRoom() {
        return previousRoom;
    }

    /**
     * @param previousRoom the previousRoom to set
     */
    public void setPreviousRoom(int previousRoom) {
        this.previousRoom = previousRoom;
    }

}
