package ir.maktab.java32.projects.mafianightgame.model.god;

public class God {
    public static God god = null;
    private God(){
    }
    public static God getGod(){
        if(god == null){
            god = new God();
        }
        return god;
    }
}
