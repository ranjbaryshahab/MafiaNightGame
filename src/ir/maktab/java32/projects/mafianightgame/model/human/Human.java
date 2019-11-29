package ir.maktab.java32.projects.mafianightgame.model.human;

public abstract class Human {
    private Integer id;
    private String name;
    private boolean talk;
    private String message;

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

    public boolean isTalk() {
        return talk;
    }

    public void setTalk(boolean talk) {
        this.talk = talk;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
