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

    public Pawn(boolean isWhite, int row, int col) {
        super(isWhite, row, col);
    }
    
    @Override
    public boolean move(int row, int col){
        return ( row == getRow()+2 || row == getRow() + 1 || row == getRow() + 1 && Math.abs(col-getCol()) == 1 );
    }
    
}
