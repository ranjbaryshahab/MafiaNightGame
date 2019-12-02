package ir.maktab.java32.projects.mafianightgame.model.human.mafia;

import ir.maktab.java32.projects.mafianightgame.model.human.Human;
import ir.maktab.java32.projects.mafianightgame.model.human.citizen.Citizen;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Mafia extends Human {
    private Integer idMafia;

    public Integer getIdMafia() {
        return idMafia;
    }

    public void setIdMafia(Integer idMafia) {
        this.idMafia = idMafia;
    }

    public static Mafia getMafiaById(List<Mafia> mafiaList, int id) {
        for (Mafia mafia : mafiaList) {
            if (mafia.getIdMafia().equals(id))
                return mafia;
        }
        return null;
    }


    public static void deleteMafiaById(List<Mafia> mafiaList, int id) {
        mafiaList.remove(getMafiaById(mafiaList, id));
    }

    //Every night mafias choose one of humanList for kill
    public Citizen voteByMafia(List<Citizen> citizenList) {
        //Choose a random number of 1 until citizenList size
        int citizenRandomId = new Random().nextInt(citizenList.size() ) + 1;

        //Getting citizen by id
        return Citizen.getCitizenById(citizenList, citizenRandomId);
    }

    @Override
    public String toString() {
        return "Mafia{" +
                "idMafia=" + idMafia +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mafia)) return false;
        if (!super.equals(o)) return false;
        Mafia mafia = (Mafia) o;
        return Objects.equals(getIdMafia(), mafia.getIdMafia());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getIdMafia());
    }

}
