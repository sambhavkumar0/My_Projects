import java.util.Arrays;
import java.util.Scanner;

public class Main{
 public static void main(String[] args) {
    char[][] board=new char[3][3];
    for(int row=0;row<board.length;row++){
        for(int col=0;col<board.length;col++){
            board[row][col] = ' ';
    }
 }
 char player='X';
 boolean gameOver=false;
 Scanner sc=new Scanner(System.in);
 while(!gameOver){
    printBoard(board);

     if(!haveWon(board, player)&& isBoardFull(board)){
        System.out.println("Game Draw");
        break;
    }
    System.out.print("Player "+player+" enter: ");
    int row=sc.nextInt();
    int col=sc.nextInt();
    System.out.println();
   

    if(board[row][col] == ' '){
       board[row][col] = player;
       gameOver=haveWon(board,player);
       if(gameOver){
        System.out.println("player "+player+" has won the game");

    }else{
        player=(player=='X')?'O':'X';

    }
}
else{
    System.out.println("Invalid move. Please try Again!");
}
 }
 printBoard(board);
 }

public static boolean haveWon(char[][] board,char player){
    //check rows
    for(int row=0;row<board.length;row++){
        if(board[row][0]==player && board[row][1]==player && board[row][2]==player){
            return true;
        }
    }
    //check columns
     for(int col=0;col<board[0].length;col++){
        if(board[0][col]==player && board[1][col]==player && board[2][col]==player){
            return true;
        }
    }

    //diagonals
     
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
            return true;
        }
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
            return true;
        }
return false;
    
}

public static void printBoard(char[][] board){
     for(int row=0;row<board.length;row++){
        for(int col=0;col<board.length;col++){
            
            System.out.print( board[row][col] + " | ");
    }
    System.out.println();
 }
}

public static boolean isBoardFull(char board[][]){
    for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
            if(board[j][i]==' '){
                return false;
            }
    }
}
return true;



}
}
