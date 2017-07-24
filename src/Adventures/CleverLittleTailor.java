package Adventures;

import units.*;

import java.util.ArrayList;

/**
 * Created by Jens on 17.05.2017.
 */
public class CleverLittleTailor extends Adventure{

    @Override
    public ArrayList<Unit> createCamp(int i){
        UnitFactory factory = new UnitFactory();
        ArrayList<Unit> result = new ArrayList<>();
        Unit u1 = new Unit("default",0,0,0,0,0,0,false,false,0);
        Unit u2 = new Unit("default",0,0,0,0,0,0,false,false,0);
        Unit u3 = new Unit("default",0,0,0,0,0,0,false,false,0);
        Unit u4 = new Unit("default",0,0,0,0,0,0,false,false,0);
        if(i==1){
            u1 = factory.roughneck(100);
            u2 = factory.ranger(100);

        }
        if(i==2){
            u1 = factory.ranger(200);
        }
        if(i==3){
            u1 = factory.roughneck(110);
            u2 = factory.ranger(90);
        }
        if(i==4){
            u1 = factory.chuck(1);
            u2 = factory.ranger(110);
            u3 = factory.roughneck(89);
        }
        if(i==5){
            u1 = factory.roughneck(130);
            u2 = factory.ranger(70);
        }
        if(i==6){
            u1 = factory.guardDog(80);
            u2 = factory.ranger(120);
        }
        if(i==7){
            u1 = factory.guardDog(100);
            u2 = factory.roughneck(100);
        }
        if(i==8){
            u1 = factory.roughneck(150);
            u2 = factory.ranger(50);
        }
        if(i==9){
            u2 = factory.ranger(90);
            u1 = factory.roughneck(110);
        }
        if(i==10){
            u1 = factory.roughneck(99);
            u2 = factory.ranger(100);
            u3 = factory.ironFist(1);
        }
        if(i==11){
            u1 = factory.epBoar(80);
            u4 = factory.epWolf(60);
        }
        if(i==12){
            u1 = factory.epBoar(90);
            u2 = factory.epFox(50);
        }
        if(i==13){
            u1 = factory.epBear(50);
            u2 = factory.epWolfPackleader(40);
        }
        if(i==14){
            u1 = factory.epBoar(110);
            u2 = factory.epWolfPackleader(30);
        }
        if(i==15){
            u1 = factory.epBear(110);
        }
        if(i==16){
            u1 = factory.epBear(80);
            u2 = factory.epFox(40);
            u3 = factory.epGiant(30);
        }
        if(i==17){
            u1 = factory.epFox(150);
        }
        if(i==18){
            u1 = factory.epFox(60);
            u2 = factory.epWolfPackleader(80);
        }
        if(i==19){
            u1 = factory.epBoar(50);
            u2 = factory.epBear(130);
        }
        if(i==20){
            u1 = factory.epBear(90);
            u2 = factory.epFox(50);
            u3 = factory.epGiant(40);
        }
        if(i==21){
            u1 = factory.epWolfPackleader(60);
            u2 = factory.epBear(40);
            u3 = factory.epBoar(80);
        }
        if(i==22){
            u1 = factory.epWolf(110);
            u2 = factory.epWolfPackleader(70);

        }
        if(i==23){
            u1 = factory.epBear(110);
            u2 = factory.epWolf(70);
        }
        if(i==24){
            u1 = factory.epBear(70);
            u2 = factory.epFox(110);
            u3 = factory.epGiant(20);
        }
        if(i==25){
            u1 = factory.epBear(90);
            u2 = factory.epWolfPackleader(70);
        }

        if(i==26){
            u1 = factory.epBear(110);
            u2 = factory.epGiant(69);
            u3 = factory.giantBear(1);
        }

        if(i==27){
            u1 = factory.guardDog(100);
            u2 = factory.roughneck(120);
        }
        if(i==28){
            u1 = factory.roughneck(220);
        }
        if(i==29){
            u1 = factory.metalTooth(1);
            u2 = factory.roughneck(180);
            u3 = factory.ranger(100);
        }
        if(i==30){
            u1 = factory.guardDog(60);
            u2 = factory.ranger(80);
            u3 = factory.roughneck(100);
        }
        if(i==31){
            u1 = factory.roughneck(70);
            u2 = factory.guardDog(190);
        }
        if(i==32){
            u1 = factory.roughneck(200);
            u2 = factory.ranger(80);
        }
        if(i==33){
            u1 = factory.guardDog(80);
            u2 = factory.roughneck(200);
            u3 = factory.rivalingTailor(1);
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
