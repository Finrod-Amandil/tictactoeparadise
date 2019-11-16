package ch.zhaw.zahlesev.tictactoeparadise;

import java.util.Arrays;
import java.util.List;

import ch.zhaw.zahlesev.tictactoeparadise.gametypes.*;
import ch.zhaw.zahlesev.tictactoeparadise.models.GameInfo;
import ch.zhaw.zahlesev.tictactoeparadise.models.GameInitializationResult;
import ch.zhaw.zahlesev.tictactoeparadise.models.GameInitializationState;
import ch.zhaw.zahlesev.tictactoeparadise.models.GameState;
import ch.zhaw.zahlesev.tictactoeparadise.models.Turn;
import ch.zhaw.zahlesev.tictactoeparadise.models.TurnResult;
import ch.zhaw.zahlesev.tictactoeparadise.models.TurnResultState;

public class GameMapper {
    private static GameMapper instance;
    
    private GameType currentGameType;
    private GameClassic gameClassic = new GameClassic();
    private GameMisere gameMisere = new GameMisere();
    private GameNotakto gameNotakto = new GameNotakto();
    private GameWildTicTacToe gameWildTicTacToe = new GameWildTicTacToe();
    private GameOrderAndChaos gameOrderAndChaos = new GameOrderAndChaos();
    
    private GameMapper() { }
    
    public static GameMapper getInstance() {
        if (instance == null) {
            instance = new GameMapper();
        }
        return instance;
    }
    
    public List<GameInfo> getGameInfos() {
        return Arrays.asList(
            gameClassic.getGameInfo(),
            gameMisere.getGameInfo(),
            gameNotakto.getGameInfo(),
            gameWildTicTacToe.getGameInfo(),
            gameOrderAndChaos.getGameInfo());    
    }
    
    public GameInitializationResult initGame(GameType gameType, String[] args) {
        currentGameType = gameType;
        
        switch (gameType) {
            case CLASSIC: return gameClassic.initGame(args);
            case MISERE: return gameMisere.initGame(args);
            case NOTAKTO: return gameNotakto.initGame(args);
            case WILD_TIC_TAC_TOE: return gameWildTicTacToe.initGame(args);
            case ORDER_AND_CHAOS: return gameOrderAndChaos.initGame(args);
            default: return new GameInitializationResult(GameInitializationState.FAILED);
        }
    }
    
    public TurnResult makeTurn(GameState gameState) {
        switch (currentGameType) {
            case CLASSIC: return gameClassic.makeTurn(gameState);
            case MISERE: return gameMisere.makeTurn(gameState);
            case NOTAKTO: return gameNotakto.makeTurn(gameState);
            case WILD_TIC_TAC_TOE: return gameWildTicTacToe.makeTurn(gameState);
            case ORDER_AND_CHAOS: return gameOrderAndChaos.makeTurn(gameState);
            default: return new TurnResult(TurnResultState.INVALID_TURN);
        }
    }
    
    public Turn getComputerTurn(GameState gameState) {
        switch (currentGameType) {
            case CLASSIC: return gameClassic.getComputerTurn(gameState);
            case MISERE: return gameMisere.getComputerTurn(gameState);
            case NOTAKTO: return gameNotakto.getComputerTurn(gameState);
            case WILD_TIC_TAC_TOE: return gameWildTicTacToe.getComputerTurn(gameState);
            case ORDER_AND_CHAOS: return gameOrderAndChaos.getComputerTurn(gameState);
            default: return null;
        }
    }
}
