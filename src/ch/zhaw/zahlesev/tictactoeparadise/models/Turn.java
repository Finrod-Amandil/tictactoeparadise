package ch.zhaw.zahlesev.tictactoeparadise.models;

import java.util.HashSet;
import java.util.Set;

public class Turn {
    private Player player;
    private Set<Move> validMoves = new HashSet<>();
    
    //The move which the player selected
    private Move move;
    
    public Turn(Player player) {
        this.player = player;
    }
    
    public void addValidMove(Coordinates2D field, char mark) {
        validMoves.add(new Move(field, mark));
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public Set<Move> getValidMoves() {
        return new HashSet<>(validMoves);
    }
    
    public Move getMove() {
        return move;
    }
}
