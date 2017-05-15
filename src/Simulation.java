import units.*;

import java.util.ArrayList;

/**
 * Created by Jens on 12.05.2017.
 */
public class Simulation {

    private ArrayList<Unit> initialMonsterUnits = new ArrayList<>();
    private ArrayList<Unit> initialPlayerUnits = new ArrayList<>();
    ArrayList<Unit> combinedLoss = new ArrayList<>();


    private void setupSim(ArrayList<Unit> initialMonsterUnits, ArrayList<Unit> initialPlayerUnits){
        combinedLoss = new ArrayList<>();
        this.initialMonsterUnits = initialMonsterUnits;
        this.initialPlayerUnits = initialPlayerUnits;
        //solve all unit altering general skills
        for (Unit u :initialPlayerUnits) {
            if(u.getName().equals("Nusala")){
                for (Unit u2: initialPlayerUnits) {
                    if(u2.getName().equals("PlayerBow")||u2.getName().equals("PlayerLB")||u2.getName().equals("PlayerXB")||u2.getName().equals("PlayerMa")||u2.getName().equals("PlayerAM")){
                        u2.setFlanking(true);
                        u2.setSplash(true);
                    }
                }
            }
            if(u.getName().equals("Anslem")){
                for (Unit u2: initialMonsterUnits) {
                    u2.setAccuracy(0);
                }
            }
            if(u.getName().equals("Vargus")){
                for (Unit u2: initialMonsterUnits) {
                    u2.setFlanking(false);
                    double newDamage=(double)u2.getMinDamage()*0.95;
                    u2.setMinDamage((int)Math.floor(newDamage));
                    newDamage=(double)u2.getMaxDamage()*0.95;
                    u2.setMaxDamage((int)Math.floor(newDamage));
                }
            }
            if(u.isGeneral()){
                General g = (General)u;
                g.setMaxUnits(g.getMaxUnits()+15*g.getGarrisonAnnex());
                if(g.getOverrun()>0){
                    for (Unit m:initialMonsterUnits) {
                        if(m.isBoss()){
                            if(g.getOverrun()==1){
                                m.setMaxHp((int)Math.floor((double)m.getMaxHp()*0.92));
                            }
                            if(g.getOverrun()==2){
                                m.setMaxHp((int)Math.floor((double)m.getMaxHp()*0.84));
                            }
                            if(g.getOverrun()==3){
                                m.setMaxHp((int)Math.floor((double)m.getMaxHp()*0.75));
                            }
                        }
                    }
                }

                for (Unit u2:initialPlayerUnits) {
                    if(g.getMasterPlanner()==1){
                        u2.setAccuracy(u2.getAccuracy()+0.1);
                    }
                    if(u2.getName().equals("PlayerES")){
                        u2.setMinDamage(u2.getMinDamage()+2*g.getCleave());
                        u2.setMaxDamage(u2.getMaxDamage()+4*g.getCleave());
                        if(g.getCleave()==3){
                            u2.setSplash(true);
                        }
                    }
                    if(u2.getName().equals("PlayerCN")||u2.getName().equals("PlayerBe")){
                        u2.setMinDamage(u2.getMinDamage()+5*g.getWeeklyMaintenance());
                        u2.setMaxDamage(u2.getMaxDamage()+10*g.getWeeklyMaintenance());
                    }
                    if(u2.getAttackInitiative()<2.0){
                        u2.setMaxDamage(u2.getMaxDamage()+g.getUnstoppableCharge());
                        if(g.getUnstoppableCharge()==3){
                            u2.setSplash(true);
                        }
                    }
                    if(u2.getName().equals("PlayerLB")||u2.getName().equals("PlayerMa")){
                        if(g.getSniperTraining()==1){
                            u2.setMinDamage((int)Math.floor((double)u2.getMinDamage()*1.45));
                            u2.setMaxDamage((int)Math.floor((double)u2.getMaxDamage()*1.05));
                        }
                        if(g.getSniperTraining()==2){
                            u2.setMaxDamage((int)Math.floor((double)u2.getMaxDamage()*1.1));
                            u2.setMinDamage((int)Math.floor((double)u2.getMinDamage()*1.85));
                        }
                        if(g.getSniperTraining()==3){
                            u2.setMaxDamage((int)Math.floor((double)u2.getMaxDamage()*1.15));
                            u2.setMinDamage((int)Math.floor((double)u2.getMinDamage()*2.30));
                        }
                    }
                    if(u2.getName().equals("PlayerBow")){

                        u2.setMaxDamage(u2.getMaxDamage()+g.getRapidFire()*5);

                    }




                }

            }

        }
    }
    public Simulation(ArrayList<Unit> initialMonsterUnits,ArrayList<Unit> initialPlayerUnits){
        setupSim(initialMonsterUnits,initialPlayerUnits);
    }

    public ArrayList<ArrayList<Unit>> simulation(int simulationSize){


        ArrayList<Unit> maxLoss = new ArrayList<>();
        ArrayList<Unit> minLoss = new ArrayList<>();
        for (int i = 0; i< simulationSize; i++){
            ArrayList<Unit> monsterUnits = new ArrayList<>();
            ArrayList<Unit> playerUnits = new ArrayList<>();
            for (Unit u:initialMonsterUnits) {
                monsterUnits.add(u.copy());
            }
            for (Unit u:initialPlayerUnits) {
                playerUnits.add(u.copy());
            }

            Camp simCamp=new Camp(playerUnits,monsterUnits);
            ArrayList<Unit> loss = simCamp.startFight();
            for (Unit u:loss) {
                boolean foundUnit=false;
                for (Unit u2:combinedLoss ) {
                    if(u2.getName().equals(u.getName())){
                        foundUnit=true;
                        u2.setRemainingUnits(u2.getRemainingUnits()+u.getRemainingUnits());
                    }
                }
                for (Unit u2:maxLoss ) {
                    if(u2.getName().equals(u.getName())){
                        if(u2.getRemainingUnits()<u.getRemainingUnits()){
                            u2.setRemainingUnits(u.getRemainingUnits());
                        }
                    }
                }
                for (Unit u2:minLoss ) {
                    if(u2.getName().equals(u.getName())){
                        if(u2.getRemainingUnits()>u.getRemainingUnits()){
                            u2.setRemainingUnits(u.getRemainingUnits());
                        }
                    }
                }
                if(!foundUnit){
                    combinedLoss.add(u.copy());
                    minLoss.add(u.copy());
                    maxLoss.add(u.copy());
                }
            }
        }
        ArrayList<ArrayList<Unit>> result = new ArrayList<>();
        result.add(combinedLoss);
        result.add(minLoss);
        result.add(maxLoss);


        return result;

    }
}
