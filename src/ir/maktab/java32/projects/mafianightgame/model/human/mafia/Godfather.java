package ir.maktab.java32.projects.mafianightgame.model.human.mafia;

import ir.maktab.java32.projects.mafianightgame.model.human.Human;
import ir.maktab.java32.projects.mafianightgame.model.human.citizen.Citizen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

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
    public Human kill(List<Citizen> voteByMafia, List<Mafia> mafiaList, int round) {
        Human human = null;
        if (round > 9) {
            int id = getIdMostDuplicateName(voteByMafia);
            human = Citizen.getCitizenById(voteByMafia, id);
        } else {
            int mafiaRandomId = new Random().nextInt((mafiaList.size() - 1)) + 1;

            //Getting mafia by id
            human = Mafia.getMafiaById(mafiaList, mafiaRandomId);
        }
        return human;
    }


    private int getIdMostDuplicateName(List<Citizen> citizenList) {
        Map<Citizen, Integer> valueCounter = new HashMap<>();
        //Iterate all the elements from list and prepare HashMap, Key is List Elements and value is duplicate element occurences
        for (Citizen citizen : citizenList) {
            Integer val = valueCounter.get(citizen);
            if (valueCounter.get(citizen) == null) {
                valueCounter.put(citizen, 1); //if map does not contains key, put element with value 1
            } else {
                val = val + 1;//val++, ++val
                valueCounter.put(citizen, val); //increment counter if map already exists element
            }
        }

        int numberOfMostDuplicateName = valueCounter.values().stream()
                .collect(Collectors.summarizingInt(Integer::intValue)).getMax();

        Object[] id = valueCounter.entrySet().stream() //we can also use stream api to achieve the same
                .filter(map -> map.getValue() == numberOfMostDuplicateName).distinct().map(map -> map.getKey().getIdCitizen()).toArray();


        return (int) id[0];
    }
}
