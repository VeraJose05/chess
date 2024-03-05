
package chess;

import java.util.ArrayList;

public class Table {
    
    private static final int tamBoard=8;
    
    
    private static final char EMPTY ='-';
    private static final char PAWN='P';
    private static final char QUEEN='Q';
    private static final char KING='K';
    private static final char ROOK='R';
    private static final char BISHOP='B';
    private static final char KNIGHT='C';
    
    private boolean isWhiteAtBottom;
    
    private char[][] visualBoard;
    private Piece[][] logicalBoard;
    
    private ArrayList<Piece> playerPieces;
    private ArrayList<Piece> opponentPieces;

    
    
    public Table(boolean isWhiteAtBottom){
       
        visualBoard = new char[tamBoard][tamBoard];
        logicalBoard = new Piece[tamBoard][tamBoard];
        playerPieces = new ArrayList<>();
        opponentPieces = new ArrayList<>();
        
        for ( int i = 0 ; i < tamBoard ; i++ )
            for ( int j = 0 ; j < tamBoard ; j++)
                visualBoard[i][j] = EMPTY;      
        
        this.isWhiteAtBottom = isWhiteAtBottom;
        initializeBoard(isWhiteAtBottom);
    }
    
    public boolean makeMove(int fromRow, int fromCol, int toRow, int toCol) {
        Piece piece = logicalBoard[fromRow][fromCol];
        boolean moveMade = isValidMove(piece, toRow, toCol);

        
        if (moveMade){
            if (logicalBoard[toRow][toCol] != null){
                logicalBoard[toRow][toCol].setPos(-1,-1);
                logicalBoard[toRow][toCol].setAlive(false);
                opponentPieces.remove(logicalBoard[toRow][toCol]);
            }
            
            if (piece instanceof Pawn || piece instanceof Rook || piece instanceof King) {
                ((FirstMovePiece) piece).setFirstMove(false);
            }
            
            if (piece instanceof King && isCastleMove(fromRow, fromCol, toRow, toCol)) {
                performCastle(piece, logicalBoard[toRow][toCol]);
            } else {
                logicalBoard[fromRow][fromCol] = null;
                logicalBoard[toRow][toCol] = piece;
                piece.setPos(toRow, toCol);
                visualBoard[fromRow][fromCol] = EMPTY;
                if (piece.isWhite())
                    visualBoard[toRow][toCol] = piece.getIni() ; 
                else
                    visualBoard[toRow][toCol] = Character.toLowerCase(piece.getIni()) ; 
            }
        }
        
        return moveMade;
    }

    
    public boolean isCheck(boolean isWhite) {
        int kingRow = -1,
            kingCol = -1;
        boolean check = false;

        // Encuentra la posición del rey del color especificado
        for (Piece p : playerPieces)
                if (p instanceof King) {
                    kingRow = p.getRow();
                    kingCol = p.getCol();
                }

        // Verifica si alguna pieza del oponente puede atacar al rey
        for (int i = 0; i < opponentPieces.size() && !check; i++) {
                Piece piece = opponentPieces.get(i);
                check = (piece != null && isValidMove(piece,  kingRow, kingCol));
        }

        return check;
    }
    
    
    //PENSAR MUY BIEN
    public boolean isCheckmate(boolean isWhite) {
       return false;
    }

    
    public boolean performCastle(Piece king, Piece rook) {
        boolean valid = (!isCastleValid((FirstMovePiece) king, (FirstMovePiece) rook));
        int kingRow = king.getRow(),
                kingCol = king.getCol(),
                rookRow = rook.getRow(),
                rookCol = rook.getCol();
        if (valid){
            logicalBoard[kingRow][kingCol] = null;
            logicalBoard[rookRow][rookCol] = null;


            if (rookCol > kingCol) {
                logicalBoard[kingRow][kingCol + 2] = king;
                logicalBoard[rookRow][rookCol - 2] = rook;

                king.setPos(kingRow, kingCol + 2);
                rook.setPos(rookRow, rookCol - 2);
                
                visualBoard[kingRow][kingCol + 2] = KING;
                visualBoard[rookRow][rookCol - 2] = ROOK;
            } else {
                logicalBoard[kingRow][kingCol - 2] = king;
                logicalBoard[rookRow][rookCol + 3] = rook;

                king.setPos(kingRow, kingCol - 2);
                rook.setPos(rookRow, rookCol + 3);
                
                visualBoard[kingRow][kingCol - 2] = KING;
                visualBoard[rookRow][rookCol + 3] = ROOK;
            }
        }
        
        return valid;
    }

    
    @Override
    public String toString(){
        String resultado = "Tablero de las" + (isWhiteAtBottom ? "Blancas:" : "Negras:") + "\n";
        for ( int i = 0 ; i < tamBoard ; i++){
            for ( int j = 0 ; j < tamBoard ; j++){
                resultado += visualBoard[i][j] + " ";
            }
            resultado+="\n";
        }
       return resultado; 
    }
    
    private boolean isCastleValid(FirstMovePiece king, FirstMovePiece rook) {
        // Verificar las condiciones para realizar el enroque
        // Esto puede incluir la verificación de posiciones iniciales,
        // si las casillas entre el rey y la torre están despejadas, etc.
        // Retorna true si el enroque es válido, de lo contrario, false.
        
        return isPathClear(king.getRow(), king.getCol(), 
                rook.getRow(), rook.getCol(), 
                Direction.HORIZONTAL) && king.isFirstMove() 
                                              && rook.isFirstMove();
    }
    
    private boolean isValidMove(Piece piece, int toRow, int toCol) {
        boolean validMove = !(logicalBoard[toRow][toCol] instanceof King);
        if (validMove){
            if (piece instanceof Knight)
                validMove = piece.canMove(toRow, toCol);
            else{
                int rowDiff = toRow - piece.getRow();
                int colDiff = toCol - piece.getCol();
                Direction direction;
                if (rowDiff == 0)
                    direction = Direction.HORIZONTAL;
                else if (colDiff == 0)
                    direction = Direction.VERTICAL;
                else if (Math.abs(piece.getRow()  - toRow) == Math.abs(piece.getCol() - toCol))
                    direction = Direction.DIAGONAL;
                else 
                    direction = Direction.INVALID;

                validMove = piece.canMove(toRow, toCol) && 
                        isPathClear(piece.getRow(), piece.getCol(), toRow, toCol, direction);
            }
        }
        
        return validMove;
    }
    
    private boolean isPathClear(int startRow, int startCol, int endRow, int endCol, Direction direction) {
        int stepRow = 0, stepCol = 0;

        
        switch (direction) {
            case HORIZONTAL -> stepCol = (endCol > startCol) ? 1 : -1;
            case VERTICAL -> stepRow = (endRow > startRow) ? 1 : -1;
            case DIAGONAL -> {
                stepRow = (endRow > startRow) ? 1 : -1;
                stepCol = (endCol > startCol) ? 1 : -1;
            }
        }
        
        boolean freePath = direction != Direction.INVALID;
        
        for (int row = startRow + stepRow, col = startCol + stepCol; 
                (row != endRow || col != endCol) && freePath; 
                row += stepRow, col += stepCol) {
            freePath = (logicalBoard[row][col] == null);
        }

        return freePath;
    }
    
    private boolean posOK( int r , int c){
        return r >= 0 && r < tamBoard && c >=0 && c < tamBoard; 
    }
    
    private void initializeBoard(boolean isWhiteAtBottom) {
        char[] pieceOrder = {ROOK, KNIGHT, BISHOP, QUEEN, KING, BISHOP, KNIGHT, ROOK};

        int pawnRowBottom = isWhiteAtBottom ? 6 : 1;
        int pawnRowTop = isWhiteAtBottom ? 1 : 6;
        int backRowBottom = isWhiteAtBottom ? 7 : 0;
        int backRowTop = isWhiteAtBottom ? 0 : 7;

        for (int j = 0; j < tamBoard; j++) {
            Pawn pawnBottom = new Pawn(isWhiteAtBottom, pawnRowBottom, j);
            logicalBoard[pawnRowBottom][j] = pawnBottom;
            visualBoard[pawnRowBottom][j] = PAWN;
            playerPieces.add(pawnBottom);

            Pawn pawnTop = new Pawn(!isWhiteAtBottom, pawnRowTop, j);
            logicalBoard[pawnRowTop][j] = pawnTop;
            visualBoard[pawnRowTop][j] = Character.toLowerCase(PAWN);
            opponentPieces.add(pawnTop);
        }

        for (int j = 0; j < tamBoard; j++) {
            char pieceType = pieceOrder[j];

            Piece backRowBottomPiece = createPiece(pieceType, isWhiteAtBottom, backRowBottom, j);
            logicalBoard[backRowBottom][j] = backRowBottomPiece;
            visualBoard[backRowBottom][j] = pieceType;
            playerPieces.add(backRowBottomPiece);

            Piece backRowTopPiece = createPiece(pieceType, !isWhiteAtBottom, backRowTop, j);
            logicalBoard[backRowTop][j] = backRowTopPiece;
            visualBoard[backRowTop][j] = Character.toLowerCase(pieceType);
            opponentPieces.add(backRowTopPiece);
        }
    }


    private Piece createPiece(char pieceType, boolean isWhite, int row, int col) {
        return switch (pieceType) {
            case ROOK -> new Rook(isWhite, row, col);
            case KNIGHT -> new Knight(isWhite, row, col);
            case BISHOP -> new Bishop(isWhite, row, col);
            case QUEEN -> new Queen(isWhite, row, col);
            case KING -> new King(isWhite, row, col);
            default -> null;
        }; // Handle unexpected piece types
    }
    
    private boolean isCastleMove(int fromRow, int fromCol, int toRow, int toCol) {
        Piece piece = logicalBoard[fromRow][fromCol];
        return piece instanceof King && Math.abs(toCol - fromCol) == 2;
    }

    
}
