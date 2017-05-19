package units;

/**
 * Created by Jens on 12.05.2017.
 */
public class Unit {

    public int getMaxUnits() {
        return maxUnits;
    }

    public void setMaxUnits(int maxUnits) {
        this.maxUnits = maxUnits;
    }

    private int maxUnits;
    private String name;
    private int maxHp;
    private int currentHP;
    private int minDamage;
    private int maxDamage;
    private double accuracy;
    private double attackInitiative;
    private double defendInitiative;
    private boolean splash;
    private boolean flanking;
    private int remainingUnits;
    private boolean general = false;
    private boolean boss = false;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    private double value = Double.MAX_VALUE;




    public Unit(String name, int maxHP, int minDamage, int maxDamage, double accuracy, double attackInitiative, double defendInitiative, boolean splash, boolean flanking, int remainingUnits){
        this.setName(name);
        this.setMaxHp(maxHP);
        this.setCurrentHP(maxHp);
        this.setMinDamage(minDamage);
        this.setMaxDamage(maxDamage);
        this.setAccuracy(accuracy);
        this.setAttackInitiative(attackInitiative);
        this.setDefendInitiative(defendInitiative);
        this.setSplash(splash);
        this.setFlanking(flanking);
        this.setRemainingUnits(remainingUnits);
    }




    public Unit copy(){
        if (this.isGeneral()){
            General g = new General(getName(),getMaxHp(),getMinDamage(),getMaxDamage(),getAccuracy(),getAttackInitiative(),getDefendInitiative(),isSplash(),isFlanking());
            g.setValue(getValue());
            return g;
        }
        else{
            Unit u = new Unit(getName(),getMaxHp(),getMinDamage(),getMaxDamage(),getAccuracy(),getAttackInitiative(),getDefendInitiative(),isSplash(),isFlanking(),getRemainingUnits());
            u.setValue(getValue());
            return u;
        }
    }

    public int getRemainingUnits() {
        return remainingUnits;
    }

    public void setRemainingUnits(int remainingUnits) {
        this.remainingUnits = remainingUnits;
    }
    public String getName() {
        return name;
    }
    public boolean isGeneral(){return general;}
    public void setGeneral(boolean general){this.general = general;}
    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public double getAttackInitiative() {
        return attackInitiative;
    }

    public void setAttackInitiative(double attackInitiative) {
        this.attackInitiative = attackInitiative;
    }

    public double getDefendInitiative() {
        return defendInitiative;
    }

    public void setDefendInitiative(double defendInitiative) {
        this.defendInitiative = defendInitiative;
    }

    public boolean isSplash() {
        return splash;
    }

    public void setSplash(boolean splash) {
        this.splash = splash;
    }

    public boolean isFlanking() {
        return flanking;
    }

    public void setFlanking(boolean flanking) {
        this.flanking = flanking;
    }

    public boolean isBoss() {
        return boss;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }
}
