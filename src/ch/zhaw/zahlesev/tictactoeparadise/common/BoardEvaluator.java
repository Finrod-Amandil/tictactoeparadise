package ch.zhaw.zahlesev.tictactoeparadise.common;

import java.util.ArrayList;
import java.util.List;

import ch.zhaw.zahlesev.tictactoeparadise.models.Board;
import ch.zhaw.zahlesev.tictactoeparadise.models.Coordinates2D;

public class BoardEvaluator {
    public boolean hasBoardNInARow(Board board, char mark, int n) {
        return 
            hasBoardNInARowHorizontal(board, mark, n) ||
            hasBoardNInARowVertical(board, mark, n) ||
            hasBoardNInARowDiagonalTLBR(board, mark, n) ||
            hasBoardNInARowDiagonalTRBL(board, mark, n);
    }
    
    public List<Coordinates2D> getAllFieldsByMark(Board board, char mark) {
        List<Coordinates2D> matchingFields = new ArrayList<>();
        
        for (int col = 0; col < board.getWidth(); col++) {
            for (int row = 0; row < board.getHeight(); row++) {
                if (board.getField(col, row) == mark) {
                    matchingFields.add(new Coordinates2D(col, row));
                }
            }
        }
        
        return matchingFields;
    }
    
    public List<Coordinates2D> getEmptyFields(Board board) {
        return getAllFieldsByMark(board, Board.EMPTY_FIELD);
    }
    
    public boolean isBoardFull(Board board) {
        return getEmptyFields(board).size() == 0;
    }
    
    private boolean hasBoardNInARowHorizontal(Board board, char mark, int n) {
        if (board.getWidth() < n) {
            return false;
        }
        
        for (int row = 0; row < board.getHeight(); row++) {
            for (int col = 0; col < board.getWidth() - n + 1; col++) {
                boolean isNInARow = true;
                for (int i = 0; i < n; i++) {
                    if (board.getField(col + i, row) != mark) {
                        isNInARow = false;
                        break;
                    }
                }
                if (isNInARow) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean hasBoardNInARowVertical(Board board, char mark, int n) {
        if (board.getHeight() < n) {
            return false;
        }
        
        for (int col = 0; col < board.getWidth(); col++) {
            for (int row = 0; row < board.getHeight() - n + 1; row++) {
                boolean isNInARow = true;
                for (int i = 0; i < n; i++) {
                    if (board.getField(col, row + i) != mark) {
                        isNInARow = false;
                        break;
                    }
                }
                if (isNInARow) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean hasBoardNInARowDiagonalTLBR(Board board, char mark, int n) {
        if (board.getHeight() < n || board.getWidth() < n) {
            return false;
        }
        
        for (int col = 0; col < board.getWidth() - n + 1; col++) {
            for (int row = 0; row < board.getHeight() - n + 1; row++) {
                boolean isNInARow = true;
                for (int i = 0; i < n; i++) {
                    if (board.getField(col + i, row + i) != mark) {
                        isNInARow = false;
                        break;
                    }
                }
                if (isNInARow) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean hasBoardNInARowDiagonalTRBL(Board board, char mark, int n) {
        if (board.getHeight() < n || board.getWidth() < n) {
            return false;
        }
        
        for (int col = n - 1; col < board.getWidth(); col++) {
            for (int row = 0; row < board.getHeight() - n + 1; row++) {
                boolean isNInARow = true;
                for (int i = 0; i < n; i++) {
                    if (board.getField(col - i, row + i) != mark) {
                        isNInARow = false;
                        break;
                    }
                }
                if (isNInARow) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
