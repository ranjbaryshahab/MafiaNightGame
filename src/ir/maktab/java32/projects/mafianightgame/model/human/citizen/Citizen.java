package ir.maktab.java32.projects.mafianightgame.model.human.citizen;

import ir.maktab.java32.projects.mafianightgame.model.human.Human;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Citizen extends Human {

    private Integer idCitizen;

    public Integer getIdCitizen() {
        return idCitizen;
    }

    public void setIdCitizen(Integer idCitizen) {
        this.idCitizen = idCitizen;
    }

    public static Citizen getCitizenById(List<Citizen> citizenList, int id) {
        for (Citizen citizen : citizenList) {
            if (citizen.getIdCitizen().equals(id))
                return citizen;
        }
        return null;
    }


    @Override
    //Return a random variable from humanList to make vote per humanList member(size)
    public Human vote(List<Human> humanList) {
        Human randomElement = null;
        //Choose a random number of 1 until humanList size
        int humanRandomId = new Random().nextInt((humanList.size() - 1)) + 1;
        //Getting human by id
        return Human.getHumanById(humanList, humanRandomId);
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "idCitizen=" + idCitizen +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Citizen)) return false;
        if (!super.equals(o)) return false;
        Citizen citizen = (Citizen) o;
        return Objects.equals(getIdCitizen(), citizen.getIdCitizen());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getIdCitizen());
    }
}
