package ch.zhaw.zahlesev.tictactoeparadise.models;

public class GameInitializationResult {
    private GameInitializationState state;
    private String message;
    
    public GameInitializationResult(GameInitializationState state) {
        this.state = state;
    }
    
    public GameInitializationState getState() {
        return state;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
