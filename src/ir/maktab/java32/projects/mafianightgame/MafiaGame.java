package ir.maktab.java32.projects.mafianightgame;

import ir.maktab.java32.projects.mafianightgame.model.human.Human;
import ir.maktab.java32.projects.mafianightgame.model.human.citizen.Citizen;
import ir.maktab.java32.projects.mafianightgame.model.human.citizen.Doctor;
import ir.maktab.java32.projects.mafianightgame.model.human.citizen.Sniper;

import java.util.ArrayList;
import java.util.List;

public class MafiaGame {
    public static void main(String[] args) {
        Citizen citizen1 = new Citizen();
        Citizen citizen2 = new Citizen();
        Citizen citizen3 = new Citizen();
        Citizen citizen4 = new Citizen();
        Citizen citizen5 = new Citizen();
        Citizen citizen6 = new Citizen();
        Citizen citizen7 = new Citizen();
        Citizen citizen8 = new Citizen();
        Doctor doctor = Doctor.getDoctor();
        Sniper sniper = Sniper.getSniper();

        List<Human> humanList = new ArrayList<>();

        humanList.add(citizen1);
        humanList.add(citizen2);
        humanList.add(citizen3);
        humanList.add(citizen4);
        humanList.add(citizen5);
        humanList.add(citizen6);
        humanList.add(citizen7);
        humanList.add(citizen8);
        humanList.add(sniper);
        humanList.add(doctor);


        citizen1.setId(1);
        citizen1.setName("ali");
        citizen1.setCanBeTalk(true);
        citizen1.setIdCitizen(1);

        citizen2.setId(2);
        citizen2.setName("shahab");
        citizen2.setCanBeTalk(true);
        citizen2.setIdCitizen(2);

        citizen3.setId(3);
        citizen3.setName("hassan");
        citizen3.setCanBeTalk(true);
        citizen3.setIdCitizen(3);

        citizen4.setId(4);
        citizen4.setName("milad");
        citizen4.setCanBeTalk(true);
        citizen4.setIdCitizen(4);

        citizen5.setId(5);
        citizen5.setName("mohsen");
        citizen5.setCanBeTalk(true);
        citizen5.setIdCitizen(5);

        citizen6.setId(6);
        citizen6.setName("hadi");
        citizen6.setCanBeTalk(true);
        citizen6.setIdCitizen(6);

        citizen7.setId(7);
        citizen7.setName("mohamad hosein");
        citizen7.setCanBeTalk(true);
        citizen7.setIdCitizen(7);

        citizen8.setId(8);
        citizen8.setName("alireza");
        citizen8.setCanBeTalk(true);
        citizen8.setIdCitizen(8);


        doctor.setId(9);
        doctor.setName("mahdi");
        doctor.setCanBeTalk(true);
        doctor.setIdCitizen(9);

        sniper.setId(10);
        sniper.setName("azhdar");
        sniper.setCanBeTalk(true);
        sniper.setIdCitizen(10);


        //Prints humanList
        Human.printAllHumanList(humanList);

        citizen1.setMessage("In my mind the " + citizen1.vote(humanList).getName() + " is mafia member");
        System.out.println(citizen1.getMessage());

        Human killBySniper = sniper.kill(humanList);
        System.out.println("The last night sniper killed " + killBySniper.getName());

        //Prints humanList
        Human.printAllHumanList(humanList);


    }
}
