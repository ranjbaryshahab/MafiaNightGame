package ir.maktab.java32.projects.mafianightgame.model.human.mafia;

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
}
