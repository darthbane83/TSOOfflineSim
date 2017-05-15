package units;

/**
 * Created by Jens on 15.05.2017.
 */
public class UnitFactory {
    public UnitFactory(){

    }





    //General
    public Unit createNusala(){
        General g = new General("Nusala",150,1000,1500,0.90,1.1,3,true,true);
        g.setMaxUnits(165);
        return g;

    }
    public Unit create270(){
        General g = new General("270",1,120,120,1,2.7,2.5,false,false);
        g.setMaxUnits(270);
        return g;
    }

    //region Elite units
    public Unit createPlayerSM(int remainingUnits){
        return new Unit("PlayerSM",150,40,80,0.9,2,2.0,false,false,remainingUnits);
    }

    public Unit createPlayerMS(int remainingUnits){
        return new Unit("PlayerMS",250,25,50,0.9,2,2.0,false,false,remainingUnits);
    }

    public Unit createPlayerK(int remainingUnits){
        return new Unit("PlayerK",80,35,70,0.9,1,2.0,false,false,remainingUnits);
    }

    public Unit createPlayerMA(int remainingUnits){
        return new Unit("PlayerMA",50,50,100,0.9,2,2.0,false,false,remainingUnits);
    }

    public Unit createPlayerAM(int remainingUnits){
        return new Unit("PlayerAM",50,100,200,0.9,2,2.0,false,true,remainingUnits);
    }

    public Unit createPlayerMM(int remainingUnits){
        return new Unit("PlayerSM",50,50,100,0.9,1,2.0,true,false,remainingUnits);
    }

    public Unit createPlayerB(int remainingUnits){
        return new Unit("PlayerB",80,100,200,0.9,3,2.0,true,false,remainingUnits);
    }
    //endregion

    //region Standard units
    public Unit createPlayerR(int remainingUnits){
        return new Unit("PlayerR",40,15,30,0.8,2,1,false,false,remainingUnits);
    }

    public Unit createPlayerM(int remainingUnits){
        return new Unit("PlayerM",60,20,40,0.8,2,1.1,false,false,remainingUnits);
    }

    public Unit createPlayerS(int remainingUnits){
        return new Unit("PlayerS",90,20,40,0.85,2,1.2,false,false,remainingUnits);
    }

    public Unit createPlayerES(int remainingUnits){
        return new Unit("PlayerES",120,20,40,0.9,2,1.3,false,false,remainingUnits);
    }

    public Unit createPlayerC(int remainingUnits){
        return new Unit("PlayerC",5,5,10,0.8,1,2,false,true,remainingUnits);
    }

    public Unit createPlayerBow(int remainingUnits){
        return new Unit("PlayerBow",10,20,40,0.8,2,2.1,false,false,remainingUnits);
    }

    public Unit createPlayerLB(int remainingUnits){
        return new Unit("PlayerLB",10,30,60,0.8,2,2.2,false,false,remainingUnits);
    }

    public Unit createPlayerXB(int remainingUnits){
        return new Unit("PlayerXB",10,45,90,0.8,2,2.3,false,false,remainingUnits);
    }

    public Unit createPlayerCN(int remainingUnits){
        return new Unit("PlayerCN",60,60,120,0.9,3,2.4,false,false,remainingUnits);
    }
    //endregion

    //region Bandits
    public Unit bWildMary(int remainingUnits){
        return new Unit("Wild Mary",60000, 740, 800, 0.5, 1,  0, true, false,remainingUnits);
    }
    public Unit bChuck(int remainingUnits){
        return new Unit("Chuck",9000, 2000, 2500, 0.5, 3,  0, true, false,remainingUnits);
    }
    public Unit bMetalToothed(int remainingUnits) {
        return new Unit("Metal Toothed",11000,250,500,0.5, 3, 0,true,false,remainingUnits);
    }
    public Unit bScavenger(int remainingUnits){
        return new Unit("Scavenger",40, 15,30, 0.6, 2, 0,false, false, remainingUnits);
    }
    public Unit bThug(int remainingUnits) {
        return new Unit("Thug", 60, 20, 40, 0.6, 2, 0, false, false, remainingUnits);
    }
    public Unit bGuardDog(int remainingUnits) {
        return new Unit("Guard Dog", 5, 5, 10, 0.6, 1, 0, false, true, remainingUnits);
    }
    public Unit bRoughneck(int remainingUnits) {
        return new Unit("Roughneck", 90, 20, 40, 0.6, 2, 0, false, false, remainingUnits);
    }
    public Unit bStoneThrower(int remainingUnits) {
        return new Unit("Stone Thrower", 10, 20, 40, 0.6, 2, 0, false, false, remainingUnits);
    }
    public Unit bRanger(int remainingUnits) {
        return new Unit("Ranger", 10, 30, 0, 0.6, 2, 0, false, false, remainingUnits);
    }
    public Unit bSkunk(int remainingUnits) {
        return new Unit("Skunk", 000, 1, 100, 0.5, 3, 0, true, false, remainingUnits);
    }
    public Unit bOneEyedBert(int remainingUnits) {
        return new Unit("One-Eyed Bert", 6000, 300, 500, 0.5, 3, 0, true, false, remainingUnits);
    }
    //endregion
    //cultists

    //animals

    //region Royal
    public Unit excRoyalHuntLead(int remainingUnits){
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
    //endregion

    //Deserter

    //Ali baba



}
