package ir.maktab.java32.projects.mafianightgame.model.human.mafia;

import ir.maktab.java32.projects.mafianightgame.model.human.Human;

import java.util.List;
import java.util.Random;

public class Mafia extends Human {
    private Integer idMafia;

    public Integer getIdMafia() {
        return idMafia;
    }

    public void setIdMafia(Integer idMafia) {
        this.idMafia = idMafia;
    }

    //Every night mafias choose one of humanList for kill
    public Human voteByMafia(List<Human> humanList) {
        Random random = new Random();
        //Choose a random number of 1 until humanList size
        int humanRandomId = random.nextInt((humanList.size() - 1)) + 1;
        //This condition check class type and list size < 10
        if (Human.getHumanById(humanList, humanRandomId).getClass().getSimpleName().equals("Mafia") && humanList.size() < 10) {
            return Human.getHumanById(humanList, humanRandomId);
        } else {
            humanRandomId = random.nextInt((humanList.size() - 1)) + 1;
        }
        return Human.getHumanById(humanList, humanRandomId);
    }
}
