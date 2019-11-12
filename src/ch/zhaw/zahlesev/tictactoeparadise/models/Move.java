package ch.zhaw.zahlesev.tictactoeparadise.models;

public class Move {
    private Coordinates2D field;
    private char mark;
    
    public Move(Coordinates2D field, char mark) {
        this.field = field;
        this.mark = mark;
    }
    
    public Coordinates2D getField() {
        return field;
    }
    
    public char getMark() {
        return mark;
    }
}
