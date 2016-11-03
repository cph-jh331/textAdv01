package textadv01;

import java.util.ArrayList;

public class Equip extends Inventory2 {

    private Text text = new Text();
    private ArrayList<Item> body = new ArrayList<>(3);
    private String[] whereBody = {"Right Hand", "Left Hand", "Chest"};

    //0 er højrehånd, 1 er venstrehånd, 2 er chest.
    public Equip() {
        Item r = new Item();
        body.add(r);
        r = new Item();
        body.add(r);
        r = new Item();
        body.add(r);

        body.get(0).setName("Nothing");
        body.get(0).setDesc("An empty right hand");
        body.get(1).setName("Nothing");
        body.get(1).setDesc("An empty left hand");
        body.get(2).setName("Nothing");
        body.get(2).setDesc("It is your bare Chest");
    }

    public void equip(ArrayList<Item> inv) {
        boolean invalid = true;
        if (!inv.isEmpty()) {
            while (invalid == true) {
                text.equipWhatToDo(invToString(inv));
                text.enterText();
                if (tryParsing(text.getInput()) == true && inv.get(text.parseInput()) == null) {

                    System.out.println("Nothing at " + text.getInput());

                } else if (tryParsing(text.getInput()) == true && inv.get(text.parseInput()) != null) {
                    String name = inv.get(text.parseInput()).getName().toLowerCase();

                    if (name.equals("gold") || name.equals("health potion")) {
                        System.out.println(inv.get(text.parseInput()).getName()
                                + " is already equiped!");
                    } else if (!name.equals("gold") || !name.equals("health potion")) {
                        int index = text.parseInput();
                        equipWhere(inv, index);
                        break;
                    }
                } else if (text.getInput().equalsIgnoreCase("back")) {
                    System.out.println("You decided to not equip anything.");
                    break;
                } else {
                    text.invalid();
                }
            }
        }
    }

    public void equipWhere(ArrayList<Item> inv, int index) {
        boolean invalid = true;
        System.out.println("Where do you want to equip the " + inv.get(index).getName() + "?");
        System.out.println(equipToString());
        while (invalid == true) {

            text.enterText();
            if (tryParsing(text.getInput()) == true) {

                int inputNumb = text.parseInput();
                String invItemName = inv.get(index).getName().toLowerCase();
                String bodyItemName = body.get(inputNumb).getName().toLowerCase();

                switch (inputNumb) {
                    case 0:
                        if (!invItemName.contains("chest plate")) {
                            if (bodyItemName.equalsIgnoreCase("nothing")) {
                                System.out.println("You equip the " + inv.get(index).getName()
                                        + " on your " + whereBody[inputNumb] + ".\n"
                                        + "Replacing " + body.get(inputNumb).getName() + ".");
                                body.set(inputNumb, inv.get(index));
                                inv.remove(index);
                                invalid = false;

                                break;
                            } else {
                                System.out.println("You equip the " + inv.get(index).getName()
                                        + " on your " + whereBody[inputNumb] + ".\n"
                                        + "Replacing " + body.get(inputNumb).getName() + ".");
                                inv.add(body.get(inputNumb));
                                body.set(inputNumb, inv.get(index));
                                removeItemFromArray(inv, index);
                                invalid = false;
                                break;
                            }
                        } else {
                            System.out.println("You cannot put " + inv.get(index).getName() + " on your " + whereBody[inputNumb] + ".");
                        }
                        break;
                    case 1:
                        if (!invItemName.contains("chest plate")) {
                            if (bodyItemName.equalsIgnoreCase("nothing")) {
                                System.out.println("You equip the " + inv.get(index).getName()
                                        + " on your " + whereBody[inputNumb] + ".\n"
                                        + "Replacing " + body.get(inputNumb).getName() + ".");
                                body.set(inputNumb, inv.get(index));
                                inv.remove(index);
                                invalid = false;
                                break;
                            } else {
                                System.out.println("You equip the " + inv.get(index).getName()
                                        + " on your " + whereBody[inputNumb] + ".\n"
                                        + "Replacing " + body.get(inputNumb).getName() + ".");
                                inv.add(body.get(inputNumb));
                                body.set(inputNumb, inv.get(index));
                                removeItemFromArray(inv, index);
                                invalid = false;
                                break;
                            }
                        } else {
                            System.out.println("You cannot put " + inv.get(index).getName() + " on your " + whereBody[inputNumb] + ".");
                        }
                        break;
                    case 2:
                        if (invItemName.contains("chest plate")) {
                            if (bodyItemName.equalsIgnoreCase("nothing")) {
                                System.out.println("You equip the " + inv.get(index).getName()
                                        + " on your " + whereBody[inputNumb] + ".\n"
                                        + "Replacing " + body.get(inputNumb).getName() + ".");
                                body.set(inputNumb, inv.get(index));
                                inv.remove(index);
                                invalid = false;
                                break;
                            } else {
                                System.out.println("You equip the " + inv.get(index).getName()
                                        + " on your " + whereBody[inputNumb] + ".\n"
                                        + "Replacing " + body.get(inputNumb).getName() + ".");
                                inv.add(body.get(inputNumb));
                                body.set(inputNumb, inv.get(index));
                                removeItemFromArray(inv, index);
                                invalid = false;
                                break;
                            }
                        } else {
                            System.out.println("You cannot put a " + inv.get(index).getName() + " on your " + whereBody[inputNumb] + ".");
                        }
                        break;
                    default:
                        System.out.println("Invalid");
                        break;
                }

            } else if (invalid == false) {
                break;
            } else {
                System.out.println("You need to write a number");
            }

        }
    }

    public boolean tryParsing(String input) {
        boolean candoit = true;
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            candoit = false;
        }
        return candoit;
    }

    @Override
    public String invToString(ArrayList<Item> inv) {
        int counter = 1;
        String li = "";
        for (Item item : inv) {
            li += "\n" + counter + "\t" + item.toString();
            counter++;
        }
        return li;
    }

    @Override
    public String equipToString() {
        int counter = 1;
        int index = 0;
        String li = "";
        for (Item item : body) {
            li += "\n" + counter + "\t" + whereBody[index] + ": " + item.toString();
            counter++;
            index++;
        }
        return li;
    }

    @Override
    public String equipWithoutCounter() {
        int index = 0;
        String li = "";
        for (Item item : body) {
            li += "\n\t" + whereBody[index] + ": " + item.toString();
            index++;
        }
        return li;
    }

    /**
     * @return the body
     */
    public ArrayList<Item> getBody() {
        return body;
    }

    /**
     * @return the whereBody
     */
    public String[] getWhereBody() {
        return whereBody;
    }

}
