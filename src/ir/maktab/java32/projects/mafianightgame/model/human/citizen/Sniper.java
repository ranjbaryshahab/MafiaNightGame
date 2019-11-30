package ir.maktab.java32.projects.mafianightgame.model.human.citizen;

import ir.maktab.java32.projects.mafianightgame.model.human.Human;

import java.util.List;

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

    //if aliveList size == 10 has to kill someone of aliveList.
    public Human kill() {
        if (aliveList.size() == 10) {
        }
        return null;
    }
}
