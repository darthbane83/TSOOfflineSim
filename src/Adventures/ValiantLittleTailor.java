package Adventures;

import units.*;

import java.util.ArrayList;

/**
 * Created by Jens on 17.05.2017.
 */
public class ValiantLittleTailor extends Adventure{

    @Override
    public ArrayList<Unit> createCamp(int i){
        UnitFactory factory = new UnitFactory();
        ArrayList<Unit> result = new ArrayList<>();
        Unit u1 = new Unit("default",0,0,0,0,0,0,false,false,0);
        Unit u2 = new Unit("default",0,0,0,0,0,0,false,false,0);
        Unit u3 = new Unit("default",0,0,0,0,0,0,false,false,0);
        Unit u4 = new Unit("default",0,0,0,0,0,0,false,false,0);
        if(i==1){
            u1 = factory.epFox(30);
            u2 = factory.epBoar(100);

        }
        if(i==2){
            u1 = factory.epWolf(120);
        }
        if(i==3){
            u1 = factory.epWolf(30);
            u2 = factory.epBoar(130);
        }
        if(i==4){
            u1 = factory.epWolf(90);
            u2 = factory.epFox(90);
        }
        if(i==5){
            u1 = factory.epFox(30);
            u2 = factory.epBoar(120);
        }
        if(i==6){
            u1 = factory.epFox(60);
            u2 = factory.epBoar(80);
            u3 = factory.giantBogor(1);
            u4 = factory.giantGogor(1);
        }
        if(i==7){
           u2 = factory.epBoar(170);
        }
        if(i==8){
            u1 = factory.epWolf(60);
            u2 = factory.epBoar(90);
        }
        if(i==9){
            u1 = factory.epBoar(180);
        }
        if(i==10){
            u1 = factory.epBoar(100);
            u2 = factory.epFox(60);
        }
        if(i==11){
            u1 = factory.epBoar(50);
            u2 = factory.epFox(60);
            u3 = factory.Unicorn(1);
            u4 = factory.epWolf(80);
        }
        if(i==12){
            u1 = factory.epFox(140);
            u2 = factory.epWolf(60);
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
