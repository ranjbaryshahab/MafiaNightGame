package ir.maktab.java32.projects.mafianightgame.model.human.mafia;

import ir.maktab.java32.projects.mafianightgame.model.human.Human;
import ir.maktab.java32.projects.mafianightgame.model.human.citizen.Citizen;

import java.util.List;

public class Mafia extends Human {
    private Integer idMafia;
    private List<Citizen> citizens;
    private List<Mafia> mafias;

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

    public List<Mafia> getMafias() {
        return mafias;
    }

    public void setMafias(List<Mafia> mafias) {
        this.mafias = mafias;
    }

    //Every night mafias choose one of humanList for kill
    public Human voteByMafia() {
        return null;
    }
}
