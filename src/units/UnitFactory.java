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

    public Unit createPlayerM(int remainingUnits){
        return new Unit("PlayerM",60,20,40,0.8,2,1.1,false,false,remainingUnits);
    }

    public Unit createPlayerS(int remainingUnits){
        return new Unit("PlayerS",90,20,40,0.85,2,1.2,false,false,remainingUnits);
    }

    public Unit createPlayerES(int remainingUnits){
        return new Unit("PlayerES",120,20,40,0.9,2,1.3,false,false,remainingUnits);
    }

    public Unit createPlayerC(int remainingUnits){
        return new Unit("PlayerC",5,5,10,0.8,1,2,false,false,remainingUnits);
    }

    public Unit createPlayerB(int remainingUnits){
        return new Unit("PlayerB",10,20,40,0.8,2,2.1,false,false,remainingUnits);
    }

    public Unit createPlayerLB(int remainingUnits){
        return new Unit("PlayerLB",10,30,60,0.8,2,2.2,false,false,remainingUnits);
    }

    public Unit createPlayerXB(int remainingUnits){
        return new Unit("PlayerXB",10,45,90,0.8,2,2.3,false,false,remainingUnits);
    }

    public Unit createPlayerCN(int remainingUnits){
        return new Unit("PlayerCN",60,60,120,0.9,3,2.4,false,false,remainingUnits);
    }

    //Bandits

    //cultists

    //animals

    //royal

    //Deserter

    //Ali baba



}
