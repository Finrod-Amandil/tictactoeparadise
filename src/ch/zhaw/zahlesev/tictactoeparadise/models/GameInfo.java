package ch.zhaw.zahlesev.tictactoeparadise.models;

public class GameInfo {
    private String title;
    private String description;
    
    public GameInfo(String title, String description) {
        this.title = title;
        this.description= description;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }
}
