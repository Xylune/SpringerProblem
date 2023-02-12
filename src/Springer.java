import java.util.Scanner;

public class Springer {

    int STEP = 0;

    static int n;
    int[][] chessBoard;

    public Springer(int n){
        chessBoard = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                chessBoard[i][j] = STEP;
            }
        }
    }

    public void printBoard(){
        for (int i = 0; i < chessBoard.length; i++){
            for (int j = 0; j < chessBoard.length; j++){
                System.out.print(chessBoard[i][j] + "\t");
            }
            System.out.println();
        }
    }

    boolean findPath(int row, int column){

        if (STEP + 1 == n*n){
            chessBoard[row][column] = ++STEP;
            return true;
        }

        chessBoard[row][column] = ++STEP;

        int dI[] = {  1,  -1,  1, -1, 2, -2 , 2, -2};
        int dJ[] = {  2,  2, -2,  -2, 1, 1, -1, -1};

        for (int k = 0 ; k < 8; k++){
            int nyI = row + dI[k];
            int nyJ = column + dJ[k];

            if (nyI >=0 && nyI < n && nyJ >=0 && nyJ < n && chessBoard[nyI][nyJ] == 0){
                if (findPath(nyI, nyJ)){
                    return true;
                }
            }
        }
        STEP--;
        chessBoard[row][column] = 0;

        return false;
    }



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Chessboard size?: ");
        n = scanner.nextInt();
        System.out.print("Start row?(1 - " + n +"): ");
        int row = scanner.nextInt() - 1;
        System.out.print("Start column?(1 - " + n +"): ");
        int column = scanner.nextInt() - 1;

        Springer board = new Springer(n);
        boolean foundSolution = board.findPath(row, column);
        if (!foundSolution){
            System.out.println("Found no solution");
        } else {
            System.out.println();
            board.printBoard();

        }

    }
}
