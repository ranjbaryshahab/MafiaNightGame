package ir.maktab.java32.projects.mafianightgame.model.human;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public abstract class Human {
    private Integer id;
    private String name;
    private boolean canBeTalk;
    private String message;

    public Human vote(List<Human> humanList) {
        //Choose a random number of 1 until humanList size
        int humanRandomId = new Random().nextInt((humanList.size()-1))+1;
        //Getting human by id
        return Human.getHumanById(humanList, humanRandomId);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return isCanBeTalk() == human.isCanBeTalk() &&
                Objects.equals(getId(), human.getId()) &&
                Objects.equals(getName(), human.getName()) &&
                Objects.equals(getMessage(), human.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), isCanBeTalk(), getMessage());
    }
}
