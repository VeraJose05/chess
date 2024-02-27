/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

/**
 *
 * @author jose
 */
public class Knight extends Piece{

    public Knight(boolean isWhite, int row, int col) {
        super(isWhite, row, col);
    }
    
    @Override
    public boolean move(int row, int col) {
        return (Math.abs(row - getRow()) == 1 && Math.abs(col - getCol()) == 2 )
                || (Math.abs(row - getRow()) == 2 && Math.abs(col - getCol()) == 1 );
    }
    
}
