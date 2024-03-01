/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

/**
 *
 * @author jose
 */
public class Pawn extends Piece{
    private boolean firstMove;
    public Pawn(boolean isWhite, int row, int col) {
        super(isWhite, row, col);
        this.firstMove = true;
    }

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }
    
    @Override
    public boolean canMove(int row, int col) {
        boolean isForwardOne = row == getRow() - 1;
        boolean isForwardTwo = row == getRow() - 2 && firstMove;
        boolean isCaptureDiagonal = row == getRow() - 1 && Math.abs(col - getCol()) == 1;

        return isForwardTwo || isForwardOne || isCaptureDiagonal;
    }

    
}
