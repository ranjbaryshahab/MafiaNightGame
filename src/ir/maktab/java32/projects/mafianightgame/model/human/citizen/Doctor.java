package ir.maktab.java32.projects.mafianightgame.model.human.citizen;

import ir.maktab.java32.projects.mafianightgame.model.human.Human;

import java.util.List;
import java.util.Random;

/**
 * @author Shahab
 * @author Mohamad Hosein
 * @author Alireza
 */
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

    //Return random human of humanList
    public Human save(List<Human> humanList) {
        //God will analyze doctor's choice and god decide to save someone or not.
        return humanList.get(new Random().nextInt(humanList.size()));
    }
}
