package ir.maktab.java32.projects.mafianightgame.model.human.mafia;

public class Godfather extends Mafia {
    private static Godfather godfather = null;

    private Godfather() {
    }

    public static Godfather getGodfather() {
        if (godfather == null) {
            godfather = new Godfather();
        }
        return godfather;
    }
}
