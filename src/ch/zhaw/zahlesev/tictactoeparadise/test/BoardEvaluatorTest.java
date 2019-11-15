package ch.zhaw.zahlesev.tictactoeparadise.test;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import ch.zhaw.zahlesev.tictactoeparadise.common.BoardEvaluator;
import ch.zhaw.zahlesev.tictactoeparadise.models.Board;

public class BoardEvaluatorTest {
    
    private static final char NIL = '\u0000';
    private static List<Character> validMarks = Arrays.asList('X', 'O');
    
    
    @Test
    public void hasBoardNInARow_WithHorizontalRowAndBoard3x3_ShouldReturnTrue() {
        //Arrange
        BoardEvaluator boardEvaluator = new BoardEvaluator();
        Board board = new Board(3, 3, validMarks);
        char mark = 'X';
        int n = 3;
        List<List<Character>> fields = Arrays.asList(
                Arrays.asList('O', NIL, 'O'),
                Arrays.asList('X', 'X', 'X'),
                Arrays.asList('X', 'O', 'O'));
        
        setBoardFields(fields, board);
        
        boolean expectedResult = true;
        
        //Act
        boolean result = boardEvaluator.hasBoardNInARow(board, mark, n);
        
        //Assert
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void hasBoardNInARow_WithVerticalRowAndBoard3x3_ShouldReturnTrue() {
        //Arrange
        BoardEvaluator boardEvaluator = new BoardEvaluator();
        Board board = new Board(3, 3, validMarks);
        char mark = 'X';
        int n = 3;
        List<List<Character>> fields = Arrays.asList(
                Arrays.asList('X', NIL, 'O'),
                Arrays.asList('X', 'O', NIL),
                Arrays.asList('X', NIL, 'O'));
        
        setBoardFields(fields, board);
        
        boolean expectedResult = true;
        
        //Act
        boolean result = boardEvaluator.hasBoardNInARow(board, mark, n);
        
        //Assert
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void hasBoardNInARow_WithDiagonalTLBRRowAndBoard3x3_ShouldReturnTrue() {
        //Arrange
        BoardEvaluator boardEvaluator = new BoardEvaluator();
        Board board = new Board(3, 3, validMarks);
        char mark = 'X';
        int n = 3;
        List<List<Character>> fields = Arrays.asList(
                Arrays.asList('X', 'O', 'O'),
                Arrays.asList('X', 'X', 'O'),
                Arrays.asList('O', NIL, 'X'));
        
        setBoardFields(fields, board);
        
        boolean expectedResult = true;
        
        //Act
        boolean result = boardEvaluator.hasBoardNInARow(board, mark, n);
        
        //Assert
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void hasBoardNInARow_WithDiagonalTRBLRowAndBoard3x3_ShouldReturnTrue() {
        //Arrange
        BoardEvaluator boardEvaluator = new BoardEvaluator();
        Board board = new Board(3, 3, validMarks);
        char mark = 'X';
        int n = 3;
        List<List<Character>> fields = Arrays.asList(
                Arrays.asList('O', 'O', 'X'),
                Arrays.asList('X', 'X', 'O'),
                Arrays.asList('X', NIL, 'O'));
        
        setBoardFields(fields, board);
        
        boolean expectedResult = true;
        
        //Act
        boolean result = boardEvaluator.hasBoardNInARow(board, mark, n);
        
        //Assert
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void hasBoardNInARow_WithNoRowAndBoard3x3_ShouldReturnFalse() {
        //Arrange
        BoardEvaluator boardEvaluator = new BoardEvaluator();
        Board board = new Board(3, 3, validMarks);
        char mark = 'X';
        int n = 3;
        List<List<Character>> fields = Arrays.asList(
                Arrays.asList('O', 'O', 'X'),
                Arrays.asList('X', 'O', 'O'),
                Arrays.asList('O', 'X', 'X'));
        
        setBoardFields(fields, board);
        
        boolean expectedResult = false;
        
        //Act
        boolean result = boardEvaluator.hasBoardNInARow(board, mark, n);
        
        //Assert
        assertEquals(expectedResult, result);
    }
    
    private void setBoardFields(List<List<Character>> fields, Board board) {
        for (int col = 0; col < fields.size(); col++) {
            for (int row = 0; row < fields.get(0).size(); row++) {
                board.setField(col, row, fields.get(col).get(row));
            }
        }
    }
}
