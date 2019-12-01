package ir.maktab.java32.projects.mafianightgame.model.human;

import java.util.List;

public abstract class Human {
    private Integer id;
    private String name;
    private boolean canBeTalk;
    private String message;

    public Human vote(List<Human> humanList) {
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isCanBeTalk() {
        return canBeTalk;
    }

    public void setCanBeTalk(boolean canBeTalk) {
        this.canBeTalk = canBeTalk;
    }

    //Get human by id with humanRandomId number
    public static Human getHumanById(List<Human> humanList, int id) {
        for (Human human : humanList) {
            if (human.getId().equals(id))
                return human;
        }
        return null;
    }

    //This method prints the humanList
    public static void printAllHumanList(List<Human> humanList) {
        humanList.forEach(System.out::println);
    }

    //This method delete human of humanList
    public static void deleteHumanById(List<Human> humanList, int id) {
        humanList.remove(getHumanById(humanList, id));
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", canBeTalk=" + canBeTalk +
                ", message='" + message + '\'' +
                '}';
    }
}
