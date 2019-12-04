package ir.maktab.java32.projects.mafianightgame;

import ir.maktab.java32.projects.mafianightgame.model.god.God;
import ir.maktab.java32.projects.mafianightgame.model.human.Human;
import ir.maktab.java32.projects.mafianightgame.model.human.citizen.Citizen;
import ir.maktab.java32.projects.mafianightgame.model.human.citizen.Detective;
import ir.maktab.java32.projects.mafianightgame.model.human.citizen.Doctor;
import ir.maktab.java32.projects.mafianightgame.model.human.citizen.Sniper;
import ir.maktab.java32.projects.mafianightgame.model.human.mafia.Godfather;
import ir.maktab.java32.projects.mafianightgame.model.human.mafia.Mafia;
import ir.maktab.java32.projects.mafianightgame.model.human.mafia.Natasha;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shahab
 * @author Mohamad Hosein
 * @author Alireza
 * @author Ali
 */
@SuppressWarnings("Duplicates")
public class MafiaGame {
    public static void main(String[] args) {
        //Create citizens
        Citizen citizen1 = new Citizen();
        Citizen citizen2 = new Citizen();
        Citizen citizen3 = new Citizen();
        Citizen citizen4 = new Citizen();
        Citizen citizen5 = new Citizen();
        Citizen citizen6 = new Citizen();
        Citizen citizen7 = new Citizen();
        Citizen citizen8 = new Citizen();
        Citizen citizen9 = new Citizen();
        Citizen citizen10 = new Citizen();
        Doctor doctor = Doctor.getDoctor();
        Sniper sniper = Sniper.getSniper();
        Detective detective = Detective.getDetective();

        //Create mafias
        Mafia mafia1 = new Mafia();
        Mafia mafia2 = new Mafia();
        Mafia mafia3 = new Mafia();
        Mafia mafia4 = new Mafia();
        Mafia mafia5 = new Mafia();
        Natasha natasha = Natasha.getNatasha();
        Godfather godfather = Godfather.getGodfather();

        //Citizen 1
        citizen1.setId(1);
        citizen1.setName("alireza");
        citizen1.setMessage("Im not a mafia");
        citizen1.setCanBeTalk(true);
        citizen1.setIdCitizen(1);

        //Citizen 2
        citizen2.setId(2);
        citizen2.setName("mohammadHosein");
        citizen2.setMessage("Im a citizen");
        citizen2.setCanBeTalk(true);
        citizen2.setIdCitizen(2);

        //Citizen 3
        citizen3.setId(3);
        citizen3.setName("shahab");
        citizen3.setMessage("Im know the mafia");
        citizen3.setCanBeTalk(true);
        citizen3.setIdCitizen(3);

        //Citizen 4
        citizen4.setId(4);
        citizen4.setName("poriya");
        citizen4.setMessage("Im not mafia");
        citizen4.setCanBeTalk(true);
        citizen4.setIdCitizen(4);

        //Citizen 5
        citizen5.setId(5);
        citizen5.setName("hamid");
        citizen5.setMessage("Im know the natasha");
        citizen5.setCanBeTalk(true);
        citizen5.setIdCitizen(5);

        //Citizen 6
        citizen6.setId(6);
        citizen6.setName("ali");
        citizen6.setMessage("Im a citizen");
        citizen6.setCanBeTalk(true);
        citizen6.setIdCitizen(6);

        //Citizen 7
        citizen7.setId(7);
        citizen7.setName("naser");
        citizen7.setMessage("Im not mafia");
        citizen7.setCanBeTalk(true);
        citizen7.setIdCitizen(7);

        //Citizen 8
        citizen8.setId(8);
        citizen8.setName("nader");
        citizen8.setMessage("Im know the godfather");
        citizen8.setCanBeTalk(true);
        citizen8.setIdCitizen(8);

        //Citizen 9
        citizen9.setId(9);
        citizen9.setName("marjan");
        citizen9.setMessage("Im not mafia");
        citizen9.setCanBeTalk(true);
        citizen9.setIdCitizen(9);

        //Citizen 10
        citizen10.setId(10);
        citizen10.setName("maryam");
        citizen10.setMessage("Im a citizen");
        citizen10.setCanBeTalk(true);
        citizen10.setIdCitizen(10);

        //Citizen 11 (doctor)
        doctor.setId(11);
        doctor.setName("setare");
        doctor.setMessage("I suspect to the ali");
        doctor.setCanBeTalk(true);
        doctor.setIdCitizen(11);

        //Citizen 12 (sniper)
        sniper.setId(12);
        sniper.setName("gholam");
        sniper.setMessage("Im not mafia");
        sniper.setCanBeTalk(true);
        sniper.setIdCitizen(12);

        //Citizen 13
        detective.setId(13);
        detective.setName("abbas");
        detective.setMessage("Im suspect the shahab");
        detective.setCanBeTalk(true);
        detective.setIdCitizen(13);

        //Mafia 1
        mafia1.setId(14);
        mafia1.setName("kamran");
        mafia1.setMessage("Im not mafia");
        mafia1.setCanBeTalk(true);
        mafia1.setIdMafia(1);

        //Mafia 2
        mafia2.setId(15);
        mafia2.setName("mina");
        mafia2.setMessage("Im suspect the abbas");
        mafia2.setCanBeTalk(true);
        mafia2.setIdMafia(2);

        //Mafia 3
        mafia3.setId(16);
        mafia3.setName("shila");
        mafia3.setMessage("Im a citizen");
        mafia3.setCanBeTalk(true);
        mafia3.setIdMafia(3);

        //Mafia 4
        mafia4.setId(17);
        mafia4.setName("hadi");
        mafia4.setMessage("Im not doctor");
        mafia4.setCanBeTalk(true);
        mafia4.setIdMafia(4);

        //Mafia 5
        mafia5.setId(18);
        mafia5.setName("sina");
        mafia5.setMessage("Im a citizen");
        mafia5.setCanBeTalk(true);
        mafia5.setIdMafia(5);

        //Mafia 6 (natasha)
        natasha.setId(19);
        natasha.setName("navid");
        natasha.setMessage("Im not godfather");
        natasha.setCanBeTalk(true);
        natasha.setIdMafia(6);

        //Mafia 7 (godfather)
        godfather.setId(20);
        godfather.setName("azhdar");
        godfather.setMessage("Im suspect the maryam");
        godfather.setCanBeTalk(true);
        godfather.setIdMafia(7);

        //Create humans list and add all human to the list.
        List<Human> humanList = new ArrayList<>();
        humanList.add(citizen1);
        humanList.add(citizen2);
        humanList.add(citizen3);
        humanList.add(citizen4);
        humanList.add(citizen5);
        humanList.add(citizen6);
        humanList.add(citizen7);
        humanList.add(citizen8);
        humanList.add(citizen9);
        humanList.add(citizen10);
        humanList.add(doctor);
        humanList.add(sniper);
        humanList.add(detective);
        humanList.add(mafia1);
        humanList.add(mafia2);
        humanList.add(mafia3);
        humanList.add(mafia4);
        humanList.add(mafia5);
        humanList.add(natasha);
        humanList.add(godfather);

        //Create citizens list and add all citizen in the list.
        List<Citizen> citizenList = new ArrayList<>();
        citizenList.add(citizen1);
        citizenList.add(citizen2);
        citizenList.add(citizen3);
        citizenList.add(citizen4);
        citizenList.add(citizen5);
        citizenList.add(citizen6);
        citizenList.add(citizen7);
        citizenList.add(citizen8);
        citizenList.add(citizen9);
        citizenList.add(citizen10);
        citizenList.add(doctor);
        citizenList.add(sniper);
        citizenList.add(detective);

        //Create mafias list and add all mafia in the list.
        List<Mafia> mafiaList = new ArrayList<>();
        mafiaList.add(mafia1);
        mafiaList.add(mafia2);
        mafiaList.add(mafia3);
        mafiaList.add(mafia4);
        mafiaList.add(mafia5);
        mafiaList.add(natasha);
        mafiaList.add(godfather);

        //Create god
        God god = God.getGod();

        //In the while check if winner is false repeat it.
        System.out.println("*************************************************************************");
        while (!god.checkWinnerGame(mafiaList, citizenList)) {
            god.night(humanList, citizenList, mafiaList, godfather, doctor, sniper, detective, natasha);
            god.day(humanList, mafiaList, citizenList, detective);
            System.out.println("*************************************************************************");
        }
        //Show information about winners game.
        System.out.println(god.getWinnerMessage());


    }
}
