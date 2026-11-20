public class ChessSimulator {
    /**
     * Create an board from board name and a two integers;
     * 
     * Board
     * 
     */

    public class Board{
        private Piece[][] grid;
        private int x;
        private int y;
        private String name;
        Piece StarterPiece = new Piece("Clear", 'O');
        private boolean printName = true;

        Board(String name, int rows, int colums){
            this.grid = new Piece[rows][colums];
            this.name = name;
            this.x = rows;
            this.y = colums;
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < colums; j++){
                    this.grid[i][j] = StarterPiece;
                }
            }
        }
        /**
         * Print an entyre board based into its objects
         * 
         * @param a boolean defines board display (ex: true|Clear / false|C)
         */
        void printBoard_pname(boolean a){
            this.printName = a;
            System.out.printf("Board Name: "+this.name);
            for(int i = 0; i < this.x; i++){
                System.out.print("\n|");
                for(int j = 0; j < this.y; j++){
                    System.out.print(this.printName?this.grid[i][j].name+"|":this.grid[i][j].simbol+"|");
                }
            }
        }

        boolean isInBoard(int a, int b){
            return a >= 0 && a < this.x && b >= 0 && b < this.y;
        }
        
        public @Override String toString(){
            return String.valueOf(this.grid);
        }
    }
    class Piece{
        public String name;
        private char simbol;
        private boolean printName = false;
        Piece(String name, char simbol){
            this.name = name;
            this.simbol = simbol;
        }
    }

    public void main(String[] args){
        Board tictactoe = new Board("3x3", 3, 3);
        tictactoe.printBoard_pname(false);
        
        /* test for isInBoard: 
        for(int i = -2; i <  4; i++){
            for(int j = -2; j < 4; j++){
                System.out.printf("\n "+i+"| "+j+": "+tictactoe.isInBoard(i, j));
            }
        }*/

        
    }
}