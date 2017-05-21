package units;

/**
 * Created by Jens on 15.05.2017.
 */
public class UnitFactory {
    public UnitFactory(){

    }


    //region Generals
    //skilled example Generals
    public Unit createCustomAnslem(){
        General g = new General("Anslem",150,1000,1500,0.5,2.7,3,true,true);
        g.setMaxUnits(150);
        g.setGeneral(true);
        g.setOverrun(3);
        g.setBattleFrenzy(3);
        g.setGarrisonAnnex(3);
        g.setWeeklyMaintenance(2);
        return g;
    }

    public Unit createCustomNusala(){
        General g = new General("Nusala",150,1000,1500,0.90,1.1,3,true,true);
        g.setMaxUnits(165);
        g.setGeneral(true);
        g.setRapidFire(3);
        return g;

    }
    public Unit createCustomMMA(){
        General g = new General("MMA",2,450,500,0.80,1.1,3,true,true);
        g.setMaxUnits(220);
        g.setGeneral(true);
        return g;

    }
    public Unit createCustom270(){
        General g = new General("270",1,120,120,1,2.7,3,false,false);
        g.setMaxUnits(270);
        g.setGeneral(true);
        return g;
    }
    public Unit createCustomVargus(){
        General g = new General("Vargus",200,750,1250,0.8,1.2,3,true,true);
        g.setMaxUnits(180);
        g.setGeneral(true);
        return g;
    }

    //General
    public Unit createNusala(){
        General g = new General("Nusala",150,1000,1500,0.90,1.2,3,true,true);
        g.setMaxUnits(165);
        g.setGeneral(true);
        return g;

    }
    public Unit createMMA(){
        General g = new General("MMA",2,450,500,0.80,1.2,3,true,true);
        g.setMaxUnits(220);
        g.setGeneral(true);
        return g;

    }
    public Unit create270(){
        General g = new General("270",1,120,120,1,2.7,3,false,false);
        g.setMaxUnits(270);
        g.setGeneral(true);
        return g;
    }
    public Unit createAnslem(){
        General g = new General("Anslem",150,1000,1500,0.5,2.7,3,true,true);
        g.setMaxUnits(150);
        g.setGeneral(true);
        return g;
    }
    public Unit createVargus(){
        General g = new General("Vargus",200,750,1250,0.8,1.2,3,true,true);
        g.setMaxUnits(180);
        g.setGeneral(true);
        return g;
    }
    //endregion


    //region Elite units
    //known defend initiative:
    //known attack initiative:
    public Unit createPlayerSM(int remainingUnits){
        Unit u = new Unit("PlayerSM",150,40,80,0.9,2,1.0,false,false,remainingUnits);
        u.setValue(1);
        return u;
    }

    public Unit createPlayerMS(int remainingUnits){
        Unit u = new Unit("PlayerMS",250,25,50,0.9,2.1,1.1,false,false,remainingUnits);
        u.setValue(1.5);
        return u;

    }

    public Unit createPlayerK(int remainingUnits){
        Unit u = new Unit("PlayerK",80,35,70,0.9,1,1.2,false,false,remainingUnits);
        u.setValue(1);
        return u;
    }

    public Unit createPlayerMA(int remainingUnits){
        Unit u = new Unit("PlayerMA",50,50,100,0.9,2,2.0,false,false,remainingUnits);
        u.setValue(2);
        return u;
    }

    public Unit createPlayerAM(int remainingUnits){
        Unit u = new Unit("PlayerAM",50,100,200,0.9,2,2.1,false,true,remainingUnits);
        u.setValue(3);
        return u;
    }

    public Unit createPlayerMM(int remainingUnits){
        Unit u = new Unit("PlayerMM",50,50,100,0.9,1,2.2,true,false,remainingUnits);
        u.setValue(3);
        return u;
    }

    public Unit createPlayerB(int remainingUnits){
        Unit u = new Unit("PlayerB",80,100,200,0.9,3,2.0,true,false,remainingUnits);
        u.setValue(5);
        return u;
    }
    //endregion

    //region Standard units
    public Unit createPlayerR(int remainingUnits){
        Unit u = new Unit("PlayerR",40,15,30,0.8,2,1,false,false,remainingUnits);
        u.setValue(1);
        return u;
    }

    public Unit createPlayerM(int remainingUnits){
        Unit u = new Unit("PlayerM",60,20,40,0.8,2,1.1,false,false,remainingUnits);
        u.setValue(4);
        return u;
    }

    public Unit createPlayerS(int remainingUnits){
        Unit u = new Unit("PlayerS",90,20,40,0.85,2,1.2,false,false,remainingUnits);
        u.setValue(5);
        return u;
    }

    public Unit createPlayerES(int remainingUnits){
        Unit u = new Unit("PlayerES",120,20,40,0.9,2,1.3,false,false,remainingUnits);
        u.setValue(12);
        return u;
    }

    public Unit createPlayerC(int remainingUnits){
        Unit u = new Unit("PlayerC",5,5,10,0.8,1,2,false,true,remainingUnits);
        u.setValue(4);
        return u;
    }

    public Unit createPlayerBow(int remainingUnits){
        Unit u = new Unit("PlayerBow",10,20,40,0.8,2,2.1,false,false,remainingUnits);
        u.setValue(1.5);
        return u;
    }

    public Unit createPlayerLB(int remainingUnits){
        Unit u = new Unit("PlayerLB",10,30,60,0.8,2,2.2,false,false,remainingUnits);
        u.setValue(3);
        return u;
    }

    public Unit createPlayerXB(int remainingUnits){
        Unit u = new Unit("PlayerXB",10,45,90,0.8,2,2.3,false,false,remainingUnits);
        u.setValue(12);
        return u;
    }

    public Unit createPlayerCN(int remainingUnits){
        Unit u = new Unit("PlayerCN",60,60,120,0.9,3,2.4,false,false,remainingUnits);
        u.setValue(50);
        return u;
    }
    //endregion

    //region Bandits
    public Unit bWildMary(int remainingUnits){
        Unit u = new Unit("Wild Mary",60000, 740, 800, 0.5, 1,  2.0, true, false,remainingUnits);
        u.setBoss(true);
        return u;
    }
    public Unit bChuck(int remainingUnits){
        Unit u = new Unit("Chuck",9000, 2000, 2500, 0.5, 3,  3.0, true, false,remainingUnits);
        u.setBoss(true);
        return u;
    }
    public Unit bMetalToothed(int remainingUnits) {
        Unit u = new Unit("Metal Toothed",11000,250,500,0.5, 3, 2.0,true,false,remainingUnits);
        u.setBoss(true);
        return u;
    }
    public Unit bScavenger(int remainingUnits){
        return new Unit("Scavenger",40, 15,30, 0.6, 2, 2.1,false, false, remainingUnits);
    }
    public Unit bThug(int remainingUnits) {
        return new Unit("Thug", 60, 20, 40, 0.6, 2.1, 2.2, false, false, remainingUnits);
    }
    public Unit bGuardDog(int remainingUnits) {
        return new Unit("Guard Dog", 5, 5, 10, 0.6, 1, 2.05, false, true, remainingUnits);
    }
    public Unit bRoughneck(int remainingUnits) {
        return new Unit("Roughneck", 90, 20, 40, 0.6, 2.2, 2.3, false, false, remainingUnits);
    }
    public Unit bStoneThrower(int remainingUnits) {
        return new Unit("Stone Thrower", 10, 20, 40, 0.6, 2.3, 2.4, false, false, remainingUnits);
    }
    public Unit bRanger(int remainingUnits) {
        return new Unit("Ranger", 10, 30, 0, 0.6, 2.4, 2.5, false, false, remainingUnits);
    }
    public Unit bSkunk(int remainingUnits) {
        Unit u = new Unit("Skunk", 100, 1, 100, 0.5, 3, 2.6, true, false, remainingUnits);
        u.setBoss(true);
        return u;
    }
    public Unit bOneEyedBert(int remainingUnits) {
        Unit u = new Unit("One-Eyed Bert", 6000, 300, 500, 0.5, 3.1, 2.7, true, false, remainingUnits);
        u.setBoss(true);
        return u;
    }
    //endregion

    //region cultists

    public Unit darkMagician(int remainingUnits){
        Unit u = new Unit("Dark Magician", 30000, 2000, 2500, 0.8, 2.9, 3, true, false, remainingUnits);
        u.setBoss(true);
        return u;
    }

    //endregion



    //region Wildlife
    /*
    * defend initiative info: Boar<wolfpackleader<Fox<Giant<furious boar
    *                           Bear<Wolf<Fox<Giant<Deer
    *                           Boar<Wolf
    * attack initiative info:
        boar<furious boar
    *
    * */

    public Unit epDeer(int remainingUnits){
        return new Unit("Deer", 15, 5, 10, 0.8, 2.7, 2.8, false, false, remainingUnits);
    }
    public Unit epBoar(int remainingUnits){
        return new Unit("Boar", 100, 30, 60, 0.85, 2.0, 1.0, false, false, remainingUnits);
    }
    public Unit epBear(int remainingUnits){
        return new Unit("Bear", 140, 70, 90, 0.95, 2.1, 1.1, true, false, remainingUnits);
    }
    public Unit epWolf(int remainingUnits){
        return new Unit("Wolf", 40, 60, 100, 0.85, 2.2, 2.0, false, false, remainingUnits);
    }
    public Unit epWolfPackleader(int remainingUnits){
        return new Unit("Wolf Packleader", 60, 80, 120, 0.95, 2.3, 2.1, true, false, remainingUnits);
    }
    public Unit epFox(int remainingUnits){
        return new Unit("Fox", 30, 10, 40, 0.95, 1.0, 2.3, false, true, remainingUnits);
    }
    public Unit epGiant(int remainingUnits){
        return new Unit("Giant", 160, 60, 90, 0.95, 3.0, 2.4, true, false, remainingUnits);
    }
    public Unit furiousBoar(int remainingUnits){
        Unit u = new Unit("Furious Boar", 50000, 200, 300, 0.9, 2.9, 3, true, false, remainingUnits);
        u.setBoss(true);
        return u;
    }
    public Unit giantBogor(int remainingUnits){
        Unit u = new Unit("Giant Bogor", 90000, 100, 300, 0.6, 3.9, 3, true, false, remainingUnits);
        u.setBoss(true);
        return u;
    }
    public Unit giantGogor(int remainingUnits){
        Unit u = new Unit("GiantGogor", 70000, 100, 250, 0.8, 3.95, 3.1, true, false, remainingUnits);
        u.setBoss(true);
        return u;
    }
    public Unit unicorn(int remainingUnits){
        Unit u = new Unit("Unicorn", 30000, 250, 400, 0.9, 2.95, 2.95, true, false, remainingUnits);
        u.setBoss(true);
        return u;
    }
    public Unit lyingGoat(int remainingUnits){
        Unit u = new Unit("Lying Goat", 25000, 100, 150, 0.85, 2.95, 2.95, true, true, remainingUnits);
        u.setBoss(true);
        return u;
    }
    public Unit piedPiperOfHarmelin(int remainingUnits){
        Unit u = new Unit("Pied Piper of Harmelin", 55000, 200, 450, 0.9, 1.95, 2.95, true, true, remainingUnits);
        u.setBoss(true);
        return u;
    }
    public Unit kingOfRats(int remainingUnits){
        Unit u = new Unit("King of Rats", 40000, 200, 800, 0.6, 3.95, 2.96, true, false, remainingUnits);
        u.setBoss(true);
        return u;
    }
    //endregion

    //region Deserter
    public Unit elitesoldierDeserter(int remainingUnits){
        return  new Unit("EliteSoldier Deserter", 120, 20, 40, 0.7, 2.03, 1.3, false, false, remainingUnits);
    }

    public Unit crossbowmanDeserter(int remainingUnits){
        return  new Unit("Crossbowman Deserter", 10, 45, 90, 0.6, 2.04, 2.25, false, false, remainingUnits);
    }
    //endregion

    //region Royal
    //confirmed attack initiative:  recruit<militia<Ilsebille
    //confirmed defend initiative: recruit<militia<bowman
    //                                     militia      <longbowman<cavalry<Cannoneers<Ilsebille
    //                           Elite Soldier Deserter <longbowman<cavalry<Cannoneers
    //

    //

    public Unit evilQueenIlsebille(int remainingUnits){
        Unit u = new Unit("Ilsebille, the Evil Queen", 95000, 400, 600, 0.8, 2.9, 3, true, false, remainingUnits);
        u.setBoss(true);
        return u;
    }
    public Unit greedyInnKeeper(int remainingUnits){
        Unit u = new Unit("Greedy Inn-Keeper", 50000, 1500, 2000, 0.8, 2.9, 3, true, true, remainingUnits);
        u.setBoss(true);
        return u;
    }
    public Unit theMayor(int remainingUnits){
        Unit u = new Unit("The Mayor", 95000, 400, 600, 0.8, 3.9, 3, true, false, remainingUnits);
        u.setBoss(true);
        return u;
    }

    public Unit evilKing(int remainingUnits){
        Unit u = new Unit("Evil King", 30000, 200, 300, 0.8, 2.9, 3, true, false, remainingUnits);
        u.setBoss(true);
        return u;
    }
    public Unit royalRecruit(int remainingUnits){
        return  new Unit("Royal Recruit", 120, 30, 60, 0.85, 2.1, 1.0, false, false, remainingUnits);
    }
    public Unit royalMilitia(int remainingUnits){
        return  new Unit("Royal Militia", 160, 70, 90, 0.95, 2.15, 1.1, true, false, remainingUnits);
    }
    public Unit royalBowman(int remainingUnits){
        return  new Unit("Royal Bowman", 40, 60, 120, 0.85, 2.4, 2.1, false, false, remainingUnits);
    }
    public Unit royalLongbowman(int remainingUnits){
        return  new Unit("Royal Longbowman", 60, 80, 140, 0.95, 2.5, 2.2, true, false, remainingUnits);
    }
    public Unit royalCavalry(int remainingUnits){
        return  new Unit("Royal Cavalry", 40, 10, 60, 0.95, 1.0, 2.3, false, true, remainingUnits);
    }
    public Unit royalCannoneer(int remainingUnits){
        return  new Unit("Royal Cannoneer", 200, 60, 90, 0.95, 3.0, 2.6, true, false, remainingUnits);
    }

/*    public Unit excRoyalHuntLead(int remainingUnits){
        return new Unit(""  ,45000, [200, 700], 80, Initiative.THIRD, getAID(), [Skills.SPLASH_DAMAGE], "todo")
    }
    cu.excEvilQueen      = new Unit("",       95000, [400, 600], 80, Initiative.SECOND, getAID(), [Skills.SPLASH_DAMAGE], "todo");
    cu.excRoyalCaptain   = new Unit("",       45000, [300, 500], 80, Initiative.SECOND, getAID(), [Skills.SPLASH_DAMAGE], "todo");
    cu.excRoyalJuggernaut= new Unit("",       70000, [200,1000], 35, Initiative.THIRD, getAID(), [Skills.SPLASH_DAMAGE], "todo");
    cu.excKingOfRats     = new Unit("",       40000, [200, 800], 60, Initiative.THIRD, getAID(), [Skills.SPLASH_DAMAGE], "todo");
    cu.excPiper          = new Unit("",       55000, [200, 450], 90, Initiative.THIRD, getAID(), [Skills.SPLASH_DAMAGE], "todo");
    cu.excMayor          = new Unit("",       95000, [400, 600], 80, Initiative.SECOND, getAID(), [Skills.SPLASH_DAMAGE], "todo");
    cu.excEvilStepMother = new Unit("",       95000, [400, 600], 80, Initiative.SECOND, getAID(), [Skills.SPLASH_DAMAGE], "todo");
    cu.excPreacherFlame  = new Unit("",       11000, [500, 700], 75, Initiative.THIRD, getAID(), [Skills.SPLASH_DAMAGE, Skills.ATTACK_WEAKEST], "todo");
    cu.excAncientDragon  = new Unit("",       50000, [500, 750], 50, Initiative.FIRST, getAID(), [Skills.SPLASH_DAMAGE], "todo");
    */
    //endregion



    //Ali baba



}
