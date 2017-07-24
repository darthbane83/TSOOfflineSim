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
            u3 = factory.unicorn(1);
            u4 = factory.epWolf(80);
        }
        if(i==12){
            u1 = factory.epFox(140);
            u2 = factory.epWolf(60);
        }
        if(i==13){
            u1 = factory.epBear(40);
            u2 = factory.epFox(60);
        }
        if(i==14){
            u1 = factory.epBear(50);
            u2 = factory.epWolf(80);
        }
        if(i==15){
            u1 = factory.epFox(160);

        }
        if(i==16){
            u1 = factory.epWolf(190);

        }
        if(i==17){
            u1 = factory.epBear(50);
            u2 = factory.furiousBoar(1);
            u3 = factory.epFox(80);
            u4 = factory.epWolf(69);
        }
        if(i==18){
            u1 = factory.royalRecruit(80);
            u2 = factory.royalBowman(60);
        }
        if(i==19){
            u1 = factory.royalMilitia(50);
            u2 = factory.royalLongbowman(60);
        }
        if(i==20){
            u1 = factory.royalMilitia(60);
            u2 = factory.royalCannoneer(30);
        }
        if(i==21){

            u2 = factory.royalLongbowman(120);
        }
        if(i==22){
            u1 = factory.royalRecruit(170);

        }
        if(i==23){
            u1 = factory.royalBowman(150);
            u2 = factory.royalCavalry(30);
        }
        if(i==24){
            u1 = factory.royalMilitia(30);
            u2 = factory.royalCavalry(40);
            u3 = factory.royalLongbowman(80);
        }
        if(i==25){
            u1 = factory.royalMilitia(60);
            u2 = factory.royalCavalry(40);
            u3 = factory.royalLongbowman(80);
            u4 = factory.evilKing(1);
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
