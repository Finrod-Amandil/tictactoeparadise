package ch.zhaw.zahlesev.tictactoeparadise.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final char EMPTY_FIELD = '\u0000';
    
    private final Coordinates2D boardDimensions;
    private List<Character> validMarks = new ArrayList<>();
    private List<List<Character>> fields;
    
    public Board(Coordinates2D boardDimensions, List<Character> validMarks) {
        this.boardDimensions = boardDimensions;
        this.validMarks.addAll(validMarks);
        
        initializeBoard();
    }
    
    private void initializeBoard() {
        fields = new ArrayList<>();
        for (int x = 0; x < boardDimensions.x; x++) {
            fields.add(new ArrayList<>());
            for (int y = 0; y < boardDimensions.y; y++) {
                fields.get(x).add(EMPTY_FIELD);
            }
        }
    }
    
    public Coordinates2D getBoardDimensions() {
        return boardDimensions;
    }
    
    public int getHeight() {
        return boardDimensions.y;
    }
    
    public int getWidth() {
        return boardDimensions.x;
    }
    
    public char getField(Coordinates2D coordinates) {
        return fields.get(coordinates.x).get(coordinates.y);
    }
    
    public List<Character> getValidMarks() {
        return new ArrayList<>(validMarks);
    }
}
