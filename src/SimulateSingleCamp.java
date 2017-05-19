import Adventures.*;
import units.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Jens on 14.05.2017.
 */
public class SimulateSingleCamp {

    public static void main(String[] args){
        ArrayList<ArrayList<Unit>> initialPlayerUnits = new ArrayList<>();
        ArrayList<Unit> initialPlayerUnitsNusala1R = new ArrayList<>();
        ArrayList<Unit> initialPlayerUnitsMMA1R = new ArrayList<>();
        ArrayList<Unit> initialPlayerUnits2MMA1R = new ArrayList<>();
        ArrayList<Unit> initialPlayerUnits3MMA1R = new ArrayList<>();
        ArrayList<Unit> initialPlayerUnitsMMA220R = new ArrayList<>();
        ArrayList<Unit> initialPlayerUnits200R = new ArrayList<>();
        ArrayList<Unit> initialPlayerUnitsCustomSacrifice = new ArrayList<>();
        ArrayList<Unit> initialPlayerUnitsNusala165R = new ArrayList<>();
        ArrayList<Unit> initialPlayerUnitsNusala165Bow = new ArrayList<>();
        ArrayList<Unit> initialPlayerUnitsFinalWave = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        ArrayList<Unit> initialMonsterUnits = new ArrayList<>();
        ArrayList<Unit> nextWaveMonsterUnits = new ArrayList<>();


        //setup player waves(common waves)

        UnitFactory factory = new UnitFactory();

        initialPlayerUnitsNusala1R.add(factory.createCustomNusala());
        initialPlayerUnitsNusala1R.add(factory.createPlayerR(1));

        initialPlayerUnitsNusala165R.add(factory.createCustomNusala());
        initialPlayerUnitsNusala165R.add(factory.createPlayerR(165));

        initialPlayerUnitsNusala165Bow.add(factory.createCustomNusala());
        initialPlayerUnitsNusala165Bow.add(factory.createPlayerBow(165));

        initialPlayerUnitsMMA1R.add(factory.createMMA());
        initialPlayerUnitsMMA1R.add(factory.createPlayerR(1));

        initialPlayerUnits2MMA1R.add(factory.createMMA());
        initialPlayerUnits2MMA1R.add(factory.createPlayerR(1));

        initialPlayerUnits3MMA1R.add(factory.createMMA());
        initialPlayerUnits3MMA1R.add(factory.createPlayerR(1));

        initialPlayerUnits200R.add(factory.create270());
        initialPlayerUnits200R.add(factory.createPlayerR(200));

        initialPlayerUnitsMMA220R.add(factory.createMMA());
        initialPlayerUnitsMMA220R.add(factory.createPlayerR(220));

        initialPlayerUnitsCustomSacrifice.add(factory.createMMA());
        initialPlayerUnitsCustomSacrifice.add(factory.createPlayerR(100));



        initialPlayerUnitsFinalWave.add(factory.createCustomAnslem());
        //initialPlayerUnitsFinalWave.add(factory.create270());

        initialPlayerUnitsFinalWave.add(factory.createPlayerR(65));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerM(270));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerS(270));
        initialPlayerUnitsFinalWave.add(factory.createPlayerES(1));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerC(270));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerBow(70));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerLB(270));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerXB(270));
        initialPlayerUnitsFinalWave.add(factory.createPlayerCN(99));

        //initialPlayerUnitsFinalWave.add(factory.createPlayerSM(270));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerMS(10));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerK(18));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerMA(5));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerMM(250));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerAM(260));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerB(43));


        //initialPlayerUnits.add(initialPlayerUnitsNusala1R);
        initialPlayerUnits.add(initialPlayerUnitsNusala165Bow);
        //initialPlayerUnits.add(initialPlayerUnits200R);
        //initialPlayerUnits.add(initialPlayerUnitsCustomSacrifice);
        //initialPlayerUnits.add(initialPlayerUnitsMMA1R);
        //initialPlayerUnits.add(initialPlayerUnits2MMA1R);
        //initialPlayerUnits.add(initialPlayerUnits3MMA1R);
        //initialPlayerUnits.add(initialPlayerUnitsMMA220R);
        initialPlayerUnits.add(initialPlayerUnitsFinalWave);

        /* setup monster units
        example1:
        initialMonsterUnits.add(factory.bScavenger(200));
        example 2:
        Adventure addy = new HanselAndGretel();
        initialMonsterUnits = addy.createCamp(1);
        */
        Adventure addy = new ValiantLittleTailor();
        initialMonsterUnits = addy.createCamp(11);


        for (Unit u:initialMonsterUnits) {
            nextWaveMonsterUnits.add(u.copy());
        }
        int simulationSize = 1000;
        for(int i=0;i<initialPlayerUnits.size();i++){
            ArrayList<Unit> thisWaveMonsterUnits = new ArrayList<Unit>();
            for (Unit u:nextWaveMonsterUnits) {
                thisWaveMonsterUnits.add(u.copy());
            }
            nextWaveMonsterUnits.clear();
            Simulation sim = new Simulation(thisWaveMonsterUnits, initialPlayerUnits.get(i));

            ArrayList<ArrayList<Unit>> combinedLoss=sim.simulation(simulationSize);
            builder.append("Wave " + i +": ");
            builder.append(resultAsString(combinedLoss, thisWaveMonsterUnits, simulationSize));
            ArrayList<Unit> averageCombinedLoss=combinedLoss.get(0);
            ArrayList<Unit> minLoss=combinedLoss.get(1);
            ArrayList<Unit> maxLoss=combinedLoss.get(2);

            for (Unit u:minLoss) {
                for (Unit u2:thisWaveMonsterUnits) {
                    if(u2.getName().equals(u.getName())){
                        if(!(u2.getRemainingUnits()==u.getRemainingUnits())){
                            Unit newUnit=u2.copy();
                            newUnit.setRemainingUnits(u2.getRemainingUnits()-u.getRemainingUnits());
                            nextWaveMonsterUnits.add(newUnit.copy());
                        }
                    }
                }
            }
            if(nextWaveMonsterUnits.isEmpty()){
                break;
            }
        }


        System.out.println(builder.toString());








    }

    public static void findBestRegularFinalWave(ArrayList<ArrayList<Unit>> initialPlayerUnits, ArrayList<Unit> initialMonsterUnits){
        UnitFactory factory= new UnitFactory();
        ArrayList<Unit> initialPlayerUnitsFinalWave =initialPlayerUnits.get(initialPlayerUnits.size()-1);
        StringBuilder builder = new StringBuilder();


        ArrayList<Unit> nextWaveMonsterUnits = new ArrayList<>();


        for (Unit u:initialMonsterUnits) {
            nextWaveMonsterUnits.add(u.copy());
        }
        int simulationSize = 500;
        //simulate worst cases for sacrifice waves
        for(int i=0;i<initialPlayerUnits.size()-1;i++){
            ArrayList<Unit> thisWaveMonsterUnits = new ArrayList<Unit>();
            for (Unit u:nextWaveMonsterUnits) {
                thisWaveMonsterUnits.add(u.copy());
            }
            nextWaveMonsterUnits.clear();
            Simulation sim = new Simulation(thisWaveMonsterUnits, initialPlayerUnits.get(i));

            ArrayList<ArrayList<Unit>> combinedLoss=sim.simulation(simulationSize);
            builder.append("Wave " + i +": ");
            builder.append(resultAsString(combinedLoss, thisWaveMonsterUnits, simulationSize));

            ArrayList<Unit> minLoss=combinedLoss.get(1);


            for (Unit u:minLoss) {
                for (Unit u2:thisWaveMonsterUnits) {
                    if(u2.getName().equals(u.getName())){
                        if(!(u2.getRemainingUnits()==u.getRemainingUnits())){
                            Unit newUnit=u2.copy();
                            newUnit.setRemainingUnits(u2.getRemainingUnits()-u.getRemainingUnits());
                            nextWaveMonsterUnits.add(newUnit.copy());
                        }
                    }
                }
            }
            if(nextWaveMonsterUnits.isEmpty()){
                //sacrifice waves killed the camp
                break;
            }
        }

        //find best final wave using available units
        ArrayList<Unit> thisWaveMonsterUnits = new ArrayList<>();
        ArrayList<Unit> availableUnits = new ArrayList<Unit>();
        ArrayList<Unit> nextAttempt = new ArrayList<Unit>();
        ArrayList<Unit> bestAttempt = new ArrayList<Unit>();
        ArrayList<ArrayList<Unit>> bestAttemptLosses = new ArrayList<ArrayList<Unit>>();
        int bestAttemptValue = Integer.MAX_VALUE;


        General g = (General)factory.create270();
        for (Unit u: initialPlayerUnitsFinalWave) {
            if (u.isGeneral()){
                g = (General) u.copy();
                g.setMaxUnits(g.getMaxUnits()+5*g.getGarrisonAnnex());
            }
            else{
                availableUnits.add(u.copy());
            }
        }

        int maxLossValue = Integer.MAX_VALUE;

        //calculate next attempt units

        final int INCREMENTS = 30;
        for(int i=0;i<g.getMaxUnits()/INCREMENTS;i++){
            Unit re =factory.createPlayerR(i*INCREMENTS);
            //for (int j=0;j<(g.getMaxUnits()/INCREMENTS)-i;j++){
            //    Unit mi = factory.createPlayerM(j*INCREMENTS);
                //for (int k=0;k<(g.getMaxUnits()/INCREMENTS)-i-j;k++){
                //    Unit so = factory.createPlayerS(k*INCREMENTS);
                    //for (int l=0;l<(g.getMaxUnits()/INCREMENTS)-i/*-j-k*/;l++){
                        //Unit es = factory.createPlayerES(l*INCREMENTS);
            Unit es = factory.createPlayerES(1);
                        for (int m=0;m<g.getMaxUnits()/INCREMENTS-i/*-j-k-l*/;m++){
                            Unit bo = factory.createPlayerBow(m*INCREMENTS);
                            //for (int n=0;n<(g.getMaxUnits()/INCREMENTS)-i-j-k-l-m;n++){
                                //    Unit lb = factory.createPlayerM(n*INCREMENTS);
                                for (int o=0;o<g.getMaxUnits()/INCREMENTS-i/*-j-k-l*/-m/*-n*/;o++){
                                    Unit xb = factory.createPlayerXB(o*INCREMENTS);
                                    for (int p=0;p<g.getMaxUnits()/INCREMENTS-i/*-j-k-l*/-m-/*n-*/o;p++){
                                        Unit ca = factory.createPlayerC(p*INCREMENTS);
                                        //rest is cannons
                                        Unit cn = factory.createPlayerCN(g.getMaxUnits()-INCREMENTS*(i+/*j+k+l+*/m/*+n*/+o+p));
                                        nextAttempt.clear();

                                        if(re.getRemainingUnits()!=0){
                                            nextAttempt.add(re.copy());
                                        }
                                        //add units to nextAttempt army
                                        //if(mi.getRemainingUnits()!=0) {
                                        //    nextAttempt.add(mi.copy());
                                        //}
                                        //if(so.getRemainingUnits()!=0) {
                                        //    nextAttempt.add(so.copy());
                                        //}
                                        if(es.getRemainingUnits()!=0) {
                                            nextAttempt.add(es.copy());
                                        }
                                        if(bo.getRemainingUnits()!=0) {
                                            nextAttempt.add(bo.copy());
                                        }
                                        //if(lb.getRemainingUnits()!=0) {
                                        //    nextAttempt.add(lb.copy());
                                        //}
                                        if(xb.getRemainingUnits()!=0) {
                                            nextAttempt.add(xb.copy());
                                        }
                                        if(ca.getRemainingUnits()!=0) {
                                            nextAttempt.add(ca.copy());
                                        }
                                        if(cn.getRemainingUnits()!=0) {
                                            nextAttempt.add(cn.copy());
                                        }

                                        //ready remaining monster units
                                        thisWaveMonsterUnits.clear();
                                        for (Unit u:nextWaveMonsterUnits ) {
                                            thisWaveMonsterUnits.add(u.copy());
                                        }




                                        if(re.getRemainingUnits()==160&&cn.getRemainingUnits()==5){
                                            System.out.println("stop here");
                                        }
                                        nextAttempt.add(g.copy());
                                        //simulate next attempt
                                        Simulation sim = new Simulation(thisWaveMonsterUnits, nextAttempt);
                                        int lossValue = 0;
                                        ArrayList<ArrayList<Unit>> combinedLoss=sim.simulation(simulationSize);
                                        for (Unit u:combinedLoss.get(0)) {
                                            if(u.getValue()==Double.MAX_VALUE){
                                                continue;
                                            }
                                            lossValue+=u.getRemainingUnits()*u.getValue();
                                        }
                                        if(lossValue<bestAttemptValue){
                                            bestAttemptValue = lossValue;
                                            bestAttempt = nextAttempt;
                                            bestAttemptLosses = combinedLoss;
                                        }

                                    }
                                }
                            //}
                        }
                    //}
                //}
            //}
        }
        builder. append("attacking Units");
        builder.append(System.getProperty("line.separator"));
        for (Unit u:bestAttempt) {
            builder.append(u.getName() + ": " +u.getRemainingUnits() );
            builder.append(System.getProperty("line.separator"));
        }
        builder.append(resultAsString(bestAttemptLosses,thisWaveMonsterUnits,50));
        System.out.println(builder.toString());








    }


    /**
     * Does not alter any of the input data
     * @param combinedLoss
     * @param thisWaveMonsterUnits
     * @param simulationSize
     * @return
     */
    public static String resultAsString(ArrayList<ArrayList<Unit>> combinedLoss, ArrayList<Unit> thisWaveMonsterUnits, int simulationSize){
        ArrayList<Unit> averageCombinedLoss=combinedLoss.get(0);
        ArrayList<Unit> minLoss=combinedLoss.get(1);
        ArrayList<Unit> maxLoss=combinedLoss.get(2);

        StringBuilder builder =new StringBuilder();
        builder.append(System.getProperty("line.separator"));
        builder.append("Minimum losses:");
        builder.append(System.getProperty("line.separator"));
        for (Unit u:minLoss) {
            builder.append(u.getName() + " lost: " + (double)u.getRemainingUnits());
            builder.append(System.getProperty("line.separator"));
        }
        builder.append("Average losses:");
        builder.append(System.getProperty("line.separator"));
        for (Unit u:averageCombinedLoss) {
            builder.append(u.getName() + " lost: " + (double)u.getRemainingUnits()/(double) simulationSize);
            builder.append(System.getProperty("line.separator"));
        }

        builder.append("Maximum losses:"+System.getProperty("line.separator"));

        for (Unit u:maxLoss) {
            builder.append(u.getName() + " lost: " + (double)u.getRemainingUnits());
            builder.append(System.getProperty("line.separator"));
        }
        for (Unit u:minLoss) {
            for (Unit u2:thisWaveMonsterUnits) {
                if(u2.getName().equals(u.getName())&&u2.getRemainingUnits()==u.getRemainingUnits()){
                    builder.append("All "+ u2.getName()+ " are dead");
                    builder.append(System.getProperty("line.separator"));
                }
            }
        }
        return builder.toString();

    }
}
