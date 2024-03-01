/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

/**
 *
 * @author jose
 */
public class King extends FirstMovePiece{
    
    public King(boolean isWhite, int row, int col) {
        super(isWhite, row, col);
    }
    
    @Override
    public boolean canMove(int row, int col) {
        boolean isStandardMove = Math.abs(row - getRow()) == 1 || Math.abs(col - getCol()) == 1;
        boolean isKingsideCastling = col == getCol() + 2 && isFirstMove();
        boolean isQueensideCastling = col == getCol() - 2 && isFirstMove();

        return isStandardMove || isKingsideCastling || isQueensideCastling;
    }
    
    
}
