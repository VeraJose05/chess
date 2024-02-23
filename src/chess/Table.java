
package chess;


public class Table {
    
    private static final int nRows=8;
    
    private static final char PEON='P';
    private static final char REINA='Z';
    private static final char REY='R';
    private static final char TORRE='T';
    private static final char ALFIL='A';
    private static final char CABALLO='C';
    
    
    
    private char[][] Tablero;
    private Piece[][] Tablero_piezas;
    
    
    public Table(){
       
        Tablero = new char[nRows][nRows];
        Tablero_piezas = new Piece[nRows][nRows];
        
        
    }
    
    private boolean posOK( int r , int c){
        return r >= 0 && r < nRows && c >=0 && c < nRows;
       
    }
    
    private void makePieces(boolean color){
        for ( int i = 0 ; i < nRows ; i++)
            for( int j = 0 ; j < nRows ; j++)
                if ( i == 1 || i == 7 )
                Piece Pawn = new Piece( color , i , j );
    }
    
    
}
