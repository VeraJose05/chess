/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;
import UI.*;

/**
 *
 * @author jose
 */
public class Game {
    private Table whiteTable;
    private Table blackTable;
    
    private boolean isWhiteTurn;
    private String log;
    
    private TextUI view;

    public Game(boolean isWhiteTurn, Table whiteTable, Table blackTable, String log, TextUI view) {
        this.log = log;
        this.isWhiteTurn = isWhiteTurn;
        this.whiteTable = whiteTable;
        this.blackTable = blackTable;
        this.view = view;
    }
    
    public Game(){
        this(true, new Table(true), new Table(false), "", new TextUI());
    }
    
    public boolean finished(){
        return whiteTable.isCheckmate(true) && blackTable.isCheckmate(false);
    }
    
    public GameState getGameState(){
        return new GameState(log, whiteTable.toString(), blackTable.toString(), finished(), isWhiteTurn);
    }
    
    public void nextTurn(int fromRow, int fromCol, int toRow, int toCol){
        this.log = "";
        
        Table currentTable = isWhiteTurn ? whiteTable : blackTable;
        
        if (currentTable.makeMove(fromRow, fromCol, toRow, toCol)){
            log += "Movimiento válido. Se ha actualizado el tablero.";

            isWhiteTurn = !isWhiteTurn;
        }else{
            log += "Movimiento no válido. Por favor, intenta de nuevo.";
        }
    }
    
    public void play() {
        boolean endOfGame = false;
        while (!endOfGame) {
            view.showGame(getGameState()); 
            int [][] move = view.nextMove(); 
            nextTurn(move[0][0], move[0][1], move[1][0], move[1][1]);
            endOfGame = finished();
        }
        view.showGame(getGameState());        
    }
    
    
    
}
