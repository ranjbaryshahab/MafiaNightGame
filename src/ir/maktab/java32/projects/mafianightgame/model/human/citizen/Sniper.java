package ir.maktab.java32.projects.mafianightgame.model.human.citizen;

import ir.maktab.java32.projects.mafianightgame.model.human.Human;

import java.util.List;
import java.util.Random;

public class Sniper extends Citizen {
    private static Sniper sniper = null;

    private Sniper() {
    }

    public static Sniper getSniper() {
        if (sniper == null) {
            sniper = new Sniper();
        }
        return sniper;
    }

    //if aliveList size == 10 has to kill someone of aliveList.
    public Human kill(List<Human> aliveList) {
            //Choose a random number of 1 until humanList size
            int humanRandomId = new Random().nextInt(aliveList.size()) + 1;
            System.out.println("sniper :" + humanRandomId);
            //Getting human by id and return it
            Human kill = Human.getHumanById(aliveList, humanRandomId);
            return kill;
    }


}
