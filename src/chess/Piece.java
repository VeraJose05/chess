/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

/**
 *
 * @author jose
 */
public abstract class Piece {
    private boolean isWhite; // 0 -> -- black 1 -> white
    private boolean isAlive; // 1 -> alive -- 0 -> death
    private int row;
    private int col;

    public Piece(boolean isWhite, boolean isAlive, int row, int col) {
        this.isWhite = isWhite;
        this.isAlive = isAlive;
        this.row = row;
        this.col = col;
    }
    
    public Piece(boolean color, int row, int col){
        this(color, true, row, col);
    }
    
    public abstract void move();

    public boolean isWhite() {
        return isWhite;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    
    public void setPos(int row, int col){
        this.row = row;
        this.col = col;
    }
}
