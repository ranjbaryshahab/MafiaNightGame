package ir.maktab.java32.projects.mafianightgame.model.human.mafia;

import ir.maktab.java32.projects.mafianightgame.model.human.citizen.Citizen;

public class Natasha extends Mafia {
    private static Natasha natasha = null;

    private Natasha() {
    }

    public static Natasha getNatasha() {
        if (natasha == null) {
            natasha = new Natasha();
        }
        return natasha;
    }

    //Get citizen most message length and canBeTalk = false
    public void silent(Citizen citizen) {
    }
}
