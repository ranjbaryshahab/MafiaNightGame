package ir.maktab.java32.projects.mafianightgame.model.human.citizen;

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
}
