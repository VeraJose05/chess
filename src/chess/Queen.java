/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

/**
 *
 * @author jose
 */
public class Queen extends Piece{

    public Queen(boolean isWhite, int row, int col) {
        super(isWhite, row, col);
    }
    
    @Override
    public boolean move(int row, int col) {
        return ((Math.abs(row  - getRow()) == Math.abs(col - getCol()))) || (row == getRow() || col == getCol());
    }
    
}
