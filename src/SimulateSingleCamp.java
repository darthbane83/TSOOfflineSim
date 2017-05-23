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
        initialPlayerUnitsCustomSacrifice.add(factory.createPlayerMS(20));
        initialPlayerUnitsCustomSacrifice.add(factory.createPlayerK(170));


        //initialPlayerUnitsFinalWave.add(factory.createCustomNusala());
        initialPlayerUnitsFinalWave.add(factory.createCustomAnslem());
        //initialPlayerUnitsFinalWave.add(factory.create270());

        //initialPlayerUnitsFinalWave.add(factory.createPlayerR(120));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerM(270));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerS(270));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerES(1));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerC(270));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerBow(70));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerLB(270));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerXB(270));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerCN(44));

        //initialPlayerUnitsFinalWave.add(factory.createPlayerSM(270));
        initialPlayerUnitsFinalWave.add(factory.createPlayerMS(26));
        initialPlayerUnitsFinalWave.add(factory.createPlayerK(50));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerMA(6));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerMM(270));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerAM(260));
        initialPlayerUnitsFinalWave.add(factory.createPlayerB(89));

        //initialPlayerUnits.add(initialPlayerUnitsNusala1R);
        //initialPlayerUnits.add(initialPlayerUnits200R);
        //initialPlayerUnits.add(initialPlayerUnitsCustomSacrifice);
        //initialPlayerUnits.add(initialPlayerUnitsMMA1R);
        //initialPlayerUnits.add(initialPlayerUnits2MMA1R);
        //initialPlayerUnits.add(initialPlayerUnits3MMA1R);
        //initialPlayerUnits.add(initialPlayerUnitsNusala165Bow);
        //initialPlayerUnits.add(initialPlayerUnitsMMA220R);
        //initialPlayerUnits.add(initialPlayerUnitsCustomSacrifice);
        initialPlayerUnits.add(initialPlayerUnitsFinalWave);

        /* setup monster units
        example1:
        initialMonsterUnits.add(factory.bScavenger(200));
        example 2:
        Adventure addy = new HanselAndGretel();
        initialMonsterUnits = addy.createCamp(1);
        */
        Adventure addy = new AliBabaTheYoungWoodcutter();
        initialMonsterUnits = addy.createCamp(3);


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
        int simulationSize = 100;
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
        ArrayList<Unit> nextAttempt = new ArrayList<Unit>();
        ArrayList<Unit> bestAttempt = new ArrayList<Unit>();
        ArrayList<ArrayList<Unit>> bestAttemptLosses = new ArrayList<ArrayList<Unit>>();
        int bestAttemptValue = Integer.MAX_VALUE;


        General g = (General)factory.create270();


        int maxLossValue = Integer.MAX_VALUE;

        //calculate next attempt units


        //CUSTOMIZE which generals should be available
        for (int h=0; h<4;h++){
            if (h== 0){
                g = (General)factory.createCustomMMA();
            }
            if(h==1){
                g = (General)factory.createCustom270();
            }
            if(h == 2){
                g = (General)factory.createCustomNusala();
            }
            if(h == 3){
                g = (General)factory.createCustomAnslem();
            }
            if(h == 4){
                g = (General)factory.createCustomVargus();
            }
            int INCREMENTS = g.getMaxUnits()/6;
            for(int i=0;i<g.getMaxUnits()/INCREMENTS;i++){
                Unit re =factory.createPlayerR(i*INCREMENTS);
                for (int j=0;j<(g.getMaxUnits()/INCREMENTS)-i;j++){
                    Unit mi = factory.createPlayerM(j*INCREMENTS);
                    //for (int k=0;k<(g.getMaxUnits()/INCREMENTS)-i-j;k++){
                    //    Unit so = factory.createPlayerS(k*INCREMENTS);
                        for (int l=0;l<(g.getMaxUnits()/INCREMENTS)-i-j/*-k*/;l++){
                            Unit es = factory.createPlayerES(l*INCREMENTS);
                            //Unit es = factory.createPlayerES(1);
                            for (int m=0;m<g.getMaxUnits()/INCREMENTS-i-j/*-k*/-l;m++){
                                Unit bo = factory.createPlayerBow(m*INCREMENTS);
                                //for (int n=0;n<(g.getMaxUnits()/INCREMENTS)-i-j-k-l-m;n++){
                                    //Unit lb = factory.createPlayerLB(n*INCREMENTS);
                                    for (int o=0;o<g.getMaxUnits()/INCREMENTS-i-j/*-k*/-l-m/*-n*/;o++){
                                        Unit xb = factory.createPlayerXB(o*INCREMENTS);
                                        for (int p=0;p<g.getMaxUnits()/INCREMENTS-i-j/*-k*/-l-m/*-n*/-o;p++){
                                            Unit ca = factory.createPlayerC(p*INCREMENTS);
                                            //rest is cannons
                                            Unit cn = factory.createPlayerCN(g.getMaxUnits()-INCREMENTS*(i+j/*+k*/+l+m/*+n*/+o+p));
                                            nextAttempt.clear();

                                            if(re.getRemainingUnits()!=0){
                                                nextAttempt.add(re.copy());
                                            }
                                            //add units to nextAttempt army
                                            if(mi.getRemainingUnits()!=0) {
                                                nextAttempt.add(mi.copy());
                                            }
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
                                            for (Unit u:combinedLoss.get(2)) {
                                                if(u.getValue()==Double.MAX_VALUE){
                                                    continue;
                                                }
                                                lossValue+=u.getRemainingUnits()*u.getValue();
                                            }
                                            if(lossValue<bestAttemptValue){
                                                bestAttemptValue = lossValue;
                                                bestAttempt.clear();
                                                for (Unit u:nextAttempt
                                                     ) {
                                                    bestAttempt.add(u.copy());
                                                }

                                                bestAttemptLosses = combinedLoss;
                                            }

                                        }
                                    }
                                //}
                            }
                        }
                    //}
                }
            }
        }

        //finetune best attack
        ArrayList<Unit> newBestAttack = fineTuneAttack(thisWaveMonsterUnits,bestAttempt);
        Simulation sim = new Simulation(thisWaveMonsterUnits, newBestAttack);
        bestAttemptLosses.clear();
        int finalSimSize = 1000;
        bestAttemptLosses=sim.simulation(finalSimSize);


        builder. append("attacking Units");
        builder.append(System.getProperty("line.separator"));
        for (Unit u:newBestAttack) {
            builder.append(u.getName() + ": " +u.getRemainingUnits() );
            builder.append(System.getProperty("line.separator"));
        }
        builder.append(resultAsString(bestAttemptLosses,thisWaveMonsterUnits,finalSimSize));
        System.out.println(builder.toString());








    }

    public static ArrayList<Unit> fineTuneAttack(ArrayList<Unit> nextWaveMonsterUnits, ArrayList<Unit> bestAttempt){
        boolean foundImprovement = false;
        ArrayList<ArrayList<Unit>> newBestAttemptLosses;
        int simulationSize =500;
        ArrayList<Unit> thisAttempt = new ArrayList<>();
        ArrayList<Unit> nextAttempt = new ArrayList<>();
        for (Unit u:bestAttempt) {
            nextAttempt.add(u.copy());
        }

        ArrayList<Unit> thisWaveMonsterUnits = new ArrayList<>();

        for (Unit u:nextWaveMonsterUnits
             ) {
            thisWaveMonsterUnits.add(u.copy());
        }
        for (Unit u:nextAttempt
                ) {
            thisAttempt.add(u.copy());
        }


        Simulation sim = new Simulation(thisWaveMonsterUnits, nextAttempt);


        ArrayList<ArrayList<Unit>> loss = sim.simulation(500);
        int lossValue = 0;

        for (Unit u:loss.get(2)) {
            if(u.getValue()==Double.MAX_VALUE){
                continue;
            }
            lossValue+=u.getRemainingUnits()*u.getValue();
        }
        int bestAttemptValue = lossValue;



        ArrayList<Unit> maxLoss=loss.get(2);

        //if a basic type unit doesnt die change it to one of the advanced types

        for (Unit u:maxLoss) {
            if(u.isGeneral()){
                continue;
            }
            if(!u.getName().equals("PlayerCN")&&!u.getName().equals("PlayerXB")&&!u.getName().equals("PlayerES")&&!u.getName().equals("PlayerC")){
                for (Unit u2: thisAttempt ) {
                    if(u2.getName().equals(u.getName())&& (u.getRemainingUnits()<u2.getRemainingUnits())){
                        int difference = u2.getRemainingUnits()-u.getRemainingUnits();

                        //try adding it to each of the relevant unit types
                        nextAttempt.clear();
                        for (Unit u3:thisAttempt) {
                            nextAttempt.add(u3.copy());
                            if(u3.getName().equals(u.getName())){
                                nextAttempt.get(nextAttempt.size()-1).setRemainingUnits(u3.getRemainingUnits()-difference);
                            }
                        }
                        for (Unit u3:nextAttempt) {
                            if(u3.getName().equals("PlayerCN")||u3.getName().equals("PlayerC")||u3.getName().equals("PlayerES")||u3.getName().equals("PlayerXB")){
                                u3.setRemainingUnits(u3.getRemainingUnits()+difference);
                                //test new best attempt?
                                sim = new Simulation(thisWaveMonsterUnits, nextAttempt);
                                lossValue = 0;
                                ArrayList<ArrayList<Unit>> combinedLoss=sim.simulation(simulationSize);
                                for (Unit u4:combinedLoss.get(2)) {
                                    if(u4.getValue()==Double.MAX_VALUE){
                                        continue;
                                    }
                                    lossValue+=u4.getRemainingUnits()*u4.getValue();
                                }
                                if(lossValue<=bestAttemptValue){
                                    foundImprovement = true;
                                    bestAttemptValue = lossValue;
                                    bestAttempt.clear();
                                    for (Unit n:nextAttempt
                                         ) {
                                        bestAttempt.add(n.copy());
                                    }
                                    //bestAttempt = nextAttempt;
                                    //newBestAttemptLosses = combinedLoss;

                                }

                            }
                        }

                    }

                }
            }

        }
        if(foundImprovement){
            bestAttempt = fineTuneAttack(nextWaveMonsterUnits,bestAttempt);
        }




        return bestAttempt;


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
