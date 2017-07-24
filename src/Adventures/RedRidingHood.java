package Adventures;

import units.Unit;
import units.UnitFactory;

import java.util.ArrayList;

/**
 * Created by Jens on 17.06.2017.
 */
public class RedRidingHood extends Adventure{
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
            u1 = factory.epBoar(150);
            u2 = factory.epWolfPackleader(100);
        }
        if(i==3){
            u1 = factory.epBoar(150);
            u2 = factory.epWolfPackleader(200);
            u3 = factory.epGiant(50);
            u4 = factory.giantBogor(1);
        }
        if(i==4){
            u1 = factory.epBoar(400);
        }
        if(i==5){
            u1 = factory.epFox(300);
            u2 = factory.epWolfPackleader(250);

        }
        if(i==6){
            u1 = factory.epWolfPackleader(100);
            u2 = factory.epFox(150);
            u3 = factory.epBear(150);
            u4 = factory.furiousBoar(1);

        }
        if(i==7){
            u1 = factory.epBear(150);
            u2 = factory.epWolf(200);
        }
        if(i==8){
            u1 = factory.epBear(100);
            u2 = factory.epWolfPackleader(200);
            u3 = factory.unicorn(1);
            u4 = factory.furiousBoar(1);
        }
        if(i==9){

            u1 = factory.epBoar(200);
            u2 = factory.epFox(100);
            u3 = factory.epBear(100);

        }
        if(i==10){
            u1 = factory.epWolf(150);
            u2 = factory.epWolfPackleader(150);
            u3 = factory.epFox(150);
        }
        if(i==11){
            u1 = factory.epBear(100);
            u2 = factory.epBoar(150);
            u3 = factory.epFox(150);
        }
        if(i==12){
            u1 = factory.epBear(100);
            u2 = factory.epGiant(200);
            u3 = factory.furiousBoar(1);
        }
        if(i==13){
            u1 = factory.epBear(300);
        }
        if(i==14){
            u1 = factory.epBear(100);
            u2 = factory.epWolfPackleader(200);
            u3 = factory.epWolf(100);
        }
        if(i==15){
            u1 = factory.epBear(300);
        }
        if(i==16){
            u1 = factory.epGiant(150);
            u2 = factory.epWolfPackleader(100);
            u3 = factory.epBoar(200);
            u4 = factory.giantGogor(1);
            u5 = factory.giantBogor(1);
        }
        if(i==17){
            u1 = factory.epWolfPackleader(50);
            u2 = factory.epWolf(50);
            u3 = factory.epGiant(50);
            u4 = factory.epBear(200);
        }
        if(i==18){
            u1 = factory.royalRecruit(150);
            u2 = factory.royalMilitia(150);
        }
        if(i==19){
            u1 = factory.royalRecruit(100);
            u2 = factory.royalBowman(100);
            u3 = factory.royalLongbowman(100);
            u4 = factory.royalCavalry(200);
        }
        if(i==20){
            u1 = factory.royalMilitia(150);
            u2 = factory.royalCavalry(100);
            u3 = factory.royalCaptain(1);

        }
        if(i==21){
            u1 = factory.royalLongbowman(250);
            u2 = factory.royalCavalry(100);
        }
        if(i==22){
            u1 = factory.royalRecruit(200);
            u2 = factory.royalMilitia(200);
            u3 = factory.assassin(1);
            u4 = factory.ironFist(1);
        }
        if(i==23){
            u1 = factory.royalMilitia(150);
            u2 = factory.royalCavalry(150);
        }
        if(i==24){
            u1 = factory.royalMilitia(175);
            u2 = factory.royalRecruit(200);
        }
        if(i==25){
            u1 = factory.royalRecruit(100);
            u2 = factory.royalMilitia(175);
            u3 = factory.royalCannoneer(50);
            u4 = factory.royalJuggernaut(1);
        }
        if(i==26){
            u1 = factory.royalMilitia(250);
            u2 = factory.royalLongbowman(150);
            u3 = factory.evilQueenIlsebille(1);
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
