package ir.maktab.java32.projects.mafianightgame.model.god;

import ir.maktab.java32.projects.mafianightgame.model.human.Human;
import ir.maktab.java32.projects.mafianightgame.model.human.citizen.Citizen;
import ir.maktab.java32.projects.mafianightgame.model.human.citizen.Detective;
import ir.maktab.java32.projects.mafianightgame.model.human.citizen.Doctor;
import ir.maktab.java32.projects.mafianightgame.model.human.citizen.Sniper;
import ir.maktab.java32.projects.mafianightgame.model.human.mafia.Godfather;
import ir.maktab.java32.projects.mafianightgame.model.human.mafia.Mafia;
import ir.maktab.java32.projects.mafianightgame.model.human.mafia.Natasha;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class God {
    private static God god = null;

    private God() {
    }

    public static God getGod() {
        if (god == null) {
            god = new God();
        }
        return god;
    }

    private String sniperStatus;
    private String mafiasStatus;
    private String natashaStatus;

    public void night(List<Mafia> mafiaList, Godfather godFather, List<Citizen> citizenList, List<Human> humanList, Doctor doctor, Sniper sniper, Natasha natasha, Detective detective) {
        boolean mafiaCheck;
        List<Citizen> mafiasVote = new ArrayList<>();
        System.out.println("It is night please everyone sleep!");
        System.out.println("The godfather wake up");
        System.out.println("The mafias wake up");
        for (Mafia mafia : mafiaList) {
            mafiasVote.add(mafia.voteByMafia(citizenList));
        }
        Human killByMafia = godFather.kill(mafiasVote, mafiaList, humanList.size());
        System.out.println("The mafias sleep");
        System.out.println("The doctor wake up");
        Human saveDoctor = doctor.save(humanList);

        mafiaCheck = checkMafiaOrCitizen(mafiaList, killByMafia);

        if (!killByMafia.equals(saveDoctor)) {
            Human.deleteHumanById(humanList, killByMafia.getId());
            if (mafiaCheck)
                mafiasStatus = "The mafias killed one mafia and the doctor could not save her";
            else
                mafiasStatus = "The mafias killed one citizen and the doctor could not save her";
        } else {
            mafiasStatus = "The mafias could not killed human because the doctor could save her";
        }
        System.out.println("The doctor sleep");
        System.out.println("The detective wake up");

        Human detectiveGuess = detective.guess(humanList);

        List<Citizen> detectiveCitizens = new ArrayList<>();
        List<Mafia> detectiveMafias = new ArrayList<>();

        mafiaCheck = checkMafiaOrCitizen(mafiaList, detective);

        if (mafiaCheck) {
            detectiveMafias.add((Mafia) detectiveGuess);
        } else
            detectiveCitizens.add((Citizen) detectiveGuess);

        detective.setCitizenList(detectiveCitizens);
        detective.setMafiaList(detectiveMafias);

        System.out.println("The detective sleep");
        System.out.println("The sniper wake up");
        sniper.kill(humanList);

        mafiaCheck = checkMafiaOrCitizen(mafiaList, detectiveGuess);

        if (mafiaCheck) {
            sniperStatus = "mafia";
        } else
            sniperStatus = "citizen";

        System.out.println("The sniper sleep");

        System.out.println("Natasha wake up");
        Human natashaSilent = natasha.silent(citizenList);
        natashaStatus = "The natasha muted " + natashaSilent.getName();
    }

    public void day(List<Human> humanList) {
        List<Human> humanVote = new ArrayList<>();
        for (Human human : humanList) {
            humanVote.add(human.vote(humanList));
        }

        int getIdHumanForDeleteFromGame = getIdMostDuplicateName(humanVote);
        System.out.println("good bye " + Human.getHumanById(humanList, getIdHumanForDeleteFromGame).getName());
        Human.deleteHumanById(humanList, getIdHumanForDeleteFromGame);
        System.out.println("In the last night : " + mafiasStatus + " next " + sniperStatus + " finally " + natashaStatus);
    }

    public int getIdMostDuplicateName(List<Human> humanNames) {
        Map<Human, Integer> valueCounter = new HashMap<>();
        //Iterate all the elements from list and prepare HashMap, Key is List Elements and value is duplicate element occurences
        for (Human human : humanNames) {
            Integer val = valueCounter.get(human);
            if (valueCounter.get(human) == null) {
                valueCounter.put(human, 1); //if map does not contains key, put element with value 1
            } else {
                val = val + 1;//val++, ++val
                valueCounter.put(human, val); //increment counter if map already exists element
            }
        }

        int numberOfMostDuplicateName = valueCounter.values().stream()
                .collect(Collectors.summarizingInt(Integer::intValue)).getMax();

        Object[] id = valueCounter.entrySet().stream() //we can also use stream api to achieve the same
                .filter(map -> map.getValue() == numberOfMostDuplicateName).distinct().map(map -> map.getKey().getId()).toArray();

        return (int) id[0];
    }

    private boolean checkMafiaOrCitizen(List<Mafia> mafiaList, Human human) {
        boolean checkMafia = false;
        for (Mafia mafia : mafiaList) {
            if (mafia.getId().equals(human.getId())) {
                checkMafia = true;
                break;
            }
        }
        return checkMafia;
    }

    public boolean checkWinnerGame(List<Mafia> mafiaList, List<Citizen> citizenList) {
        if (mafiaList.size() == citizenList.size()) {
            System.out.println("The mafias winner this game.");
            return true;
        }

        if (mafiaList.size() == 0) {
            System.out.println("The citizens winner this game.");
            return true;
        }
        return false;
    }
}
