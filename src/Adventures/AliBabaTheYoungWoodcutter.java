package Adventures;

import units.Unit;
import units.UnitFactory;

import java.util.ArrayList;

/**
 * Created by Jens on 23.05.2017.
 */
public class AliBabaTheYoungWoodcutter extends Adventure {
    @Override
    public ArrayList<Unit> createCamp(int i){
        UnitFactory factory = new UnitFactory();
        ArrayList<Unit> result = new ArrayList<>();
        Unit u1 = new Unit("default",0,0,0,0,0,0,false,false,0);
        Unit u2 = new Unit("default",0,0,0,0,0,0,false,false,0);
        Unit u3 = new Unit("default",0,0,0,0,0,0,false,false,0);
        Unit u4 = new Unit("default",0,0,0,0,0,0,false,false,0);

        if(i==1){
            u1 = factory.swordWielder(180);
        }
        if(i==2){
            u1 = factory.desertMarksman(110);
            u2 = factory.stoneCannon(100);
        }
        if(i==3){
            u1 = factory.desertMarksman(80);
            u2 = factory.horseman(120);
            u3 = factory.shrewdThief(1);
        }
        if(i==4){
            u1 = factory.swordWielder(80);
            u2 = factory.mountedBowman(80);
        }
        if(i==5){
            u1 = factory.swordMaster(150);
        }
        if(i==6){
            u1 = factory.swordWielder(70);
            u2 = factory.horseman(70);
            u3 = factory.duneMarksman(50);
        }
        if(i==7){
            u1 = factory.duneMarksman(90);
            u2 = factory.horseman(80);
            u3 = factory.greedyThief(1);
        }
        if(i==8){
            u1 = factory.swordClasher(90);
            u2 = factory.mountedBowman(80);
        }
        if(i==9){
            u1 = factory.swordWielder(70);
            u2 = factory.horseman(70);
        }
        if(i==10){
            u1 = factory.swordClasher(90);
            u2 = factory.stoneCannon(90);
        }
        if(i==11){
            u1 = factory.horseman(80);
            u2 = factory.duneMarksman(80);
            u3 = factory.mysteriousThief(1);
        }
        if(i==12){
            u1 = factory.swordMaster(70);
            u2 = factory.horseman(50);
            u3 = factory.duneMarksman(60);
        }
        if(i==13){
            u1 = factory.desertMarksman(70);
            u2 = factory.mountedBowman(70);
        }
        if(i==14){
            u1 = factory.desertMarksman(90);
            u2 = factory.horseman(90);
            u3 = factory.smartThief(1);
        }
        if(i==15){
            u1 = factory.swordClasher(90);
            u2 = factory.horseman(80);
            u3 = factory.treacherousThief(1);
        }
        if(i==16){
            u1 = factory.swordWielder(90);
            u2 = factory.mountedBowman(20);
            u3 = factory.horseman(80);
        }
        if(i==17){
            u1 = factory.desertMarksman(100);
            u2 = factory.stoneCannon(100);
        }
        if(i==18){
            u1 = factory.swordWielder(50);
            u2 = factory.swordMaster(70);
            u3 = factory.desertMarksman(40);
        }
        if(i==19){
            u1 = factory.horseman(80);
            u2 = factory.stoneCannon(80);
            u4 = factory.banditLord(1);
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
