/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import java.util.Scanner;
import chess.GameState;

/**
 *
 * @author jose
 */
public class TextUI implements UI{
    private Scanner scanner;
    
    public TextUI(){
         scanner = new Scanner(System.in);
    }
    
    private int[] chessNotationToIndices(String notation) {
        int col = notation.charAt(0) - 'A';
        int row = 8 - Character.getNumericValue(notation.charAt(1));
        return new int[]{row, col};
    }
    
    @Override
    public int[][] nextMove() {
        int[][] move = new int [2][2];
        System.out.print("Introduce la posición de la pieza que quieres mover (por ejemplo, A8): ");
        String fromPosition = scanner.next();

        move[0] = chessNotationToIndices(fromPosition);
        

        System.out.print("Introduce la posición a la que quieres mover la pieza (por ejemplo, B6): ");
        String toPosition = scanner.next();

        move[1] = chessNotationToIndices(toPosition);
        
        return move;
    }

    @Override
    public void showGame(GameState gameState) {
        System.out.println(gameState.getWhiteTable()+ "\n" +
                            gameState.getBlackTable()+ "\n" +
                            "Ganador: " + gameState.getWinner()+ "\n" +
                            "Es el turno de las "  + gameState.getIsWhiteTurn()+ "\n" +
                            gameState.getLog()+ "\n");
    }
    
}
