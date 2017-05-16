import Adventures.*;
import units.*;

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



        //initialPlayerUnitsFinalWave.add(factory.createCustomAnslem());
        initialPlayerUnitsFinalWave.add(factory.create270());
        //initialPlayerUnitsFinalWave.add(factory.createPlayerSM(270));
        initialPlayerUnitsFinalWave.add(factory.createPlayerMS(10));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerK(18));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerMA(5));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerMM(250));
        initialPlayerUnitsFinalWave.add(factory.createPlayerAM(260));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerB(43));


        //initialPlayerUnits.add(initialPlayerUnitsNusala1R);
        //initialPlayerUnits.add(initialPlayerUnitsNusala165Bow);
        //initialPlayerUnits.add(initialPlayerUnits200R);
        initialPlayerUnits.add(initialPlayerUnitsMMA1R);
        initialPlayerUnits.add(initialPlayerUnits2MMA1R);
        //initialPlayerUnits.add(initialPlayerUnits3MMA1R);
        initialPlayerUnits.add(initialPlayerUnitsMMA220R);
        initialPlayerUnits.add(initialPlayerUnitsFinalWave);

        /* setup monster units
        example1:
        initialMonsterUnits.add(factory.bScavenger(200));
        example 2:
        Adventure addy = new HanselAndGretel();
        initialMonsterUnits = addy.createCamp(1);
        */
        Adventure addy = new HanselAndGretel();
        initialMonsterUnits = addy.createCamp(26);


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

            ArrayList<Unit> averageCombinedLoss=combinedLoss.get(0);
            ArrayList<Unit> minLoss=combinedLoss.get(1);
            ArrayList<Unit> maxLoss=combinedLoss.get(2);


            builder.append("Wave " + i +": ");
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
                    if(u2.getName().equals(u.getName())){
                        if(u2.getRemainingUnits()==u.getRemainingUnits()){
                            builder.append("All "+ u2.getName()+ " are dead");
                            builder.append(System.getProperty("line.separator"));

                        }
                        else{
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
}
