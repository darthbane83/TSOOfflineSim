package Adventures;

import Adventures.Adventure;
import units.Unit;
import units.UnitFactory;

import java.util.ArrayList;

/**
 * Created by Jens on 16.05.2017.
 */
public class HanselAndGretel extends Adventure {

    @Override
    public ArrayList<Unit> createCamp(int i){
        UnitFactory factory = new UnitFactory();
        ArrayList<Unit> result = new ArrayList<>();
        Unit u1 = new Unit("default",0,0,0,0,0,0,false,false,0);
        Unit u2 = new Unit("default",0,0,0,0,0,0,false,false,0);
        Unit u3 = new Unit("default",0,0,0,0,0,0,false,false,0);
        Unit u4 = new Unit("default",0,0,0,0,0,0,false,false,0);

        if(i==1){
            u1 = factory.epFox(200);
            u2 = factory.epWolfPackleader(200);

        }
        if(i==2){
            u1 = factory.epBoar(150);
            u2 = factory.epWolfPackleader(100);
        }
        if(i==3){
            u1 = factory.epBear(150);
            u2 = factory.epWolf(100);
            u3 = factory.epGiant(100);
        }
        if(i==4){
            u1 = factory.epBoar(200);
            u2 = factory.epFox(100);

        }
        if(i==5){
            u1 = factory.epBoar(160);
            u2 = factory.epWolf(180);

        }
        if(i==6){
            u1 = factory.epWolfPackleader(150);
            u2 = factory.epFox(200);

        }
        if(i==7){
            u1 = factory.epBear(100);
            u2 = factory.epFox(200);
            u3 = factory.epGiant(50);

        }
        if(i==8){
            u1 = factory.epBear(200);
            u2 = factory.epFox(200);
        }
        if(i==9){
            u1 = factory.epWolfPackleader(100);
            u2 = factory.epFox(150);
        }
        if(i==10){
            u1 = factory.epBear(150);
            u2 = factory.epWolfPackleader(150);
        }
        if(i==11){
            u1 = factory.epBear(125);
            u2 = factory.epWolf(200);
        }
        if(i==12){
            u1 = factory.epWolfPackleader(150);
            u2 = factory.epFox(200);
        }
        if(i==13){
            u1 = factory.epBoar(200);
            u2 = factory.epFox(100);
            u3 = factory.epGiant(50);
            u4 = factory.furiousBoar(1);
        }
        if(i==14){
            u1 = factory.RoyalRecruit(150);
            u2 = factory.RoyalMilitia(100);
        }
        if(i==15){
            u1 = factory.RoyalBowman(200);
            u2 = factory.RoyalMilitia(100);
        }
        if(i==16){
            u1 = factory.RoyalLongbowman(75);
            u2 = factory.RoyalMilitia(75);
            u3 = factory.RoyalCavalry(100);
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
