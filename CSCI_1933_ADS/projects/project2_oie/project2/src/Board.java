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
    // Moves a Piece object from one cell in the board to another, provided that
    // this movement is legal.
    // This method calls all necessary helper functions to determine if a move
    // is legal, and to execute the move if it is. Your Game class should not 
    // directly call any other method of this class.
    // Hint: this method should call isMoveLegal() on the starting piece.
    // verifySourceAndDestination??
    // UPDATE FOR TURN SWITCHING
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        Piece tempPiece = null;
        if(getPiece(startRow,startCol) != null){
            tempPiece = getPiece(startRow,startCol);
        }
        if(tempPiece.isMoveLegal(this,endRow, endCol)){
            setPiece(endRow,endCol,tempPiece);
            blackTurn = !blackTurn;
            return true;
        }
        return false;
    }

    //TODO:
    // Determines whether the game has been ended, i.e., if one player's King
    // has been captured.
    public boolean isGameOver() {
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

    // Movement helper functions

    //TODO:
    // Ensure that the player's chosen move is even remotely legal.
    // Returns a boolean to signify whether:
    // - 'start' and 'end' fall within the array's bounds.
    // - 'start' contains a Piece object, i.e., not null.
    // - Player's color and color of 'start' Piece match.
    // - 'end' contains either no Piece or a Piece of the opposite color.
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        boolean boundCheck = false;
        boolean pieceCheck = false;
        boolean colorCheck = false;
        boolean endCheck = false;

        if (verifyInRange(startRow) && verifyInRange(startCol) && verifyInRange(endRow) && verifyInRange(endCol) ){
            boundCheck = true;
        }

        if (getPiece(startRow,startCol) != null){
            pieceCheck = true;
        }

        if(this.isBlackTurn() == isBlack){
            colorCheck = true;
        }

        if(getPiece(endRow,endCol)==null || isBlack != getPiece(endRow,endCol).getIsBlack()){
            endCheck = true;
        }

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

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid horizontal move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one row.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        boolean test = true;
        for(int i=startCol+1;i<endCol;i++){
            if (getPiece(startRow,startCol) != null) {
                test = false;
            }
        }
        if (startRow != endRow){
            test = false;
        }

        return test;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid vertical move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one column.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        return false;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid diagonal move.
    // Returns a boolean to signify whether:
    // - The path from 'start' to 'end' is diagonal... change in row and col.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        return false;
    }

    public boolean verifyInRange(int pos){
        if (pos>7 || pos<0){
            return false;
        }
        return true;
    }
}
