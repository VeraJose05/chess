/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

/**
 *
 * @author jose
 */
public abstract class FirstMovePiece extends Piece {
    private boolean firstMove;
    public FirstMovePiece(boolean isWhite, int row, int col) {
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
    public String toString() {
        return super.toString() + "firstMove:" + (firstMove ? "Yes" : "No");
    }
}
