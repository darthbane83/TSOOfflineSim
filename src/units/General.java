package units;

/**
 * Created by Jens on 14.05.2017.
 */
public class General extends Unit {
    public int getMaxUnits() {
        return maxUnits;
    }

    public void setMaxUnits(int maxUnits) {
        this.maxUnits = maxUnits;
    }

    public int getMasterPlanner() {
        return masterPlanner;
    }

    public void setMasterPlanner(int masterPlanner) {
        this.masterPlanner = masterPlanner;
    }

    public int getLightningSlash() {
        return lightningSlash;
    }

    public void setLightningSlash(int lightningSlash) {
        this.lightningSlash = lightningSlash;
    }

    public int getCleave() {
        return cleave;
    }

    public void setCleave(int cleave) {
        this.cleave = cleave;
    }

    public int getWeeklyMaintenance() {
        return weeklyMaintenance;
    }

    public void setWeeklyMaintenance(int weeklyMaintenance) {
        this.weeklyMaintenance = weeklyMaintenance;
    }

    public int getGarrisonAnnex() {
        return garrisonAnnex;
    }

    public void setGarrisonAnnex(int garrisonAnnex) {
        this.garrisonAnnex = garrisonAnnex;
    }

    public int getUnstoppableCharge() {
        return unstoppableCharge;
    }

    public void setUnstoppableCharge(int unstoppableCharge) {
        this.unstoppableCharge = unstoppableCharge;
    }

    public int getBattleFrenzy() {
        return battleFrenzy;
    }

    public void setBattleFrenzy(int battleFrenzy) {
        this.battleFrenzy = battleFrenzy;
    }

    public int getSniperTraining() {
        return sniperTraining;
    }

    public void setSniperTraining(int sniperTraining) {
        this.sniperTraining = sniperTraining;
    }

    public int getOverrun() {
        return overrun;
    }

    public void setOverrun(int overrun) {
        this.overrun = overrun;
    }

    public int getRapidFire() {
        return rapidFire;
    }

    public void setRapidFire(int rapidFire) {
        this.rapidFire = rapidFire;
    }

    public int getJuggernaut() {
        return juggernaut;
    }

    public void setJuggernaut(int juggernaut) {
        this.juggernaut = juggernaut;
    }

    public int maxUnits = 0;
    public int masterPlanner = 0;
    public int lightningSlash = 0;
    public int cleave = 0;
    public int weeklyMaintenance = 0;
    public int garrisonAnnex = 0;
    public int unstoppableCharge = 0;
    public int battleFrenzy = 0;
    public int sniperTraining = 0;
    public int overrun = 0;
    public int rapidFire = 0;
    public int juggernaut = 0;


    @Override
    public Unit copy(){
        General g = new General(getName(),getMaxHp(),getMinDamage(),getMaxDamage(),getAccuracy(),getAttackInitiative(),getDefendInitiative(),isSplash(),isFlanking());
        g.setMaxUnits(this.maxUnits);
        g.setMasterPlanner(this.masterPlanner);
        g.setLightningSlash(this.lightningSlash);
        g.setCleave(this.cleave);
        g.setWeeklyMaintenance(this.weeklyMaintenance);
        g.setGarrisonAnnex(garrisonAnnex);
        g.setUnstoppableCharge(unstoppableCharge);
        g.setBattleFrenzy(battleFrenzy);
        g.setSniperTraining(sniperTraining);
        g.setOverrun(overrun);
        g.setRapidFire(rapidFire);
        g.setJuggernaut(juggernaut);
        g.setRemainingUnits(getRemainingUnits());
        return g;
    }

    @Override
    public boolean isGeneral() {
        return true;
    }
    public General(String name, int maxHP, int minDamage, int maxDamage, double accuracy, double attackInitiative, double defendInitiative, boolean splash, boolean flanking){
        super(name,maxHP,minDamage, maxDamage, accuracy, attackInitiative, defendInitiative, splash,flanking,1);
    }
}
