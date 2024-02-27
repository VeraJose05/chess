
package chess;


public class Table {
    
    private static final int nRows=8;
    
    
    private static final char EMPTY ='-';
    private static final char PAWN='P';
    private static final char QUEEN='Q';
    private static final char KING='K';
    private static final char ROOK='T';
    private static final char BISHOP='A';
    private static final char KNIGHT='C';
    
    
    
    private char[][] Tablero;
    private Piece[][] Tablero_piezas;
    
    
    public Table(){
       
        Tablero = new char[nRows][nRows];
        Tablero_piezas = new Piece[nRows][nRows];
        
        makePieces(true);
        makePieces(false);
    }
    
    private boolean posOK( int r , int c){
        return r >= 0 && r < nRows && c >=0 && c < nRows;
       
    }
    
    private void makePieces(boolean color){
       
        //CREATION OF PAWNS
        
        for( int j = 0 ; j < nRows ; j++) {
                if ( color ){
                    Tablero_piezas[6][j] = new Pawn( color, 6 , j );
                    Tablero[6][j]=PAWN;
                }
                else{
                    Tablero_piezas[1][j] = new Pawn( color, 1 , j );
                    Tablero[1][j]=PAWN;      
                }
        }
        
        
        //CREATION OF KNIGHTS

        for( int j = 0 ; j < nRows ; j++) {
            if ( color ){
                if ( j == 1 || j == 6 ){
                    Tablero_piezas[7][j] = new Knight( color, 7, j );
                    Tablero[7][j]=KNIGHT;
                }
            }
            else{
                if ( j == 1 || j == 6 ){
                    Tablero_piezas[0][j] = new Knight( color, 0, j );
                    Tablero[0][j]=KNIGHT;    
                }
            }
        }
        
        //CREATION OF BISHOPS
        
        for( int j = 0 ; j < nRows ; j++) {
            if ( color ){
                if ( j == 2 || j == 5 ){
                    Tablero_piezas[7][j] = new Bishop( color, 7, j );
                    Tablero[7][j]=BISHOP;
                }
            }
            else{
                if ( j == 2 || j == 5 ){
                    Tablero_piezas[0][j] = new Bishop( color, 0, j );
                    Tablero[0][j]=BISHOP;
                }
            }
        }
        
        // CREATION OF ROOKS
        
        for( int j = 0 ; j < nRows ; j++) {
            if ( color ){
                if ( j == 0 || j == 7 ){
                    Tablero_piezas[7][j] = new Rook( color, 7, j );
                    Tablero[7][j]=ROOK;
                }
            }
            else{
                if ( j == 0 || j == 7 ){
                    Tablero_piezas[0][j] = new Rook( color, 0, j );
                    Tablero[0][j]=ROOK;
                }
            }
        }
        
        //CREATION OF KING
        
        
            if ( color ){
                    Tablero_piezas[7][4] = new King( color, 7, 4 );
                    Tablero[7][4]=KING;
            }
            else{

                    Tablero_piezas[0][4] = new King( color, 0, 4 );
                    Tablero[0][4]=KING;
            }
        
            
        //CREATION OF QUEEN 
        
        
        if ( color ){
            Tablero_piezas[7][3] = new Queen( color, 7, 3 );
            Tablero[7][3]=QUEEN;
        }
        else{

            Tablero_piezas[0][3] = new Queen( color, 0, 3);
            Tablero[0][3]=QUEEN;
        }
        
         
        for ( int i = 2 ; i < 6 ; i++ ){
            
            for ( int j = 0 ; j < nRows ; j++){
                
                Tablero[i][j] = EMPTY;
            
            }
            
        }
        
    }
    
    public String showState(){
        String resultado = "";
        for ( int i = 0 ; i < nRows ; i++){
            for ( int j = 0 ; j < nRows ; j++){
                resultado += Tablero[i][j] + " ";
            }
            resultado+="\n";
        }
       return resultado; 
    }
}
