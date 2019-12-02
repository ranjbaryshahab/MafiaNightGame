package ir.maktab.java32.projects.mafianightgame.model.human.citizen;

import ir.maktab.java32.projects.mafianightgame.model.human.Human;
import ir.maktab.java32.projects.mafianightgame.model.human.mafia.Mafia;

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

    public static void deleteCitizenById(List<Citizen> citizenList, int id) {
        citizenList.remove(getCitizenById(citizenList, id));
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
