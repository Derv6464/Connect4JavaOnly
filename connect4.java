import java.util.Scanner;

public class connect4{
    public static void main(String[] args){
        String[][] arr = new String[7][6];
        boolean turn = true;
        for(int i = 0;i<7;i++){
            for(int j = 0;j<6;j++){
                arr[i][j] = " ";
            }
        }
        updateGrid(arr);
        while(true){
        System.out.println("Select a square");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        while(!checkWin(turn,arr)){
            turn = insert(input,  turn, arr);
            updateGrid(arr);
        }
        if(turn == true){
            System.out.println("Player 1 wins");
        }
        else{
            System.out.println("Player 2 wins");
        }

        }
    }

    static boolean insert(int input,boolean turn,String[][] arr){
        int cnt = 5;
        while(arr[cnt][input-1] != " "){
            cnt -= 1;
        }
        if(turn){
            arr[cnt][input-1] = "X";          
        }else{
            arr[cnt][input-1] = "O";           
        }
        turn = !turn;
        return turn;
    }

    static void updateGrid(String[][] arr){
        for(int i = 0;i<6;i++){
            System.out.println(arr[0][i] +" | "+ arr[1][i] +" | "+ arr[2][i] +" | "+ arr[3][i]+" | "+ arr[4][i] +" | "+ arr[5][i] +" | "+ arr[6][i] );
        }
        System.out.println("1   2   3   4   5   6   7");
    }

    public static boolean checkWin(boolean turn,String[][] arr) {
        if((horizontalWin(turn,arr))||(verticalWin(turn,arr))||(positiveDiagonalWin(turn,arr))||(negativeDiagonalWin(turn,arr))){
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean horizontalWin(boolean turn, String[][]arr) {
        String s;
        if(turn) {
            s = "X";
        }
        else {
            s = "O";
        }
        for(int i = 0;i<4;i++) {
            for(int j = 0;j<6;j++) {
                if((arr[i][j] == s) && (arr[i+1][j] == s) && (arr[i+2][j] == s) && (arr[i+3][j] == s)) {
                    return true;
                }
            }
        }
        return false;
     }
    public static boolean verticalWin(boolean turn, String[][]arr) {
        String s;
        if(turn) {
            s = "X";
        }
        else {
            s = "O";
        }
        for(int i = 0;i<7;i++) {
            for(int j = 0;j<3;j++) {
                if((arr[i][j] == s) && (arr[i][j+1] == s) && (arr[i][j+2] == s) && (arr[i][j+3] == s)) {
                    return true;
                }
            }
        }return false;
    }
    public static boolean positiveDiagonalWin(boolean turn, String[][]arr) {
        String s;
        if(turn) {
            s = "X";
        }
        else {
            s = "O";
        }
        for(int i = 0;i<4;i++) {
            for(int j = 3;j<6;j++) {
                if((arr[i][j] == s) && (arr[i+1][j+1] == s) && (arr[i+2][j+2] == s) && (arr[i+3][j+3] == s)) {
                    return true;
                }
            }
        }
        return false;

    }
    public static boolean negativeDiagonalWin(boolean turn, String[][]arr) {
        String s;
        if(turn) {
            s = "X";
        }
        else {
            s = "O";
        }
        for(int i = 0;i<4;i++) {
            for(int j = 0;j<3;j++) {
                if((arr[i][j] == s) && (arr[i-1][j-1] == s) && (arr[i-2][j-2] == s) && (arr[i-3][j-3] == s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
