package ir.maktab.java32.projects.mafianightgame.model.human;

public abstract class Human {
    private Integer id;
    private String name;
    private boolean canBeTalk;
    private boolean alive;
    private String message;

    public String vote(){return null;}

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

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", canBeTalk=" + canBeTalk +
                ", alive=" + alive +
                ", message='" + message + '\'' +
                '}';
    }
}
