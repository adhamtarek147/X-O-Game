import java.util.*;
import java.awt.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Game game=new Game();
        game.run();



    }
}
class Board
{
    private final int SIZE=3;
   private char[][] board=new char[3][3];


    //constructor
    public Board() {
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                board[i][j]=' ';
            }
        }

    }


    //display_board method
    public void display_board()
    {


        System.out.println(board[0][0] + "|" + board[0][1]+ "|" + board[0][2]);
        System.out.println(board[1][0] + "|" + board[1][1]+ "|" + board[1][2]);
        System.out.println(board[2][0] + "|" + board[2][1]+ "|" + board[2][2]);
        System.out.println("\n");

    }


    //update_board method
    public boolean update_board(int x , int y , char symbol)
    {
        if((x>=0 && x<=2) && (y>=0 && y<=2))
        {
            board[x][y]=symbol;
            return true;

        }
        else {
            return false;
        }
    }


     //is_winner method
    public boolean is_winner(char symbol)
    {
        if((board[0][0]==symbol && board[0][1]==symbol && board[0][2]==symbol) || (board[1][0]==symbol && board[1][1]==symbol && board[1][2]==symbol) || (board[2][0]==symbol && board[2][1]==symbol && board[2][2]==symbol) || (board[0][0]==symbol && board[1][0]==symbol && board[2][0]==symbol) || (board[0][1]==symbol && board[1][1]==symbol && board[2][1]==symbol) || (board[0][2]==symbol && board[1][2]==symbol && board[2][2]==symbol) || (board[0][0]==symbol && board[1][1]==symbol && board[2][2]==symbol) || (board[0][2]==symbol && board[1][1]==symbol && board[2][0]==symbol))
        {
            return true;
        }
        return false;
    }


    //is_draw method
    public boolean is_draw()
    {
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                if(board[i][j]==' ')
                {
                    return false;
                }
            }
        }
        return true;
    }


}


class Player {
    private String name;
    private char symbol;
    Board board;

    public Player(String nm, char smbl,Board grid) {
        this.name = nm;
        this.symbol = smbl;
        board=grid;
    }

    public void get_move() {

        System.out.println("Choose a number from 1-9: ");
        Scanner in = new Scanner(System.in);
        int move = in.nextInt();
        switch (move) {
            case 1:
                board.update_board(0, 0, 'x');
                break;
            case 2:
                board.update_board(0, 1, symbol);
                break;
            case 3:
                board.update_board(0, 2, symbol);
                break;
            case 4:
                board.update_board(1, 0, symbol);
                break;
            case 5:
                board.update_board(1, 1, symbol);
                break;
            case 6:
                board.update_board(1, 2, symbol);
                break;
            case 7:
                board.update_board(2, 0, symbol);
                break;
            case 8:
                board.update_board(2, 1, symbol);
                break;
            case 9:
                board.update_board(2, 2, symbol);
                break;
        }


    }
    public String get_name()
    {
        return this.name;
    }
    public char get_symbol()
    {
        return this.symbol;
    }
}
class Game
{
   private int turn;
    Board board=new Board();
   Player player1=new Player("Adham",'x',board);
   Player player2=new Player("Adam",'o',board);


   public Game()
   {




   }
   public void run()
   {
       while(true)
       {
           board.display_board();
           player1.get_move();
           if(board.is_winner(player1.get_symbol())==true)
           {
               board.display_board();
               System.out.println(player1.get_name()+" is the winner\n");
               break;
           }
           else if(board.is_draw()==true)
           {
               board.display_board();
               System.out.println("DRAW!\n");
               break;
           }



           board.display_board();
           player2.get_move();
           if(board.is_winner(player2.get_symbol())==true)
           {
               board.display_board();
               System.out.println(player2.get_name()+" is the winner");
               break;
           }
            else if(board.is_draw()==true)
            {
                board.display_board();
                System.out.println("DRAW!\n");
                break;
            }
       }


   }

}
