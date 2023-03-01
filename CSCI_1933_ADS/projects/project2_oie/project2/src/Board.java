public class Board {

    // Instance variables
    private Piece[][] board;
    private boolean blackTurn;




    public Board() {
        board = new Piece[8][8];
        blackTurn = false;
    }

    // Accessor Methods

    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
        piece.setPosition(row,col);
    }

    public boolean isBlackTurn(){
        return blackTurn;
    }

    // Game functionality methods

    //TODO:
    // Your Game class should not
    // directly call any other method of this class.
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        Piece tempPiece = null;

        // if a piece exists at the starting pos, assign to tempPiece, else false
        if(getPiece(startRow,startCol) != null){
            tempPiece = getPiece(startRow,startCol);
        }
        else{
            return false;
        }

        if(verifySourceAndDestination(startRow,startCol,endRow,endCol,tempPiece.getIsBlack()) && tempPiece.isMoveLegal(this,endRow, endCol)){
            setPiece(endRow,endCol,tempPiece);
            blackTurn = !blackTurn;
            return true;
        }
        return false;
    }

    public boolean isGameOver() {
        boolean whiteKing = false;
        boolean blackKing = false;
        for(int i=0; i < board.length;i++){
            for (int j=0; j < board.length; j++){
                Piece tempPiece = getPiece(i,j);
                if(tempPiece.getCharacter() == '\u265a'){ blackKing = true; }
                if(tempPiece.getCharacter() == '\u2654'){ whiteKing = true; }
                }
            }

        if (!whiteKing){
            System.out.println("BLACK WINS!");
            System.out.println("Clearing Board...");
            clear();
            return true;
        }
        if (!blackKing){
            System.out.println("WHITE WINS!");
            System.out.println("Clearing Board...");
            clear();
            return true;
        }

        return false;
    }


    //TODO:
    // Construct a String that represents the Board object's 2D array. Return
    // the fully constructed String.
    public String toString() {
        return null;
    }

    public void clear() {
        for(int i=0; i< board.length;i++){
            for(int j=0; j< board.length;j++){
                board[i][j] = null;
            }
        }

    }

    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        boolean boundCheck = false;
        boolean pieceCheck = false;
        boolean colorCheck = false;
        boolean endCheck = false;

        // verifies if both the start and ending positions are in range
        if (verifyInRange(startRow) && verifyInRange(startCol) && verifyInRange(endRow) && verifyInRange(endCol) ){
            boundCheck = true;
        }

        // checks if piece exists at starting pos
        if (getPiece(startRow,startCol) != null){
            pieceCheck = true;
        }

        // checks current turn color against piece being moved
        if(this.isBlackTurn() == isBlack){
            colorCheck = true;
        }

        // end pos either has no piece or piece of opposite color
        if(getPiece(endRow,endCol)==null || isBlack != getPiece(endRow,endCol).getIsBlack()){
            endCheck = true;
        }

        //if all checks pass, return true, otherwise return false
        if(boundCheck && pieceCheck && colorCheck && endCheck){
            return true;
        }
        return false;
    }

    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        if(Math.abs(startRow-endRow) <= 1 && Math.abs(startCol-endCol) <= 1){
            return true;
        }
        return false;
    }

    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        int left = startCol;
        if(startCol>endCol){
            left = endCol;
        }

        for(int i=left+1;i<endCol;i++){
            if (getPiece(i,startCol) != null) {
                return false;
            }
        }
        if (startRow != endRow){
            return false;
        }
        return true;
    }

    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        int top = startRow;

        if(startRow>endRow){
            top = endRow;
        }

        for (int i=top+1; i<endRow; i++){
            if(getPiece(startRow,i) != null){
                return false;
            }
        }

        if (startCol != endCol){
            return false;
        }

        return true;
    }

    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        int rowDiff = Math.abs(startRow - endRow);
        int colDiff = Math.abs(startCol - endCol);

        // check for diagonal
        if(rowDiff!=colDiff){
            return false;
        }


        boolean down = true;
        boolean right = true;
        if (startRow>endRow){
            down = false;
        }
        if (startCol>endCol){
            right = false;
        }

        for (int i=1; i<rowDiff; i++){
            // down right
            if(down && right){
                if(board[startRow+i][startCol+i] != null){
                    return false;
                }
            }
            //down left
            if (down && !right){
                if(board[startRow+i][startCol-i] != null){
                    return false;
                }
            }
            // Up right
            if (!down && right){
                if(board[startRow-i][startCol+i] != null){
                    return false;
                }
            }
            // Up left
            if (!down && !right){
                if(board[startRow-i][startCol-i] != null){
                    return false;
                }
            }
        }
        return true;
    } // end diagonalCheck

    //ADDED Func? README
    public boolean verifyInRange(int pos){
        if (pos>7 || pos<0){
            return false;
        }
        return true;
    }
}
