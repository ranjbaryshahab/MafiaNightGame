package ir.maktab.java32.projects.mafianightgame.model.human.citizen;

import ir.maktab.java32.projects.mafianightgame.model.human.Human;

import java.util.List;
import java.util.Random;

public class Citizen extends Human {

    private Integer idCitizen;

    public Integer getIdCitizen() {
        return idCitizen;
    }

    public void setIdCitizen(Integer idCitizen) {
        this.idCitizen = idCitizen;
    }

    Random random = new Random();


    @Override
    //Return a random variable from humanList to make vote per humanList member(size)
    public Human vote(List<Human> humanList) {
        Human randomElement = null;
        //Choose a random number of 1 until humanList size
        int humanRandomId = random.nextInt((humanList.size() - 1)) + 1;
        //Getting human by id
        return Human.getHumanById(humanList, humanRandomId);
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "idCitizen=" + idCitizen +
                "} " + super.toString();
    }
}
