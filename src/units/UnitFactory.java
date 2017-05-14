package units;

/**
 * Created by Jens on 15.05.2017.
 */
public class UnitFactory {
    public UnitFactory(){

    }





    //General
    public Unit createNusala(){
        General g = new General("Nusala",150,1000,1500,0.90,1.1,3,true,true);
        g.setMaxUnits(165);
        return g;

    }
    public Unit create270(){
        General g = new General("270",1,120,120,1,2.7,2.5,false,false);
        g.setMaxUnits(270);
        return g;
    }

    //player elite units
    public Unit createPlayerMa(int remainingUnits){
        return new Unit("PlayerMa",50,50,100,0.9,2.3,2.0,false,false,remainingUnits);
    }

    //player standard units
    public Unit createPlayerR(int remainingUnits){
        return new Unit("PlayerR",40,15,30,0.8,2,1,false,false,remainingUnits);
    }

    //Bandits

    //cultists

    //animals

    //royal

    //Deserter

    //Ali baba



}
