package edu.jsu.mcis;

public class TicTacToeModel {
    
    private Mark[][] board; /* Game board */
    private boolean xTurn;  /* True if X is current player */
    private int width;      /* Size of game board */
    
    /* ENUM TYPE DEFINITIONS */
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a TIE,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("NONE");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create board (width x width) as a 2D Mark array */
        
        board = new Mark[width][width];

        /* Initialize board by filling every square with empty marks */

        Mark mark = Mark.EMPTY;
        for (int i = 0; i < width; i++){
            for (int j = 0; j < width; i++){
                System.out.println(mark);
            }
        }
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Use "isValidSquare()" to check if the specified location is in range,
           and use "isSquareMarked()" to see if the square is empty!  If the
           specified location is valid, make a mark for the current player, then
           toggle "xTurn" from true to false (or vice-versa) to switch to the
           other player before returning TRUE.  Otherwise, return FALSE. */
        
        xTurn = true;
        for (row = 0; row < width; row++){
            for (col = 0; col < width; col++){
                if (isValidSquare(row, col) == true && isSquareMarked(row, col) == false){
                    getMark(row, col);
                    xTurn = false;
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return TRUE if the specified location is within the bounds of the board */
        
        for (row = 0; row < width; row++){
            for (col = 0; col < width; col++){
                if (row > width || row < 0 || col > width || col < 0){
                    return false;
                }
                else{
                    return true;
                }
            }
        }
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return TRUE if the square at specified location is marked */
        
        for (row = 0; row < width; row++){
            for (col = 0; col < width; col++){
                if (Mark = Mark.X){
                    return true;
                }
                if (Mark = Mark.O){
                    return true;
                }
                if (Mark = Mark.EMPTY) {
                    return false;
                }
            }
        }     
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return the mark from the square at the specified location */
        
        for (row = 0; row < width; row++){
            for (col = 0; col < width; col++){
                return Mark.message;
            }
        }        
    }
	
    public Result getResult() {
        
        /* Call "isMarkWin()" to see if X or O is the winner, if the game is a
           TIE, or if the game is not over.  Return the corresponding Result
           value */
        
        if (isMarkWin(Mark.X) == true){
            return Result.X;
        }
        if (isMarkWin(Mark.O) == true){
            return Result.O;
        }
        if (isTie() == true){
            return Result.TIE;
        }
        else {
            return Result.NONE;
        }   
    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        for (int row = 0; row < width; row++){
            for (int col = 0; col < width; col++){

                if (board[row][0] == Mark.X && board[row][1] == Mark.X && board[row][2] == Mark.X){
                    return true;
                }
                if (board[0][col] == Mark.X && board[1][col] == Mark.X && board[2][col] == Mark.X){
                    return true; 
                }
                if (board[0][0] == Mark.X && board[1][1] == Mark.X && board[2][2] == Mark.X){
                    return true;
                }
                if (board[0][2] == Mark.X && board[1][1] == Mark.X && board[2][0] == Mark.X){
                    return true;
                }
                if (board[row][0] == Mark.O && board[row][1] == Mark.O && board[row][2] == Mark.O){
                    return true;
                }
                if (board[0][col] == Mark.O && board[1][col] == Mark.O && board[2][col] == Mark.O){
                    return true;
                }
                if (board[0][0] == Mark.O && board[1][1] == Mark.O && board[2][2] == Mark.O){
                    return true; 
                }
                if (board[0][2] == Mark.O && board[1][1] == Mark.O && board[2][0] == Mark.O){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
    }

    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */
        for (int row = 0; row < width; row++){
            for (int col = 0; col < width; col++){
                if (board[row][col] == Mark.X && board[row][col] == Mark.O){
                    return true;
                }
                else {
                    return false;
                }
            }
        }
    }

    public boolean isGameover() {
        
        /* Return TRUE if the game is over */

        if (isMarkWin() == true){
            return true;
        }        
        if (isTie() == true){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder output = new StringBuilder("  ");
        
        /* Output the board contents as a string (see examples) */
        
        for (int row = 0; row < width; row++){
            for (int col = 0; col < width; col++){
                System.out.println("-");
            }
        }
        if (xTurn == true){
            System.out.println("Player 1 (X) Move");
        }
        if (xTurn == false){
            System.out.println("Player 2 (O) Move");   
        }

        System.out.println("Enter the row and column numbers, separated by a space:");
        
        return output.toString();
        
    }
    
}
