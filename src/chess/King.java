/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

/**
 *
 * @author jose
 */
public class King extends Piece{
    private boolean firstMove;
    
    public King(boolean isWhite, int row, int col) {
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
        boolean isStandardMove = Math.abs(row - getRow()) == 1 || Math.abs(col - getCol()) == 1;
        boolean isKingsideCastling = col == getCol() + 2 && firstMove;
        boolean isQueensideCastling = col == getCol() - 2 && firstMove;

        return isStandardMove || isKingsideCastling || isQueensideCastling;
    }

    @Override
    public String toString() {
        return super.toString() + "firstMove:" + (firstMove ? "Yes" : "No");
    }
    
    
}
