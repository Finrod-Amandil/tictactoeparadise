package ch.zhaw.zahlesev.tictactoeparadise.models;

public class TurnResult {
    private TurnResultState state;
    private Player winner = null;
    private Tuple<Coordinates2D, Character> fieldToUpdate;
    private String message;
    private Turn nextTurn;
    
    public TurnResult(TurnResultState state) {
        this.state = state;
    }
    
    public void setState(TurnResultState state) {
        this.state = state;
    }
    
    public TurnResultState getState() {
        return state;
    }
    
    public void setWinner(Player player) {
        this.winner = player;
    }
    
    public Player getWinner() {
        return winner;
    }
    
    public void setFieldToUpdate(Coordinates2D field, char newMark) {
        this.fieldToUpdate = new Tuple<Coordinates2D, Character>(field, newMark);
    }
    
    public Tuple<Coordinates2D, Character> getFieldToUpdate() {
        return fieldToUpdate;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setNextTurn(Turn turn) {
        nextTurn = turn;
    }
    
    public Turn getNextTurn() {
        return nextTurn;
    }
}
