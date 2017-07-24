package Adventures;

import units.Unit;
import units.UnitFactory;

import java.util.ArrayList;

/**
 * Created by Jens on 24.07.2017.
 */
public class ThirdThief extends Adventure {
    @Override
    public ArrayList<Unit> createCamp(int i){
        UnitFactory factory = new UnitFactory();
        ArrayList<Unit> result = new ArrayList<>();
        Unit u1 = new Unit("default",0,0,0,0,0,0,false,false,0);
        Unit u2 = new Unit("default",0,0,0,0,0,0,false,false,0);
        Unit u3 = new Unit("default",0,0,0,0,0,0,false,false,0);
        Unit u4 = new Unit("default",0,0,0,0,0,0,false,false,0);

        if(i==1){
            u1 = factory.swordClasher(60);
            u2 = factory.mountedBowman(70);
        }
        if(i==2){
            u1 = factory.swordClasher(70);
            u2 = factory.horseman(70);
        }
        if(i==3){
            u1 = factory.duneMarksman(60);
            u2 = factory.horseman(60);
            u3 = factory.stoneCannon(60);
        }
        if(i==4){
            u1 = factory.horseman(120);
            u2 = factory.scarredThief(1);
        }
        if(i==5){
            u1 = factory.horseman(90);
            u2 = factory.mountedBowman(80);
        }
        if(i==6){
            u1 = factory.stoneCannon(50);
            u2 = factory.duneMarksman(90);
            u3 = factory.mysteriousThief(1);
        }
        if(i==7){
            u1 = factory.swordWielder(60);
            u2 = factory.duneMarksman(60);
            u3 = factory.stoneCannon(60);
        }
        if(i==8){
            u1 = factory.stoneCannon(80);;
            u3 = factory.mountedBowman(80);
        }
        if(i==9){
            u1 = factory.mountedBowman(50);
            u2 = factory.stoneCannon(50);
            u3 = factory.swordClasher(50);
        }
        if(i==10){
            u1 = factory.mountedBowman(70);
            u2 = factory.stoneCannon(70);
            u3 = factory.greedyThief(1);
        }
        if(i==11){
            u1 = factory.swordClasher(80);
            u2 = factory.duneMarksman(70);
            u3 = factory.horseman(70);
        }

        if(i==12){
            u1 = factory.swordMaster(70);
            u2 = factory.desertMarksman(60);
        }
        if(i==13){
            u1 = factory.swordWielder(50);
            u2 = factory.desertMarksman(50);
            u3 = factory.boulderWorm(1);
        }
        if(i==14){
            u1 = factory.epFox(90);
            u2 = factory.epWolf(90);
        }
        if(i==15){
            u1 = factory.epWolfPackleader(120);
            u2 = factory.epBear(80);
        }
        if(i==16){
            u1 = factory.epBear(100);
            u2 = factory.epGiant(90);
        }
        if(i==17){
            u1 = factory.epWolfPackleader(80);
            u2 = factory.epFox(80);
            u3 = factory.epBear(80);
        }
        if(i==18){
            u1 = factory.epWolfPackleader(90);
            u2 = factory.epBoar(80);
        }
        if(i==19){
            u1 = factory.epFox(100);
            u2 = factory.epGiant(100);
        }
        if(i==20){
            u1 = factory.epFox(80);
            u2 = factory.epBoar(100);
            u3 = factory.giantBear(1);
        }
        if(i==21){
            u1 = factory.epBear(90);
            u2 = factory.epFox(90);
        }
        if(i==22){
            u1 = factory.epWolf(90);
            u2 = factory.epGiant(90);
        }
        if(i==23){
            u1 = factory.epFox(60);
            u2 = factory.epGiant(60);
            u3 = factory.epWolf(60);
        }
        if(i==24){
            u1 = factory.epWolfPackleader(80);
            u2 = factory.epBoar(80);
        }
        if(i==25){
            u1 = factory.epBear(100);
            u2 = factory.epFox(80);
        }
        if(i==26){
            u1 = factory.epWolfPackleader(80);
            u2 = factory.epFox(80);
            u3 = factory.furiousBoar(1);
        }
        if(i==27){
            u1 = factory.epFox(100);
            u2 = factory.epBoar(100);
            u3 = factory.giantBat(1);
        }
        if(i==28){
            u1 = factory.duneMarksman(10);
            u2 = factory.stoneCannon(80);
            u3 = factory.horseman(90);
        }
        if(i==29){
            u1 = factory.swordClasher(70);
            u2 = factory.horseman(70);
            u3 = factory.desertMarksman(70);
        }
        if(i==30){
            u1 = factory.mountedBowman(50);
            u2 = factory.swordWielder(40);
            u3 = factory.stoneCannon(40);
        }
        if(i==31){
            u1 = factory.swordWielder(80);
            u2 = factory.horseman(80);
        }
        if(i==32){
            u1 = factory.duneMarksman(90);
            u2 = factory.stoneCannon(90);
            u3 = factory.snootyThief(1);
        }
        if(i==33){
            u1 = factory.duneMarksman(50);
            u2 = factory.stoneCannon(70);
            u3 = factory.mountedBowman(70);
        }
        if(i==34){
            u1 = factory.horseman(50);
            u2 = factory.swordWielder(50);
            u3 = factory.mountedBowman(60);
        }
        if(i==35){
            u1 = factory.swordClasher(60);
            u2 = factory.horseman(60);
            u3 = factory.desertMarksman(60);
        }
        if(i==36){
            u1 = factory.swordMaster(40);
            u2 = factory.sillyThief(1);
            u3 = factory.shrewdThief(1);
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
