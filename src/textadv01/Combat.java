package textadv01;

public class Combat {

    private Randomness rand = new Randomness();
    private Text text = new Text();
    private HealthPot pot = new HealthPot("Health Potion", "Useful Potion", false);
    private RoomList rl;
    private Inventory inv;

    private Player pl;
    private Trap trap;

    private int damage;
    private int potDropChance = 25;
    private int previousRoom = 0;

    public Combat(Player pl, Trap trap, RoomList rl, Inventory inv) {
        this.rl = rl;
        this.pl = pl;
        this.trap = trap;
        this.inv = inv;

    }

    public void FightEnemy() {
        if (rl.getRoomList().get(pl.getRoom()).getrEnemies() != null) {
            text.out("A evil " + rl.getRoomList().get(pl.getRoom()).getrEnemies().getName() + " appeared!");
            text.out("what to do:\n"
                    + "> attack - to attack.\n"
                    + "> defend - to try to block.\n"
                    + "> run away - to bravely run away.\n"
                    + "> hpot - to use a health potion.\n");
            while (rl.getRoomList().get(pl.getRoom()).getrEnemies() != null && rl.getRoomList().get(pl.getRoom()).getrEnemies().getHealth() > 0 && pl.getHealth() > 0) {

                text.enterText();

                switch (text.getInput()) {

                    case "attack":
                        playerAttack();
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
                text.out("You defeated " + rl.getRoomList().get(pl.getRoom()).getrEnemies().getName());
                rl.getRoomList().get(pl.getRoom()).setrEnemies(null);
            }
        }
    }

    public void hpOverview() {
        text.out(pl.getName() + " HP: " + pl.getHealth() + "\n"
                + rl.getRoomList().get(pl.getRoom()).getrEnemies().getName()
                + " HP: " + rl.getRoomList().get(pl.getRoom()).getrEnemies().getHealth());

    }

    public void enemyAttack() {
        text.out("Enemy hits you for " + rl.getRoomList().get(pl.getRoom()).getrEnemies().getDmg());
        pl.setHealth(pl.getHealth() - rl.getRoomList().get(pl.getRoom()).getrEnemies().getDmg());

    }

    public void playerAttack() {
        if (!inv.getWeaponList().isEmpty()) {
            System.out.println("What weapon do you want to use?\n" + inv.weaponListString());
            text.enterText();
            rl.getRoomList().get(pl.getRoom()).getrEnemies().setHealth(rl.getRoomList().get(pl.getRoom()).getrEnemies().getHealth() - (pl.getDmg() + inv.getDmg(Integer.parseInt(text.getInput()) - 1)));
            text.out("You hit the enemy for " + (pl.getDmg() + inv.getDmg(Integer.parseInt(text.getInput()) - 1)));

        } else {
            text.out("You only have your bare hands!");
            rl.getRoomList().get(pl.getRoom()).getrEnemies().setHealth(rl.getRoomList().get(pl.getRoom()).getrEnemies().getHealth() - pl.getDmg());
            text.out("You hit the enemy for " + pl.getDmg());
        }

    }

    public void block() {
        if (pl.getDef() >= rand.blockChance()) {
            text.out("You blocked the attack!");
        } else {
            pl.setHealth(pl.getHealth() - rl.getRoomList().get(pl.getRoom()).getrEnemies().getDmg());
            text.out("You failed at blocking the attack!\n"
                    + "Enemy hits yout for " + rl.getRoomList().get(pl.getRoom()).getrEnemies().getDmg());
        }

    }

    public void flee() {
        text.out("You bravely run away!\n");
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
        pl.setHealth(pl.getHealth() + pot.getHealAmount());
        pl.setHealthPotAmount(pl.getNumPots() - 1);
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
        if (checkNumPots(pl.getNumPots()) == true) {
            healYourself();
            text.healed(pl.getName(), pl.getNumPots(), pot.getHealAmount(), pl.getHealth());
        } else {
            text.noPots(pl.getName());
        }
    }

    //adds a health pot to player.
    public void addPot() {
        pl.setHealthPotAmount(pl.getNumPots() + 1);
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
