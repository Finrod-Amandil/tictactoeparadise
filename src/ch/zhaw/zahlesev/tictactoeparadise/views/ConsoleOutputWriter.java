package ch.zhaw.zahlesev.tictactoeparadise.views;

import ch.zhaw.zahlesev.tictactoeparadise.models.*;

public class ConsoleOutputWriter {
    private static ConsoleOutputWriter instance;
    
    private ConsoleOutputWriter() { }
    
    public static ConsoleOutputWriter getInstance() {
        if (instance == null) {
            instance = new ConsoleOutputWriter();
        }
        
        return instance;
    }
    
    public void printWelcome() {
        System.out.println("Hello there.");
    }
    
    public void printString(String string) {
        System.out.println(string);
    }
    
    public void printBoard(Board board) {
        //TODO
    }
    
    public void printGameInfo(GameInfo gameInfo) {
        //TODO
    }
}
