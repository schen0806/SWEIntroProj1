import java.util.ArrayList;
//Z means ships put on board
//O means miss
//X means hit
//line of X according to ship length = sink
import java.util.Scanner;
public class Board{
    Scanner s = new Scanner(System.in);
    private String[][] board;
    private String playerName;
    private Inventory inventory;
    private String [][] Oboard;

    public Board(Inventory inventory, String playerName){
        board = new String[10][10];
        Oboard = new String[10][10];
        //initializes the inventory and number
        this.inventory = inventory;
        this.playerName = playerName;

        //sets the board values
        //x
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++ ){
                board[i][j] = "o";
            }
        }
        //y
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++ ){
                Oboard[i][j] = "o";
            }
        }
    }

    //prints the board
    public void printBoard(){
        for (int i = 0; i < 10; i++){
            System.out.print(Tester.num2Let(i)+"|");
            for (int j = 0; j < 10; j++ ){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();

        }
        System.out.println("-|-------------------");
        System.out.println(" |0 1 2 3 4 5 6 7 8 9");
    }

    //for players to deploy their ship at the start of the game
    public void deploy(){
        System.out.println("Player "+playerName+", it's your time to deploy your battleships. Here's the current board:");
        printBoard();

        int currentShipLength;
        //loop through inventory
        for (int i = 0; i < inventory.getSize(); i++){
            int currentShipLength;
            int direction =-1;
            int x = -1;
            int y = -1;
            int tailx = 0;
            int taily = 0;
            //validate the direction input
            for(int j = 0; j < 5; j++){
                boolean valid = false;
                while (!valid){
                    System.out.println("Ship length: (type in 2 - 6): ");
                    currentShipLength = s.nextInt();
                    if (/*requirements meets */ currentShipLength > 6 || currentShipLength < 2){
                        System.out.println("Invalid ship length. Try again");
                        valid = true;
                    }
                    else{
                        System.out.println("Do you want to place it vertically (0) or horizontally? (1): ");
                        direction = s.nextInt();
                        if (direction == 1 || direction == 0) {
                            System.out.println("Where would you put it? Enter the top-left corner x-coordinate (0-9) (the top-left of the entire board is [0,0]");
                            x = s.nextInt();
                            System.out.println("Where would you put it? Enter the top-left corner y-coordinate (0-9) (the top-left of the entire board is [0,0]");
                            y = s.nextInt();
                            if (direction == 0) {
                                taily = y + currentShipLength - 1;
                                tailx = x;
                            }
                            else {
                                tailx = x + currentShipLength - 1;
                                taily = y;
                            }
                        }
                        else{
                            System.out.println("Invalid input!!!");
                            System.out.println("Do you want to place it vertically (0) or horizontally? (1)  ");
                            direction = s.nextInt();
                        }
                    }
                }
            }
        }

            //validate the coordinate.
        boolean validCoordinate = false;
        while (!validCoordinate){

                //System.out.print("DEBUG x="+x+", y="+y+", tailx="+tailx+", taily="+taily);
                //System.out.println();

                //if statements
                //if the starting point is in the board
            if (!(x < 0 || y < 0 || x > 10 || y > 10)){
                    if (!(tailx < 0 || taily < 0 || tailx > 10 || taily > 10)){
                        boolean a = true;
                        //if any parts of the ship collated other ships, invalid
                        for (int j = x; j < tailx+1; j++){
                            for (int n = y; n < taily; n++){
                                if (board[j][n].equals("Z")) {
                                    a = false;
                                    break;
                                }
                            }
                        }
                        if (a){
                            validCoordinate = true;
                        }
                    }
                }
                if (!validCoordinate){
                    System.out.println("Invalid coordinate. Try again.");
                }
            }
            //putting the ships down on the coordinates
            for (int j = x; j <= tailx; j++){
                for (int n = y; n <= taily; n++){
                    board[n][j] = "Z";
                }
            }
            //System.out.println(tailx+", "+taily+", "+ x+", "+y+", ");
            printBoard();
            System.out.println("This is what the current board looks like");
        }
    }

    public int getShipsLeft(){
        int num = 0;
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if (board[i][j].equals("Z")){
                    num++;
                }
            }
        }
        return num;
    }

    public String getName(){
        return playerName;
    }

    public boolean getShoot(int x, int y){
        //f=missed; t=got hit
        //opponent from the Game method choose location to attack:(x(0-10), y(0-10))
        boolean result = board[x][y].equals("Z");
        if(result){
            board[x][y] = "X";
        }
        return result;
    }

    public void recordHit(int x, int y, boolean result){
        if (result){
            //if hit ship
            Oboard[x][y] = "X";
        }
        else{
            //if no
            Oboard[x][y] = "Z";
        }
    }

    public boolean canHit(int x, int y){
        //if hit before
        //System.out.println("hit before");
        //System.out.println(Oboard[x][y]);
        if (!(x < 10 && y < 10 && x >= 0 && y >= 0)){
            //if out of bounds
            return false;
        }
        else return Oboard[x][y].equals("o");
    }

    public void printOboard(){
        for (int i = 0; i < 10; i++){
            System.out.print(Tester.num2Let(i)+"|");
            for (int j = 0; j < 10; j++ ){
                System.out.print(Oboard[i][j]+" ");
            }
            System.out.println();

        }
        System.out.println("-|-------------------");
        System.out.println(" |0 1 2 3 4 5 6 7 8 9");
    }
}