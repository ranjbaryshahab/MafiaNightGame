package ir.maktab.java32.projects.mafianightgame.model.human.mafia;

import ir.maktab.java32.projects.mafianightgame.model.human.Human;
import ir.maktab.java32.projects.mafianightgame.model.human.citizen.Citizen;

import java.util.List;
import java.util.Random;

/**
 * @author Shahab
 * @author Mohamad Hosein
 * @author Alireza
 */
@SuppressWarnings("Duplicates")
public class Godfather extends Mafia {

    private static Godfather godfather = null;

    private Godfather() {
    }

    public static Godfather getGodfather() {
        if (godfather == null) {
            godfather = new Godfather();
        }
        return godfather;
    }


    //Choose select random human of mustBeKilled and humanList
    public Human kill(List<Citizen> voteByMafia, List<Mafia> mafiaList, int date) {
        Human human;
        if (date > 9) {
            //Kill human
            human = voteByMafia.get(new Random().nextInt(voteByMafia.size()));
        } else {
            //kill mafia.
            human = mafiaList.get(new Random().nextInt(mafiaList.size()));
        }
        return human;
    }
}
