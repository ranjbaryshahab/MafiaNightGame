package ir.maktab.java32.projects.mafianightgame.model.human.citizen;

import ir.maktab.java32.projects.mafianightgame.model.human.Human;

import java.util.List;
import java.util.Random;

public class Sniper extends Citizen {
    private static Sniper sniper = null;
    private List<Human> aliveList;

    private Sniper() {
    }

    public static Sniper getSniper() {
        if (sniper == null) {
            sniper = new Sniper();
        }
        return sniper;
    }

    public static void setSniper(Sniper sniper) {
        Sniper.sniper = sniper;
    }

    public List<Human> getAliveList() {
        return aliveList;
    }

    public void setAliveList(List<Human> aliveList) {
        this.aliveList = aliveList;
    }

    Random random = new Random();

    //if aliveList size == 10 has to kill someone of aliveList.
    public Human kill() {
        Human hasToKill = null;
        if (aliveList.size() == 10) {
            hasToKill = aliveList.get(random.nextInt(aliveList.size()));
        }
        return hasToKill;
    }
}
