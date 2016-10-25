package textadv01;

public class Item {

    private String name;
    private String desc;
    private boolean acquired;
    
    public Item() {

    }

    public Item(String name, String desc, boolean acq) {
        this.name = name;
        this.desc = desc;
        this.acquired = acq;

    }

    public String acqItems() {
        if (this.acquired == true) {
            return this.name;
        } else {
            return "";
        }
    }

    public int getNumb() {
        return 0;
    }

    public int getDmg() {
        return 0;
    }

    public int getHpIncr() {
        return 0;
    }

    public int getDef() {
        return 0;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return the acquired
     */
    public boolean isAcquired() {
        return acquired;
    }

    /**
     * @param acquired the acquired to set
     */
    public void setAcquired(boolean acquired) {
        this.acquired = acquired;
    }

}
