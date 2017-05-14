import units.*;

import java.util.ArrayList;

/**
 * Created by Jens on 14.05.2017.
 */
public class SimulateSingleCamp {

    public static void main(String[] args){
        ArrayList<Unit> initialPlayerUnits = new ArrayList<>();
        ArrayList<Unit> initialMonsterUnits = new ArrayList<>();
        UnitFactory factory = new UnitFactory();
        initialPlayerUnits.add(factory.createNusala());
        initialPlayerUnits.add(factory.createPlayerR(165));


        Simulation sim = new Simulation(initialMonsterUnits, initialPlayerUnits);
        System.out.print(sim.simulation(1000));



    }
}
