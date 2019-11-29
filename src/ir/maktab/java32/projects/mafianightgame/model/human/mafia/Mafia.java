package ir.maktab.java32.projects.mafianightgame.model.human.mafia;

import ir.maktab.java32.projects.mafianightgame.model.human.Human;
import ir.maktab.java32.projects.mafianightgame.model.human.citizen.Citizen;

import java.util.List;

public class Mafia extends Human {
    private Integer idMafia;
    private List<Citizen> citizens;

    public Integer getIdMafia() {
        return idMafia;
    }

    public void setIdMafia(Integer idMafia) {
        this.idMafia = idMafia;
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public void setCitizens(List<Citizen> citizens) {
        this.citizens = citizens;
    }

    public String voteByMafia(){
        return null;
    }
}
