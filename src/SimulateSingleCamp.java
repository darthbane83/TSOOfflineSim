import units.*;

import java.util.ArrayList;

/**
 * Created by Jens on 14.05.2017.
 */
public class SimulateSingleCamp {

    public static void main(String[] args){
        ArrayList<ArrayList<Unit>> initialPlayerUnits = new ArrayList<>();
        ArrayList<Unit> initialPlayerUnitsWave1 = new ArrayList<>();
        ArrayList<Unit> initialPlayerUnitsWave2 = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        ArrayList<Unit> initialMonsterUnits = new ArrayList<>();
        ArrayList<Unit> nextWaveMonsterUnits = new ArrayList<>();

        UnitFactory factory = new UnitFactory();
        initialPlayerUnitsWave1.add(factory.createNusala());
        initialPlayerUnitsWave1.add(factory.createPlayerR(1));

        initialPlayerUnitsWave2.add(factory.create270());
        initialPlayerUnitsWave2.add(factory.createPlayerR(200));

        initialPlayerUnits.add(initialPlayerUnitsWave1);

        initialPlayerUnits.add(initialPlayerUnitsWave2);

        initialMonsterUnits.add(factory.bScavenger(200));


        for (Unit u:initialMonsterUnits) {
            nextWaveMonsterUnits.add(u.copy());
        }
        int simulationSize = 1000;

        for(int i=0;i<initialPlayerUnits.size();i++){
            Simulation sim = new Simulation(nextWaveMonsterUnits, initialPlayerUnits.get(i));

            ArrayList<ArrayList<Unit>> combinedLoss=sim.simulation(simulationSize);
            nextWaveMonsterUnits.clear();
            ArrayList<Unit> averageCombinedLoss=combinedLoss.get(0);
            ArrayList<Unit> minLoss=combinedLoss.get(1);
            ArrayList<Unit> maxLoss=combinedLoss.get(2);


            builder.append("Wave " + i +": ");
            builder.append(System.getProperty("line.separator"));
            builder.append("Average losses:");
            builder.append(System.getProperty("line.separator"));
            for (Unit u:averageCombinedLoss) {
                builder.append(u.getName() + " lost: " + (double)u.getRemainingUnits()/(double) simulationSize);
                builder.append(System.getProperty("line.separator"));
            }
            builder.append("Minimum losses:");
            builder.append(System.getProperty("line.separator"));
            for (Unit u:minLoss) {
                builder.append(u.getName() + " lost: " + (double)u.getRemainingUnits());
                builder.append(System.getProperty("line.separator"));
            }
            builder.append("Maximum losses:"+System.getProperty("line.separator"));

            for (Unit u:maxLoss) {
                builder.append(u.getName() + " lost: " + (double)u.getRemainingUnits());
                builder.append(System.getProperty("line.separator"));
            }
            for (Unit u:minLoss) {
                for (Unit u2:initialMonsterUnits) {
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
