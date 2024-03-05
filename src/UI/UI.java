/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package UI;
import chess.GameState;

/**
 *
 * @author jose
 */
public interface UI {
    public int [][] nextMove();
    public void showGame(GameState gameState);  
}
