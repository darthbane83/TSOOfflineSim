import Adventures.Adventure;
import Adventures.ValiantLittleTailor;
import units.Unit;
import units.UnitFactory;

import java.util.ArrayList;

/**
 * Created by Jens on 18.05.2017.
 */
public class findBestAttackCamp {
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

        //initialPlayerUnitsFinalWave.add(factory.createPlayerR(65));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerM(270));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerS(270));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerES(1));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerC(270));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerBow(70));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerLB(270));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerXB(270));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerCN(99));

        //initialPlayerUnitsFinalWave.add(factory.createPlayerSM(270));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerMS(10));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerK(18));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerMA(5));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerMM(250));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerAM(260));
        //initialPlayerUnitsFinalWave.add(factory.createPlayerB(43));


        //add Sacrifice waves as needed common setups found below already initiated

        //initialPlayerUnits.add(initialPlayerUnitsNusala1R);
        //initialPlayerUnits.add(initialPlayerUnitsNusala165Bow);
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
        initialMonsterUnits = addy.createCamp(9);

        SimulateSingleCamp.findBestRegularFinalWave(initialPlayerUnits,initialMonsterUnits);
    }
}
