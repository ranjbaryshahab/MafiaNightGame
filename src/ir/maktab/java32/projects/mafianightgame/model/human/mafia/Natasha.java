package ir.maktab.java32.projects.mafianightgame.model.human.mafia;

import ir.maktab.java32.projects.mafianightgame.model.human.citizen.Citizen;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Natasha extends Mafia {
    private static Natasha natasha = null;

    private Natasha() {
    }

    public static Natasha getNatasha() {
        if (natasha == null) {
            natasha = new Natasha();
        }
        return natasha;
    }

    //Get citizen most message length and canBeTalk = false
    public Citizen silent(List<Citizen> citizenList) {
        //The list of length message of citizens
        List<Integer> lengthMessageList = new ArrayList<>();
        //Add length message of citizens in lengthMessageList.

        for (Citizen citizen : citizenList)
            lengthMessageList.add(citizen.getMessage().length());
        //Find max length of lengthMessageList.
        int maxLength = lengthMessageList.stream().max(Comparator.comparing(Integer::valueOf)).get();
        //Create talkative citizen.
        Citizen talkativeCitizen = null;
        //Find talkative citizen.
        for (Citizen citizen : citizenList)
            if (citizen.getMessage().length() == maxLength) {
                talkativeCitizen = citizen;
                break;
            }
        //Set canBeTalk property Talkative citizen equal false.
        talkativeCitizen.setCanBeTalk(false);
        return talkativeCitizen;
    }


}
