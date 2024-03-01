/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

/**
 *
 * @author jose
 */
public class Rook extends FirstMovePiece{
    
    public Rook(boolean isWhite, int row, int col) {
        super(isWhite, row, col);
    }
    
    @Override
    public boolean canMove(int row, int col) {
        return (row == getRow() || col == getCol());
    }
}
