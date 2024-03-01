/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

/**
 *
 * @author jose
 */
public class Rook extends Piece{
    private boolean firstMove;
    
    public Rook(boolean isWhite, int row, int col) {
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
        return (row == getRow() || col == getCol());
    }
    
    @Override
    public String toString() {
        return super.toString() + "firstMove:" + (firstMove ? "Yes" : "No");
    }
}
