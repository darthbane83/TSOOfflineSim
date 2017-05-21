package Adventures;

import units.Unit;
import units.UnitFactory;

import java.util.ArrayList;

/**
 * Created by Jens on 21.05.2017.
 */
public class PiedPiperOfHarmelin extends Adventure {
    @Override
    public ArrayList<Unit> createCamp(int i){
        UnitFactory factory = new UnitFactory();
        ArrayList<Unit> result = new ArrayList<>();
        Unit u1 = new Unit("default",0,0,0,0,0,0,false,false,0);
        Unit u2 = new Unit("default",0,0,0,0,0,0,false,false,0);
        Unit u3 = new Unit("default",0,0,0,0,0,0,false,false,0);
        Unit u4 = new Unit("default",0,0,0,0,0,0,false,false,0);

        if(i==1){
            u1 = factory.epBoar(100);
            u2 = factory.epWolfPackleader(100);
            u3 = factory.epGiant(50);

        }
        if(i==2){
            u1 = factory.epFox(50);
            u2 = factory.epWolf(100);
            u3 = factory.giantBogor(1);
            u4 = factory.giantGogor(1);
        }
        if(i==3){
            u1 = factory.epBear(150);
            u2 = factory.epWolfPackleader(150);
            u3 = factory.epFox(100);
            u4 = factory.furiousBoar(1);
        }
        if(i==4){
            u1 = factory.epBear(200);
            u2 = factory.epFox(100);
            u3 = factory.epWolfPackleader(50);
            u4 = factory.lyingGoat(1);
        }
        if(i==5){
            u1 = factory.epBear(75);
            u2 = factory.epWolf(150);
            u3 = factory.epWolfPackleader(150);

        }
        if(i==6){
            u1 = factory.epBear(75);
            u2 = factory.epFox(250);
            u3 = factory.piedPiperOfHarmelin(1);
            u4 = factory.kingOfRats(1);

        }
        if(i==7){
            u1 = factory.elitesoldierDeserter(50);
            u2 = factory.crossbowmanDeserter(100);
            u3 = factory.royalRecruit(100);
            u4 = factory.royalMilitia(50);

        }
        if(i==8){
            u1 = factory.elitesoldierDeserter(50);
            u2 = factory.royalMilitia(100);
            u3 = factory.royalBowman(50);
        }
        if(i==9){
            u1 = factory.crossbowmanDeserter(50);
            u2 = factory.royalCavalry(200);
            u3 = factory.darkMagician(1);
        }
        if(i==10){
            u1 = factory.royalLongbowman(200);
            u2 = factory.royalCavalry(200);
        }
        if(i==11){
            u1 = factory.royalMilitia(100);
            u2 = factory.royalCannoneer(100);
            u3 = factory.greedyInnKeeper(1);
        }
        if(i==12){
            u1 = factory.royalMilitia(100);
            u2 = factory.royalLongbowman(50);
            u3 = factory.royalCavalry(200);
        }
        if(i==13){
            u1 = factory.royalCavalry(150);
            u2 = factory.royalMilitia(250);
            u3 = factory.theMayor(1);
        }


        if(!u1.getName().equals("default")){
            result.add(u1);
        }
        if(!u2.getName().equals("default")){
            result.add(u2);
        }
        if(!u3.getName().equals("default")){
            result.add(u3);
        }
        if(!u4.getName().equals("default")){
            result.add(u4);
        }
        return result;
    }
}
