package ch.zhaw.zahlesev.tictactoeparadise.views;

import java.util.List;
import java.util.Scanner;

import ch.zhaw.zahlesev.tictactoeparadise.models.Coordinates2D;

public class ConsoleInputReader {
    private static final String INVALID_INPUT_MSG = "This input is not valid. Please try again.";
    private static final String PROMPT_COORD_HORZ = "column / x = ";
    private static final String PROMPT_COORD_VERT = "row / y = ";
    private static final String PROMPT_SELECT_OPTION = "Please enter the number of one of the options: ";
    private static ConsoleInputReader instance;
    
    private Scanner scanner;
    
    private ConsoleInputReader() {};
    
    public static ConsoleInputReader getInstance() {
        if (instance == null) {
            instance = new ConsoleInputReader();
        }
        
        return instance;
    }
    
    public String readString(String prompt) {
        boolean isInputValid = false;
        String input = "";
        
        while(!isInputValid) {
            System.out.println(prompt);
            input = scanner.nextLine().trim();
            
            if (input.length() > 0) {
                isInputValid = true;
            }
            else {
                System.out.println(INVALID_INPUT_MSG);
            }
        }
        
        return input;
    }
    
    public int readInt(String prompt, boolean mustBePositive) {
        boolean isValidInput = false;
        String intString;
        int parsedInt = 0;
        
        while(!isValidInput) {
            System.out.println(prompt);
            intString = scanner.nextLine().trim();
            
            try {
                parsedInt = Integer.parseInt(intString);
                if (!mustBePositive || parsedInt > 0) {
                    isValidInput = true;
                }
            }
            catch (NumberFormatException nfe) {
                System.out.println(INVALID_INPUT_MSG);
            }
        }
        
        return parsedInt;
    }
    
    public Coordinates2D readCoordinates2D(String prompt) {
        System.out.println(prompt);
        int x = readInt(PROMPT_COORD_HORZ, true);
        int y = readInt(PROMPT_COORD_VERT, true);
        
        return new Coordinates2D(x, y);
    }
    
    public String selectOption(String prompt, List<String> options) {
        boolean isValidInput = false;
        String selectedOption = "";
        
        while (!isValidInput) {
            System.out.println(prompt);
            for (int i = 1; i <= options.size(); i++) {
                System.out.println(i + ": " + options.get(i-1));
            }
            
            int index = readInt(PROMPT_SELECT_OPTION, true);
            
            if (index <= options.size()) {
                isValidInput = true;
                selectedOption = options.get(index - 1);
            }
            else {
                System.out.println(INVALID_INPUT_MSG);
            }
        }
        
        return selectedOption;
    }
    
    public void close() {
        scanner.close();
    }
}
