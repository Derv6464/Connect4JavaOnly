import java.util.Scanner;

public class connect4{
    public static void main(String[] args){
        String[][] arr = new String[6][7];
        boolean turn = true;
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<(arr.length+1);j++){
                arr[i][j] = " ";
            }
        }
        updateGrid(arr);
        while(true){
        System.out.println("Select a square");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        turn = insert(input, input, turn, arr);
        updateGrid(arr);

        }
    }

    static boolean insert(int input, int y,boolean turn,String[][] arr){
        int cnt = 0;
        while(arr[cnt][input-1] != " "){
            cnt += 1;
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
        for(int i = arr.length-1;i>-1;i--){
            System.out.println(arr[i][0] +" | "+ arr[i][1] +" | "+ arr[i][2] +" | "+ arr[i][3]+" | "+ arr[i][4] +" | "+ arr[i][5] +" | "+ arr[i][6] );
        }
        System.out.println("1   2   3   4   5   6   7");

    }

    public static boolean checkWin(boolean turn,int[][] arr) {
        if((horizontalWin(turn,arr))||(verticalWin(turn,arr))||(positiveDiagonalWin(turn,arr))||(negativeDiagonalWin(turn,arr))){
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean horizontalWin(boolean turn, int[][]arr) {
        int s;
        if(turn) {
            s = 1;
        }
        else {
            s = 2;
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
    public static boolean verticalWin(boolean turn, int[][]arr) {
        int s;
        if(turn) {
            s = 1;
        }
        else {
            s = 2;
        }
        for(int i = 0;i<7;i++) {
            for(int j = 0;j<3;j++) {
                if((arr[i][j] == s) && (arr[i][j+1] == s) && (arr[i][j+2] == s) && (arr[i][j+3] == s)) {
                    return true;
                }
            }
        }return false;
    }
    public static boolean positiveDiagonalWin(boolean turn, int[][]arr) {
        int s;
        if(turn) {
            s = 1;
        }
        else {
            s = 2;
        }
        for(int i = 0;i<4;i++) {
            for(int j = 3;j<7;j++) {
                if((arr[i][j] == s) && (arr[i+1][j+1] == s) && (arr[i+2][j+2] == s) && (arr[i+3][j+3] == s)) {
                    return true;
                }
            }
        }
        return false;

    }
    public static boolean negativeDiagonalWin(boolean turn, int[][]arr) {
        int s;
        if(turn) {
            s = 1;
        }
        else {
            s = 2;
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
