package ir.maktab.java32.projects.mafianightgame.model.human.citizen;

import ir.maktab.java32.projects.mafianightgame.model.human.Human;

import java.util.List;
import java.util.Random;

/**
 * @author Shahab
 * @author Mohamad Hosein
 * @author Alireza
 */
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

    //Kill a human
    public Human kill(List<Human> aliveList) {
        //Choose a random number of 1 until humanList size and return it.
        return aliveList.get(new Random().nextInt(aliveList.size()));
    }


}
