package ir.maktab.java32.projects.mafianightgame.model.human.citizen;

import ir.maktab.java32.projects.mafianightgame.model.human.Human;

import java.util.List;
import java.util.Random;

public class Citizen extends Human {
    private Integer idCitizen;
    private List<Human> humanList;

    public Integer getIdCitizen() {
        return idCitizen;
    }

    public void setIdCitizen(Integer idCitizen) {
        this.idCitizen = idCitizen;
    }

    public List<Human> getHumanList() {
        return humanList;
    }

    public void setHumanList(List<Human> humanList) {
        this.humanList = humanList;
    }

    Random humanLIstRandom = new Random();

    @Override
    public List<String> vote() {
        List<Human> backFromVote = null;
       // String message = null;
        List<String> listMessageFromVote = null;
        //return a random variable from humanList to make vote per humanList member(size)
        for(int i = 0; i<= humanList.size();i++) {
            Human randomElement = humanList.get(humanLIstRandom.nextInt(humanList.size()));
            randomElement.setMessage("in my mind the (%d) is mafia member" + randomElement.getId());
            listMessageFromVote.add(randomElement.getMessage())  ;
            backFromVote.add(randomElement);
        }

        return listMessageFromVote;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "idCitizen=" + idCitizen +
                ", humanList=" + humanList +
                ", humanLIstRandom=" + humanLIstRandom +
                '}';
    }
}
