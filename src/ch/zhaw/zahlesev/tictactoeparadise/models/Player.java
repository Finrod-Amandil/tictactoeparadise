package ch.zhaw.zahlesev.tictactoeparadise.models;

public class Player {
    private boolean isComputer;
    private String name;
    private int score = 0;
    
    public Player(String name) {
        this.name = name;
        this.isComputer = false;
    }
    
    public Player(String name, boolean isComputer) {
        this.name = name;
        this.isComputer = isComputer;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean isComputer() {
        return isComputer;
    }
    
    public int getScore() {
        return score;
    }
    
    public void addPoint() {
        score++;
    }
}
