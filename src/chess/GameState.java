/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

/**
 *
 * @author jose
 */
public class GameState {
    private String log;
    private String whiteTable;
    private String blackTable;
    private boolean winner;
    private boolean isWhiteTurn;

    public GameState(String log, String whiteTable, String blackTable, boolean winner, boolean isWhiteTurn) {
        this.log = log;
        this.whiteTable = whiteTable;
        this.blackTable = blackTable;
        this.winner = winner;
        this.isWhiteTurn = isWhiteTurn;
    }

    public GameState() {
        this("", "", "", false, true);
    }

    public String getLog() {
        return log;
    }

    public String getWhiteTable() {
        return whiteTable;
    }

    public String getBlackTable() {
        return blackTable;
    }

    public String getWinner() {
        return winner ? "Yes" : "No";
    }

    public String getIsWhiteTurn() {
        return isWhiteTurn ? "Yes" : "No";
    }
    
    
    
    
}
