package ir.maktab.java32.projects.mafianightgame.model.human.citizen;

public class Detective extends Citizen {
    private static Detective detective = null;

    private Detective() {
    }

    public static Detective getDetective() {
        if (detective == null) {
            detective = new Detective();
        }
        return detective;
    }
}
