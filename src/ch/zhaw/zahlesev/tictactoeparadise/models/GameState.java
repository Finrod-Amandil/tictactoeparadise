package ch.zhaw.zahlesev.tictactoeparadise.models;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    private List<Player> players = new ArrayList<>(); 
    private ComputerDifficulty difficulty = ComputerDifficulty.EASY;
    private Board board;
    private Turn currentTurn;
    private List<Turn> history = new ArrayList<>();
    
    public GameState(List<Player> players, Board board) {
        this.players.addAll(players);
        this.board = board;
    }
    
    public void setDifficulty(ComputerDifficulty difficulty) {
        this.difficulty = difficulty;
    }
    
    public ComputerDifficulty getDifficulty() {
        return difficulty;
    }
    
    public Board getBoard() {
        return board;
    }
    
    public void setCurrentTurn(Turn turn, boolean doAddLastTurnToHistory) {
        if (doAddLastTurnToHistory && currentTurn != null) {
            history.add(currentTurn);
        }
        
        currentTurn = turn;
    }
    
    public Turn getCurrentTurn() {
        return currentTurn;
    }
    
    public List<Turn> getHistory() {
        return new ArrayList<>(history);
    }
}
