package ir.maktab.java32.projects.mafianightgame.model.human.citizen;

import ir.maktab.java32.projects.mafianightgame.model.human.Human;

import java.util.List;
import java.util.Random;

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
        //Selects a random human to know if he is mafia's target or not. (comment by Alireza)
        int randomIndex = new Random().nextInt(humanList.size()) + 1;

        //God will analyze doctor's choice and god decide to save someone or not. (comment by Alireza)
        return Human.getHumanById(humanList,randomIndex);
    }
}
