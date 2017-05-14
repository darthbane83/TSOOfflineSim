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
        return SniperTraining;
    }

    public void setSniperTraining(int sniperTraining) {
        SniperTraining = sniperTraining;
    }

    public int getOverrun() {
        return Overrun;
    }

    public void setOverrun(int overrun) {
        Overrun = overrun;
    }

    public int getRapidFire() {
        return RapidFire;
    }

    public void setRapidFire(int rapidFire) {
        RapidFire = rapidFire;
    }

    public int getJuggernaut() {
        return Juggernaut;
    }

    public void setJuggernaut(int juggernaut) {
        Juggernaut = juggernaut;
    }

    public int maxUnits = 0;
    public int masterPlanner = 0;
    public int lightningSlash = 0;
    public int cleave = 0;
    public int weeklyMaintenance = 0;
    public int garrisonAnnex = 0;
    public int unstoppableCharge = 0;
    public int battleFrenzy = 0;
    public int SniperTraining = 0;
    public int Overrun = 0;
    public int RapidFire = 0;
    public int Juggernaut = 0;


    @Override
    public boolean isGeneral() {
        return true;
    }
    public General(String name, int maxHP, int minDamage, int maxDamage, double accuracy, double attackInitiative, double defendInitiative, boolean splash, boolean flanking){
        super(name,maxHP,minDamage, maxDamage, accuracy, attackInitiative, defendInitiative, splash,flanking,1);
    }
}
