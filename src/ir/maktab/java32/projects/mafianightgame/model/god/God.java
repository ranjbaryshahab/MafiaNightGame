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

/**
 * @author Shahab
 * @author Mohamad Hosein
 * @author Alireza
 */
public class God {
    private static God god = null;
    private String sniperStatus = "";
    private String mafiasStatus = "";
    private String natashaStatus = "";
    private String winnerMessage = "";
    private List<Citizen> mafiasVote = new ArrayList<>();
    private List<Citizen> detectiveCitizens = new ArrayList<>();
    private List<Mafia> detectiveMafias = new ArrayList<>();
    private boolean mafiaCheck;
    private int date = 1;

    //Private constructor because this class is singleton and in the game we have just 1 god.
    private God() {
    }

    public static God getGod() {
        if (god == null) {
            god = new God();
        }
        return god;
    }

    public String getWinnerMessage() {
        return winnerMessage;
    }


    //Things that happen at night
    public void night(List<Human> humanList, List<Citizen> citizenList, List<Mafia> mafiaList, Godfather godfather, Doctor doctor, Sniper sniper, Detective detective, Natasha natasha) {
        System.out.println("------------------------------------------------------");
        System.out.print("It`s night (" + date + ") : please everyone sleep!");
        Human kill = mafiasWakeUp(humanList, citizenList, mafiaList, godfather);
        doctorWakeUp(humanList, citizenList, mafiaList, doctor, kill);
        sniperWakeUp(humanList, citizenList, mafiaList, sniper);
        detectiveWakeUp(humanList, mafiaList, detective);
        natashaWakeUp(humanList, natasha);
    }

    //Things that happen at day
    public void day(List<Human> humanList, List<Mafia> mafiaList, List<Citizen> citizenList, Detective detective) {
        System.out.println("------------------------------------------------------");
        System.out.println("It`s day (" + date + ") :");
        showInformation();
        printListOfMessagesPlayer(humanList);
        humanWakeUp(humanList, mafiaList, citizenList);
        printListOfPlayersName(humanList);
        printNumberOfPlayers(citizenList, mafiaList);
        showDetectiveMemory(detective);
        date++;
        System.out.println("------------------------------------------------------");
    }

    //Show information about last night.
    private void showInformation() {
        System.out.println("In the last night : " + mafiasStatus + " next " + sniperStatus + " finally " + natashaStatus);
    }

    //Natasha wake up and silent a human.
    private void natashaWakeUp(List<Human> humanList, Natasha natasha) {
        System.out.println("\tNatasha wake up");
        Human natashaSilent = natasha.silent(humanList);
        natashaStatus = "the natasha muted " + natashaSilent.getName();
    }

    //Sniper wake up and if number of date == 10 kill a human.
    private void sniperWakeUp(List<Human> humanList, List<Citizen> citizenList, List<Mafia> mafiaList, Sniper sniper) {
        System.out.println("\tThe sniper wake up");

        if (humanList.size() == 10) {
            Human sniperKilled = sniper.kill(humanList);
            mafiaCheck = checkMafiaOrCitizen(mafiaList, sniperKilled);
            if (sniperKilled != null) {
                Human.deleteHumanById(humanList, sniperKilled.getId());
                if (mafiaCheck) {
                    sniperStatus = "The sniper killed a mafia";
                    Mafia.deleteMafiaById(mafiaList, sniperKilled.getId());
                } else {
                    sniperStatus = "The sniper killed a citizen";
                    Citizen.deleteCitizenById(citizenList, sniperKilled.getId());
                }
            } else
                sniperStatus = "The sniper said, i dont want kill anybody";
        }
        System.out.println("\tThe sniper sleep");
    }

    //Humans wake up and vote a human for delete of game.
    private void humanWakeUp(List<Human> humanList, List<Mafia> mafiaList, List<Citizen> citizenList) {
        List<Human> humanVote = new ArrayList<>();
        for (Human human : humanList) {
            humanVote.add(human.vote(humanList));
        }

        int getIdHumanForDeleteFromGame = getIdMostDuplicateName(humanVote);
        Human delete = Human.getHumanById(humanList, getIdHumanForDeleteFromGame);
        boolean checkMafia = checkMafiaOrCitizen(mafiaList, delete);
        if (checkMafia) {
            Mafia.deleteMafiaById(mafiaList, delete.getId());
        } else {
            Citizen.deleteCitizenById(citizenList, delete.getId());
        }
        Human.deleteHumanById(humanList, getIdHumanForDeleteFromGame);
        System.out.println("\tThe human voted for delete " + delete.getName() + " of game, so good bye!");
    }

    //Detective wake up and guess a random human and god give information about her and detective save it on memory.
    private void detectiveWakeUp(List<Human> humanList, List<Mafia> mafiaList, Detective detective) {
        System.out.println("\tThe detective wake up");
        Human detectiveGuess = detective.guess(humanList);

        mafiaCheck = checkMafiaOrCitizen(mafiaList, detectiveGuess);

        if (mafiaCheck) {
            detectiveMafias.add((Mafia) detectiveGuess);
        } else
            detectiveCitizens.add((Citizen) detectiveGuess);

        detective.setCitizenList(detectiveCitizens);
        detective.setMafiaList(detectiveMafias);

        System.out.println("\tThe detective sleep");
    }

    //Mafias wake up and vote a citizen for kill and godfather kill her.
    private Human mafiasWakeUp(List<Human> humanList, List<Citizen> citizenList, List<Mafia> mafiaList, Godfather godfather) {
        System.out.println("\tThe godfather wake up");
        System.out.println("\tThe mafias wake up");

        for (Mafia mafia : mafiaList) {
            mafiasVote.add(mafia.voteByMafia(citizenList));
        }

        Human killByMafia = godfather.kill(mafiasVote, mafiaList, humanList.size());
        System.out.println("\tThe mafias sleep");
        return killByMafia;
    }

    //Doctor wake up and guess a random human for save, if killed human by godfather is equal her, doctor save her.
    private void doctorWakeUp(List<Human> humanList, List<Citizen> citizenList, List<Mafia> mafiaList, Doctor doctor, Human killByMafia) {
        System.out.println("\tThe doctor wake up");
        Human saveDoctor = doctor.save(humanList);

        mafiaCheck = checkMafiaOrCitizen(mafiaList, killByMafia);

        if (!killByMafia.equals(saveDoctor)) {
            Human.deleteHumanById(humanList, killByMafia.getId());
            if (mafiaCheck) {
                Mafia.deleteMafiaById(mafiaList, killByMafia.getId());
                mafiasStatus = "the mafias killed one mafia and the doctor could not save her";
            } else {
                mafiasStatus = "the mafias killed one citizen and the doctor could not save her";
                Citizen.deleteCitizenById(citizenList, killByMafia.getId());
            }
        } else
            mafiasStatus = "the mafias could not killed human because the doctor could save her";

        System.out.println("\tThe doctor sleep");
    }

    //Choose id of most duplicate name in the list
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

    //Get human and check her equal citizen or mafia and return it.
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


    //God check winner in the game.
    public boolean checkWinnerGame(List<Mafia> mafiaList, List<Citizen> citizenList) {
        if (mafiaList.size() == citizenList.size()) {
            winnerMessage = "The mafias winner this game.";
            return true;
        }

        if (mafiaList.size() == 0) {
            winnerMessage = "The citizens winner this game.";
            return true;
        }
        return false;
    }

    //Print list of players name.
    private void printListOfPlayersName(List<Human> humanList) {
        StringBuilder names = new StringBuilder("\tPlayers List {");
        for (int i = 0; i < humanList.size(); i++) {
            Human human = humanList.get(i);
            String role = human.getClass().getSimpleName();
            names.append(human.getName()).append("(").append(role).append(")");
            if (i != humanList.size() - 1)
                names.append(",");
            else
                names.append("}");
        }
        System.out.println(names);
    }

    //Print list of message player.
    private void printListOfMessagesPlayer(List<Human> humanList) {
        for (Human human : humanList) {
            String role = human.getClass().getSimpleName();
            if (human.isCanBeTalk()) {
                System.out.println("\t" + human.getName() + " (" + role + ")" + ": " + human.getMessage());
            } else {
                System.out.println("\t" + human.getName() + " (" + role + ")" + ": " + "mmmmmmmmmmmmmmmmmmmmmmmmmm");
            }
        }
    }

    //Print number of players in the all game.
    private void printNumberOfPlayers(List<Citizen> citizenList, List<Mafia> mafiaList) {
        System.out.println("\tMafias number in the game = " + mafiaList.size() + ", citizens number in the game = " + citizenList.size());
    }

    //Show detective`s memory
    private void showDetectiveMemory(Detective detective) {
        List<Mafia> mafiaList = detective.getMafiaList();
        List<Citizen> citizenList = detective.getCitizenList();
        StringBuilder citizenMemory = new StringBuilder("\tThe citizen in detective`s memory : {");
        StringBuilder mafiaMemory = new StringBuilder("\tThe citizen in detective`s memory : {");

        for (int i = 0; i < citizenList.size(); i++) {
            Citizen citizen = citizenList.get(i);
            citizenMemory.append(citizen.getName());
            if (i != citizenList.size() - 1)
                citizenMemory.append(",");
            else
                citizenMemory.append("}");
        }

        for (int i = 0; i < mafiaList.size(); i++) {
            Mafia mafia = mafiaList.get(i);
            mafiaMemory.append(mafia.getName());
            if (i != mafiaList.size() - 1)
                mafiaMemory.append(",");
            else
                mafiaMemory.append("}");
        }

        System.out.println(mafiaMemory);
        System.out.println(citizenMemory);
    }
}
