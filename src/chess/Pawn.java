/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

/**
 *
 * @author jose
 */
public class Pawn extends FirstMovePiece{
    public Pawn(boolean isWhite, int row, int col) {
        super(isWhite, row, col);
    }
    
    @Override
    public boolean canMove(int row, int col) {
        boolean isForwardOne = row == getRow() - 1;
        boolean isForwardTwo = row == getRow() - 2 && isFirstMove();
        boolean isCaptureDiagonal = row == getRow() - 1 && Math.abs(col - getCol()) == 1;

        return isForwardTwo || isForwardOne || isCaptureDiagonal;
    }
}
