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


    //return random human of humanList
    public Human save(List<Human> humanList) {

        //determines given list's size. (comment by Alireza)
        int humansCount = humanList.size();

        //selects a random human to know if he is mafia's target or not. (comment by Alireza)
        int randomIndex = new Random().nextInt(humansCount);
        Human randomHuman = humanList.get(randomIndex);

        return randomHuman;

        //god will analyze doctor's choice and god decide to save someone or not. (comment by Alireza)
    }
}
