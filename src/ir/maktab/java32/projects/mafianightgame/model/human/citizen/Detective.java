package ir.maktab.java32.projects.mafianightgame.model.human.citizen;

import ir.maktab.java32.projects.mafianightgame.model.human.Human;
import ir.maktab.java32.projects.mafianightgame.model.human.mafia.Mafia;

import java.util.List;

public class Detective extends Citizen {
    private List<Human> humanList;
    private List<Mafia> mafiaList;
    private List<Citizen> citizenList;
    private static Detective detective = null;

    private Detective() {
    }

    public static Detective getDetective() {
        if (detective == null) {
            detective = new Detective();
        }
        return detective;
    }

    @Override
    public List<Human> getHumanList() {
        return humanList;
    }

    @Override
    public void setHumanList(List<Human> humanList) {
        this.humanList = humanList;
    }

    public List<Mafia> getMafiaList() {
        return mafiaList;
    }

    public void setMafiaList(List<Mafia> mafiaList) {
        this.mafiaList = mafiaList;
    }

    public List<Citizen> getCitizenList() {
        return citizenList;
    }

    public void setCitizenList(List<Citizen> citizenList) {
        this.citizenList = citizenList;
    }

    public static void setDetective(Detective detective) {
        Detective.detective = detective;
    }

    //Choose select random id from humanList and if it is mafia save in mafiaList else save in citizenList
    public void guess() {

    }
}
