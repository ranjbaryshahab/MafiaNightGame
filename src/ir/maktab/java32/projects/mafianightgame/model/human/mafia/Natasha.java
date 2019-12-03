package ir.maktab.java32.projects.mafianightgame.model.human.mafia;

import ir.maktab.java32.projects.mafianightgame.model.human.Human;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Shahab
 * @author Mohamad Hosein
 * @author Alireza
 */
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

    //Get humans most message length and canBeTalk = false
    public Human silent(List<Human> humanList) {
        //The list of length message of humans
        List<Integer> lengthMessageList = new ArrayList<>();

        //Add length message of humans in lengthMessageList.
        for (Human human : humanList)
            lengthMessageList.add(human.getMessage().length());

        //Find max length of lengthMessageList.
        boolean isPresent = lengthMessageList.stream().max(Comparator.comparing(Integer::valueOf)).isPresent();
        int maxLength = 0;
        if (isPresent)
            maxLength = lengthMessageList.stream().max(Comparator.comparing(Integer::valueOf)).get();
        //Create talkative human.
        Human talkativeHuman = null;

        //Find talkative human.
        for (Human human : humanList)
            if (human.getMessage().length() == maxLength) {
                talkativeHuman = human;
                break;
            }

        //Set canBeTalk property Talkative human equal false.
        talkativeHuman.setCanBeTalk(false);
        return talkativeHuman;
    }


}
