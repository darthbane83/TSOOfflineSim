package Adventures;

import units.Unit;
import units.UnitFactory;

import java.util.ArrayList;

public class SnowWhite extends Adventure{
    @Override
    public ArrayList<Unit> createCamp(int i){
        UnitFactory factory = new UnitFactory();
        ArrayList<Unit> result = new ArrayList<>();
        Unit u1 = new Unit("default",0,0,0,0,0,0,false,false,0);
        Unit u2 = new Unit("default",0,0,0,0,0,0,false,false,0);
        Unit u3 = new Unit("default",0,0,0,0,0,0,false,false,0);
        Unit u4 = new Unit("default",0,0,0,0,0,0,false,false,0);
        Unit u5 = new Unit("default",0,0,0,0,0,0,false,false,0);

        if(i==1){
            u1 = factory.epFox(200);
            u2 = factory.epWolfPackleader(150);

        }
        if(i==2){
            u1 = factory.epFox(150);
        }
        if(i==3){
            u1 = factory.epBoar(150);
            u2 = factory.epWolfPackleader(100);
            u3 = factory.epGiant(150);
        }
        if(i==4){
            u1 = factory.epFox(150);
            u2 = factory.epWolfPackleader(150);
        }
        if(i==5){
            u1 = factory.epBoar(100);
            u2 = factory.epWolfPackleader(150);
            u3 = factory.epGiant(150);
        }
        if(i==6){
            u1 = factory.royalRecruit(200);
            u2 = factory.royalBowman(100);
        }
        if(i==7){
            u1 = factory.royalRecruit(150);
            u2 = factory.royalMilitia(150);
            u3 = factory.royalHuntsmenLeader(1);
        }
        if(i==8){
            u1 = factory.royalRecruit(150);
            u2 = factory.royalMilitia(125);
        }
        if(i==9){

            u1 = factory.royalCavalry(150);
            u2 = factory.royalMilitia(150);
            u3 = factory.royalLongbowman(100);
            u4 = factory.assassin(1);

        }
        if(i==10){
            u1 = factory.royalMilitia(150);
            u2 = factory.royalBowman(150);
        }
        if(i==11){
            u1 = factory.royalCannoneer(100);
            u2 = factory.royalMilitia(150);
        }
        if(i==12){
            u1 = factory.royalCavalry(150);
            u2 = factory.royalMilitia(100);
            u3 = factory.thugLeader(1);
            u4 = factory.royalRecruit(100);
        }
        if(i==13){
            u1 = factory.royalLongbowman(250);
            u2 = factory.royalMilitia(100);
            u3 = factory.theEvilStepmother(1);

        }
        if(i==14){
            u1 = factory.royalRecruit(100);
            u2 = factory.royalMilitia(200);
        }
        if(i==15){
            u1 = factory.royalMilitia(150);
            u2 = factory.royalRecruit(150);
            u3 = factory.darkMagician(1);
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
        if(!u5.getName().equals("default")){
            result.add(u5);
        }
        return result;
    }
}