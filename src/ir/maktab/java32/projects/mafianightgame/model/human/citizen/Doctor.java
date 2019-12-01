package ir.maktab.java32.projects.mafianightgame.model.human.citizen;

import ir.maktab.java32.projects.mafianightgame.model.human.Human;

import java.util.List;

public class Doctor extends Citizen {
    private List<Human> humanList;
    private static Doctor doctor = null;

    private Doctor() {
    }

    public static Doctor getDoctor() {
        if (doctor == null) {
            doctor = new Doctor();
        }
        return doctor;
    }

    @Override
    public List<Human> getHumanList() {
        return humanList;
    }

    @Override
    public void setHumanList(List<Human> humanList) {
        this.humanList = humanList;
    }

    //return random human of humanList
    private Human save() {
        return null;
    }
}
