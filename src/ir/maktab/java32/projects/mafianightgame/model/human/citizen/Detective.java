package ir.maktab.java32.projects.mafianightgame.model.human.citizen;

import ir.maktab.java32.projects.mafianightgame.model.human.Human;
import ir.maktab.java32.projects.mafianightgame.model.human.mafia.Mafia;

import java.util.List;
import java.util.Random;

/**
 * @author Shahab
 * @author Mohamad Hosein
 * @author Alireza
 */
public class Detective extends Citizen {
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

    //Choose select random id from humanList and if it is mafia save in mafiaList else save in citizenList
    public Human guess(List<Human> humanList) {
        //selects a 'random human' to know if he is mafia or not.
        return humanList.get(new Random().nextInt(humanList.size()));
    }
}
