


public class QuennChess {
    /**
     * Imrpime no console uma matriz de dados a partir rows e coums;
     * 
     * @param matriz matriz de interios (ex: int[][] Matriz)
     * @param rows linhas a serem imprimidas (ex int[2][1] => int linhas 2)
     * @param colums colunas a serem imprimidas (ex int[2][1] => int colunas 1)
     */
    public static void printBoard(int[][] matriz, int rows, int colums){
        for(int i = 0; i < rows; i++){
            System.out.print("|");

            for(int j =0; j < colums;j++){
                System.out.print(matriz[i][j]+"|");
            }

            System.out.print("\n");
        }
    }
    /**
     * print in console a new matrix made from the diferences betwen 2
     * 
     * @param oldMatrix
     * @param newMatrix
     * @param rows
     * @param colums
     */
    public static void printBoardChanges(int[][] oldMatrix, int[][]newMatrix, int rows, int colums){
        int[][] printingMatrix = new int[rows][colums];
        for(int i = 0; i < rows; i++){
            for(int j =0; j < colums;j++){
                if(oldMatrix[i][j] != newMatrix[i][j]){
                    printingMatrix[i][j] += 1;
                }
            }
        }
        printBoard(printingMatrix, rows, colums);
    }

    public static int[][] board(int rows, int colums){ 
        int[][] board = new int[rows][colums];
        
        for(int i = 0; i < rows; i++){
            for(int j =0; j < colums;j++){
                board[i][j] = 0;
            }
        }
        return board;
    }
    public static int[][] copyMatrix(int[][] targetMatrix, int rows, int colums){
        int[][] newMatrix = new int[rows][colums];
        for(int i = 0; i < rows; i++){
            for(int j =0; j < colums;j++){
                newMatrix[i][j] = targetMatrix[i][j];
            }
        }
        return newMatrix;
    }

    public static int[][] quennChess(int rows, int colums){
        int[][] queenatk = new int[rows][colums];
        int[][] lastMatrix = copyMatrix(queenatk, rows, colums);
        int steps = 0;
        for(int i = 0; i < rows; i++){
            for(int j =0; j < colums;j++){
                steps++;
                
                //percorre a linha:
                for(int k = 0;k<colums;k++){
                    queenatk[i][k] +=1;
                }
                //percorre a coluna:
                for(int l = 0; l<rows;l++){
                    queenatk[l][j] +=1;
                    
                }

                queenatk[i][j] -=1;

                int d=i,g=j;
                //Diagonas de baixo direita:

                while(true){
                    try{
                        queenatk[d][g] += 1;
                    } catch(Exception e){
                        System.out.print("Erro"+e.getMessage());
                    }
                    if(d > rows-1 || g > colums-1){
                        break;
                    }
                    d++;
                    g++;
                    
                }
                queenatk[i][j] -= 1;

                //Diagonal baixo esquerda:
                boolean dbe=true;
                //resetando variaveis diagonais fora do loop
                d = i;
                g = j;
                while(dbe){
                    //subindo:
                    try {
                        queenatk[d][g] += 1;
                    } catch (Exception e) {
                        System.out.print("error: "+e.getMessage());
                    }
                    if(d > rows-1 || g > colums-1){
                        dbe = false;
                    }
                    d++;
                    g--;
                }
                queenatk[i][j] -= 1;


                System.out.printf("\nBoard "+steps+"\n");
                printBoard(queenatk, rows, colums);
                System.out.printf("\n==========\nQueen position: "+i+"|"+j+"\n");
                printBoardChanges(queenatk, lastMatrix, rows, colums);
                lastMatrix = copyMatrix(queenatk, rows, colums);
            }
        }
        return queenatk;
    }
        
    public static void main(String[] args){
        int r=4, c=4;
        
        quennChess(r, c);
    }
}