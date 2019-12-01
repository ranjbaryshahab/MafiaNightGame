package ir.maktab.java32.projects.mafianightgame.model.human.mafia;

import ir.maktab.java32.projects.mafianightgame.model.human.Human;

import java.util.List;

public class Godfather extends Mafia {
    private List<Human> mustBeKilled;
    private List<Human> humanList;
    private static Godfather godfather = null;

    private Godfather() {
    }

    public static Godfather getGodfather() {
        if (godfather == null) {
            godfather = new Godfather();
        }
        return godfather;
    }

    public List<Human> getMustBeKilled() {
        return mustBeKilled;
    }

    public void setMustBeKilled(List<Human> mustBeKilled) {
        this.mustBeKilled = mustBeKilled;
    }

    public List<Human> getHumanList() {
        return humanList;
    }

    public void setHumanList(List<Human> humanList) {
        this.humanList = humanList;
    }

    //Choose select random human of mustBeKilled and humanList
    public Human kill() {
        return null;
    }
}
