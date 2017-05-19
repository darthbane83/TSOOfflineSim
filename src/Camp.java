import units.General;
import units.Unit;


import java.util.*;

/**
 * Created by Jens on 12.05.2017.
 */
public class Camp {
    private ArrayList<Unit> playerUnits;
    private ArrayList<Unit> monsterUnits;


    private Random rand = new Random(System.nanoTime());



    private int round = 1;
    private double phase = 0.0 ;
    PriorityQueue<Unit> attackQueuePlayer = new PriorityQueue<Unit>(new Comparator<Unit>() {
        @Override
        public int compare(Unit o1, Unit o2) {

            if (o1.getAttackInitiative() < o2.getAttackInitiative()){
                return -1;
            }
            else {
                return 1;
            }
        }
    });
    PriorityQueue<Unit> attackQueueMonster =  new PriorityQueue<Unit>(new Comparator<Unit>() {
        @Override
        public int compare(Unit o1, Unit o2) {

            if (o1.getAttackInitiative() < o2.getAttackInitiative()){
                return -1;
            }
            else {
                return 1;
            }
        }
    });
    public Camp(ArrayList<Unit> playerUnits,ArrayList<Unit> monsterUnits){
        this.playerUnits = playerUnits;
        this.monsterUnits = monsterUnits;
    }

    public int getRound() {
        return round;
    }



    public ArrayList<Unit> startFight(){
        ArrayList<Unit> initialPlayerUnits= new ArrayList<Unit>();
        ArrayList<Unit> initialMonsterUnits = new ArrayList<Unit>();

        for (Unit u:playerUnits) {
            initialPlayerUnits.add(u.copy());
        }
        for (Unit u:monsterUnits) {
            initialMonsterUnits.add(u.copy());
        }
        while(!playerUnits.isEmpty() && !monsterUnits.isEmpty()){
            if (phase ==3){
                round++;
                phase =1;
            }
            else{
                phase=phase +1;
            }

            //fetch first Strike units
            for (Unit u:playerUnits) {
                if (u.getAttackInitiative()>=phase && u.getAttackInitiative() <1+phase){
                    attackQueuePlayer.add(u.copy());
                }
                if(u.isGeneral()&& phase==3.0){
                    General g = (General)u;
                    if(g.getLightningSlash()==1){
                        attackQueuePlayer.add(u.copy());
                    }
                }
            }

            for (Unit u:monsterUnits
                    ) {
                if (u.getAttackInitiative()>=phase && u.getAttackInitiative() <1+phase){
                    attackQueueMonster.add(u.copy());
                }
            }
            //player units first
            while(!attackQueuePlayer.isEmpty()){
                Unit attackingUnits = attackQueuePlayer.poll();

                for (int i = 0;i<attackingUnits.getRemainingUnits();i++){
                    if(monsterUnits.isEmpty()){
                        break;
                    }

                    if(attackingUnits.isFlanking()){
                        // find lowest max hp units
                        monsterUnits.sort(new Comparator<Unit>() {
                            @Override
                            public int compare(Unit o1, Unit o2) {
                                if(o1.getMaxHp()<o2.getMaxHp()){
                                    return -1;
                                }
                                else{
                                    return 1;
                                }

                            }
                        });
                    }
                    else{
                        //find lowest defense initiative units
                        monsterUnits.sort(new Comparator<Unit>() {
                            @Override
                            public int compare(Unit o1, Unit o2) {
                                if(o1.getDefendInitiative()<o2.getDefendInitiative()){
                                    return -1;
                                }
                                else{
                                    return 1;
                                }

                            }
                        });


                    }
                    //calculate single units damage
                    double randomNum = Math.random();
                    int damage;
                    if (randomNum<= attackingUnits.getAccuracy()){
                        damage = attackingUnits.getMaxDamage();
                    }
                    else{
                        damage = attackingUnits.getMinDamage();
                    }

                    for (Unit g:playerUnits ) {
                        if(g.isGeneral()){
                            General g1 = (General)g;
                            //multiplier=0 if battle frenzy not taken.
                            double multiplier=0.1*g1.getBattleFrenzy()*((double)round-1);
                            damage=(int)Math.floor((double)damage*(1+multiplier));
                        }
                    }


                    if (attackingUnits.isSplash()){
                        while(damage>0){
                            if(monsterUnits.isEmpty()){break;}
                            Unit defendingMonster = monsterUnits.get(0);
                            if(damage>=defendingMonster.getCurrentHP()){
                                int remaining = defendingMonster.getRemainingUnits();
                                if(remaining<=1){
                                    damage=damage-defendingMonster.getCurrentHP();
                                    monsterUnits.remove(0);

                                }
                                else{
                                    defendingMonster.setRemainingUnits(remaining-1);
                                    damage=damage-defendingMonster.getCurrentHP();
                                    defendingMonster.setCurrentHP(defendingMonster.getMaxHp());
                                }

                            }
                            else{
                                defendingMonster.setCurrentHP(defendingMonster.getCurrentHP()-damage);
                                damage=0;
                            }
                        }


                    }
                    else{
                        Unit defendingMonster = monsterUnits.get(0);
                        if(damage>=defendingMonster.getCurrentHP()){
                            int remaining = defendingMonster.getRemainingUnits();
                            if(remaining<=1){
                                defendingMonster.setRemainingUnits(remaining-1);
                                monsterUnits.remove(0);

                            }
                            else{
                                defendingMonster.setRemainingUnits(remaining-1);
                                defendingMonster.setCurrentHP(defendingMonster.getMaxHp());
                            }

                        }
                        else{
                            defendingMonster.setCurrentHP(defendingMonster.getCurrentHP()-damage);
                        }

                    }

                }

            }

            while(!attackQueueMonster.isEmpty()){
                Unit attackingUnits = attackQueueMonster.poll();
                for (int i = 0;i<attackingUnits.getRemainingUnits();i++){

                    if(playerUnits.isEmpty()){
                        break;
                    }
                    if(attackingUnits.isFlanking()){
                        // find lowest max hp units

                        playerUnits.sort(new Comparator<Unit>() {
                            @Override
                            public int compare(Unit o1, Unit o2) {
                                //catch o1 being general.
                                if(o1.isGeneral()){
                                    return 1;
                                }
                                //catch o2 being general.
                                if (o2.isGeneral()){
                                    return -1;
                                }
                                if(o1.getMaxHp()<o2.getMaxHp()){
                                    return -1;
                                }
                                else{
                                    return 1;
                                }

                            }
                        });
                    }
                    else{
                        //find lowest defense initiative units
                        playerUnits.sort(new Comparator<Unit>() {
                            @Override
                            public int compare(Unit o1, Unit o2) {
                                if(o1.getDefendInitiative()<o2.getDefendInitiative()){
                                    return -1;
                                }
                                else{
                                    return 1;
                                }

                            }
                        });


                    }
                    //calculate single units damage
                    double randomNum = Math.random();
                    int damage;
                    if (randomNum<= attackingUnits.getAccuracy()){
                        damage = attackingUnits.getMaxDamage();
                    }
                    else{
                        damage = attackingUnits.getMinDamage();
                    }


                    if (attackingUnits.isSplash()){
                        while(damage>0){
                            if(playerUnits.isEmpty()){break;}
                            Unit defendingUnit = playerUnits.get(0);
                            if(damage>=defendingUnit.getCurrentHP()){
                                int remaining = defendingUnit.getRemainingUnits();
                                if(remaining<=1){
                                    damage=damage-defendingUnit.getCurrentHP();
                                    playerUnits.remove(0);

                                }
                                else{
                                    defendingUnit.setRemainingUnits(remaining-1);
                                    damage=damage-defendingUnit.getCurrentHP();
                                    defendingUnit.setCurrentHP(defendingUnit.getMaxHp());
                                }

                            }
                            else{
                                defendingUnit.setCurrentHP(defendingUnit.getCurrentHP()-damage);
                                damage=0;
                            }
                        }


                    }
                    else{
                        Unit defendingUnit = playerUnits.get(0);
                        if(damage>=defendingUnit.getCurrentHP()){
                            int remaining = defendingUnit.getRemainingUnits();
                            if(remaining<=1){
                                playerUnits.remove(0);

                            }
                            else{
                                defendingUnit.setRemainingUnits(remaining-1);
                                defendingUnit.setCurrentHP(defendingUnit.getMaxHp());
                            }

                        }
                        else{
                            defendingUnit.setCurrentHP(defendingUnit.getCurrentHP()-damage);
                        }

                    }

                }

            }



        }
        //calculate losses
        ArrayList<Unit> lossUnits = new ArrayList<>();

        for (Unit initial:initialPlayerUnits) {
            boolean allDead = true;
            for (Unit remaining: playerUnits ) {
                if(initial.getName().equals(remaining.getName())){
                    allDead = false;
                    initial.setRemainingUnits(initial.getRemainingUnits()-remaining.getRemainingUnits());
                    lossUnits.add(initial);

                }

            }
            if(allDead){
                lossUnits.add(initial);
            }
        }
        for (Unit initial:initialMonsterUnits) {
            boolean allDead = true;
            for (Unit remaining: monsterUnits ) {
                if(initial.getName().equals(remaining.getName())){
                    allDead = false;
                    initial.setRemainingUnits(initial.getRemainingUnits()-remaining.getRemainingUnits());
                    lossUnits.add(initial);

                }

            }
            if(allDead){
                lossUnits.add(initial);
            }
        }
        //System.out.println("Rounds: " + round);
        return lossUnits;

    }

}
