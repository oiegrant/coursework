public class Rook {
    // Instance variables
    private int row;
    private int col;
    private boolean isBlack;

    /**
     * Constructor.
     * @param row   The current row of the rook.
     * @param col   The current column of the rook.
     * @param isBlack   The color of the rook.
     */
    public Pawn(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    /**
     * Checks if a move to a destination square is legal.
     * @param board     The game board.
     * @param endRow    The row of the destination square.
     * @param endCol    The column of the destination square.
     * @return True if the move to the destination square is legal, false otherwise.
     */
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (board.verifyVertical(this.row, this.col, endRow, endCol) && board.verifyHorizontal(this.row, this.col, endRow, endCol) && board.getPiece(endRow, endCol) == null) {
            // Case 1: Straight line to empty square.
            // Determine if the move is generally valid.
            return board.verifySourceAndDestination(this.row,this.col, endRow,endCol,this.isBlack);

        } else if (board.verifyVertical(this.row, this.col, endRow, endCol) && board.verifyHorizontal(this.row, this.col, endRow, endCol) && !(board.getPiece(endRow, endCol) == null)) {
            // Case 2: Capturing a piece.
            if (board.getPiece(endRow, endCol) != null && board.getPiece(endRow, endCol).getIsBlack() != this.isBlack) {
                // There is a piece of the opposite color to be captured.
                // Determine if the move is generally valid.
                return board.verifySourceAndDestination(this.row,this.col, endRow,endCol,this.isBlack);

            }
            else {
                // friendly fire
                return false;
            }
        } else {
            // Case 3: Moving in a non-straight direction. (illegal move)
            return false;
        }
    }

}
