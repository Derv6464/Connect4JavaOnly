import java.util.Scanner;
public class connect4{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[][] arr = new String[7][6];
        boolean turn = true;
        for(int i = 0;i<7;i++){
            for(int j = 0;j<6;j++){
                arr[i][j] = " ";
            }
        }
        updateGrid(arr);
        while(!checkWin(turn,arr)){
            System.out.println("Select a square");
            
            int input = in.nextInt();
            while(!checkInput(arr,input)){
                System.out.println("You can't select here, select another square");
                input = in.nextInt();
            }

            turn = insert(input, turn, arr);
            updateGrid(arr);

        }
        if(turn){
            System.out.println("Player 2 wins");
        }else{
            System.out.println("Player 1 wins");
        }
    }

    static boolean insert(int input, boolean turn,String[][] arr){
        int cnt = 0;
        while(arr[input-1][cnt] != " "){
            cnt += 1;
        }
        if(turn){
            arr[input-1][cnt] = "X";          
        }else{
            arr[input-1][cnt] = "O";           
        }
        turn = !turn;
        return turn;
    }

    static boolean checkInput(String[][] arr,int input){
        int cnt = 0;
        if(input >7 || input < 1){
            return false;
        }
        
        while(cnt < 6 && arr[input-1][cnt] != " " ){
            cnt += 1;
        }
        System.out.println(cnt);
        if (cnt > 5){
            return false;
        }
        return true;
    }

    static void updateGrid(String[][] arr){
        for(int i = 5;i>-1;i--){
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
        if(!turn) {
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
        if(!turn) {
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
        if(!turn) {
            s = "X";
        }
        else {
            s = "O";
        }
        for(int i = 0;i<4;i++) {
            for(int j = 3;j<6;j++) {
                if((arr[i][j] == s) && (arr[i+1][j-1] == s) && (arr[i+2][j-2] == s) && (arr[i+3][j-3] == s)) {
                    return true;
                }
            }
        }
        return false;

    }
    public static boolean negativeDiagonalWin(boolean turn, String[][]arr) {
        String s;
        if(!turn) {
            s = "X";
        }
        else {
            s = "O";
        }

        for(int i = 0;i<4;i++) {
            for(int j = 0;j<3;j++) {
                if((arr[i][j] == s) && (arr[i+1][j+1] == s) && (arr[i+2][j+2] == s) && (arr[i+3][j+3] == s)) {
                    return true;
                }
            }
        }
        return false;
    }
}