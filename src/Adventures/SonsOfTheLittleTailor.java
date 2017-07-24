package Adventures;

import units.Unit;
import units.UnitFactory;

import java.util.ArrayList;

/**
 * Created by Jens on 12.07.2017.
 */
public class SonsOfTheLittleTailor extends Adventure{

    @Override
    public ArrayList<Unit> createCamp(int i){
        UnitFactory factory = new UnitFactory();
        ArrayList<Unit> result = new ArrayList<>();
        Unit u1 = new Unit("default",0,0,0,0,0,0,false,false,0);
        Unit u2 = new Unit("default",0,0,0,0,0,0,false,false,0);
        Unit u3 = new Unit("default",0,0,0,0,0,0,false,false,0);
        Unit u4 = new Unit("default",0,0,0,0,0,0,false,false,0);
        if(i==1){
            u1 = factory.roughneck(90);
            u2 = factory.ranger(110);
        }
        if(i==2){
            u1 = factory.roughneck(180);
            u2 = factory.ranger(20);
        }
        if(i==3){
            u1 = factory.roughneck(80);
            u2 = factory.guardDog(120);
        }
        if(i==4){
            u2 = factory.ranger(70);
            u3 = factory.roughneck(130);
        }
        if(i==5){
            u1 = factory.roughneck(119);
            u2 = factory.guardDog(80);
            u3 = factory.oneEyedBert(1);
        }
        if(i==6){
            u1 = factory.epBear(50);
            u2 = factory.epWolfPackleader(40);
        }
        if(i==7){
            u1 = factory.epBear(110);
        }
        if(i==8){
            u1 = factory.epBear(60);
            u2 = factory.epFox(40);
            u3 = factory.epGiant(30);
        }
        if(i==9){
            u2 = factory.epBoar(20);
            u1 = factory.epBear(80);
        }
        if(i==10){
            u1 = factory.epBear(70);
            u2 = factory.epFox(40);
            u3 = factory.epGiant(20);
        }
        if(i==11){
            u1 = factory.epBear(40);
            u4 = factory.epWolfPackleader(70);
        }
        if(i==12){
            u1 = factory.epWolfPackleader(60);
            u2 = factory.epWolf(90);
        }
        if(i==13){
            u1 = factory.epFox(90);
            u2 = factory.epGiant(20);
            u3 = factory.giantBear(1);
        }
        if(i==14){
            u1 = factory.epBoar(110);
            u2 = factory.epWolf(40);
        }
        if(i==15){
            u1 = factory.epBear(90);
            u2 = factory.epFox(50);
            u3 = factory.lyingGoat(1);
        }
        if(i==16){
            u1 = factory.epBear(70);
            u2 = factory.epFox(40);
        }
        if(i==17){
            u1 = factory.epBoar(140);
        }
        if(i==18){
            u1 = factory.epFox(50);
            u2 = factory.epGiant(20);
            u3 = factory.epBear(70);
        }
        if(i==19){
            u1 = factory.epBoar(120);
            u2 = factory.epWolf(70);
        }
        if(i==20){
            u1 = factory.epBoar(90);
            u2 = factory.epBear(40);
        }
        if(i==21){
            u1 = factory.epWolf(50);
            u2 = factory.epBear(90);
        }
        if(i==22){
            u1 = factory.epBoar(190);
        }
        if(i==23){
            u1 = factory.epBear(70);
            u2 = factory.epWolfPackleader(90);
            u3 = factory.giantGogor(1);
        }
        if(i==24){
            u1 = factory.epBear(80);
            u2 = factory.epWolf(50);
        }
        if(i==25){
            u1 = factory.epFox(30);
            u2 = factory.epWolfPackleader(70);
        }

        if(i==26){
            u1 = factory.epBoar(40);
            u2 = factory.epFox(60);
            u3 = factory.epGiant(50);
        }

        if(i==27){
            u1 = factory.guardDog(100);
            u2 = factory.roughneck(100);
        }
        if(i==28){
            u1 = factory.roughneck(150);
            u2 = factory.ranger(50);
        }
        if(i==29){
            u1 = factory.guardDog(20);
            u2 = factory.roughneck(180);
        }
        if(i==30){
            u1 = factory.guardDog(70);
            u3 = factory.roughneck(130);
        }
        if(i==31){
            u1 = factory.roughneck(120);
            u2 = factory.guardDog(80);
        }
        if(i==32){
            u1 = factory.roughneck(180);
            u2 = factory.ranger(40);
            u3 = factory.guardDog(30);
        }
        if(i==33){
            u1 = factory.guardDog(120);
            u2 = factory.ranger(80);
        }
        if(i==34){
            u1 = factory.roughneck(120);
            u2 = factory.ranger(80);
        }
        if(i==35){
            u1 = factory.roughneck(200);
        }
        if(i==36){
            u1 = factory.guardDog(80);
            u2 = factory.roughneck(119);
            u3 = factory.thugLeader(1);
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
