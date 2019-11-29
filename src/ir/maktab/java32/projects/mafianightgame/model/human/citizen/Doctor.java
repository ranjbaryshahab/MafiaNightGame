package ir.maktab.java32.projects.mafianightgame.model.human.citizen;

public class Doctor extends Citizen {
    private static Doctor doctor = null;

    private Doctor() {
    }

    public static Doctor getDoctor() {
        if (doctor == null) {
            doctor = new Doctor();
        }
        return doctor;
    }
}
