import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        boolean GameOn = true;
        Scanner s = new Scanner(System.in);
        Inventory inventory = new Inventory();
        System.out.println("The first player's name:");
        Board player1 = new Board(inventory, s.nextLine());
        System.out.println("The second player's name:");
        Board player2 = new Board(inventory, s.nextLine());
        //initializing
        System.out.println("Now leave the device to " + player1.getName() + " for deploying. Press enter to continue.");
        s.nextLine();
        player1.deploy();
        System.out.println("Now leave the device to " + player2.getName() + " for deploying. Press enter to continue.");
        s.nextLine();
        player2.deploy();

        int round = 1;
        while (GameOn) {
            //two alternating players
            Board currentPlayer;
            Board opponent;
            if (round % 2 == 1) {
                currentPlayer = player1;
                opponent = player2;
            } else {
                currentPlayer = player2;
                opponent = player1;
            }
            System.out.println("Leave the device to "+currentPlayer.getName()+", because its his turn to attack.");
            s.nextLine();
            System.out.println("Here's the note you took of the opponent's board:");
            System.out.println("--------------");
            currentPlayer.printOboard();
            System.out.println("--------------");

            int x = -1;
            int y = -1;

            //test if valid (and if the location have been hit before)
            boolean valid = false;
            while (!valid) {
                System.out.println("Where do you want to attack on " + opponent.getName() + "? Enter the x axis(0-9)");
                y = s.nextInt();
                System.out.println("Enter y axis(0-9)");
                x = s.nextInt();
                valid = currentPlayer.canHit(x, y);
                //System.out.println(valid);
                //if still not valid
                if (!valid) {
                    System.out.println("You've already hit that place before/out of bounds!");
                }
            }
            //if valid, run
            boolean result = opponent.getShoot(x, y);
            currentPlayer.recordHit(x, y, result);
            //if hit ship
            if (result) {
                System.out.println("Congratulations! You hit your opponent's ship!");
                //System.out.println(opponent.getShipsLeft());
            }
            currentPlayer.printOboard();
            if (opponent.getShipsLeft() <= 0) {
                System.out.println(currentPlayer.getName() + ", you sunk the last ship of " + opponent.getName() + ", you win!");
                System.out.println("Game Over");
                GameOn = false;
            }
            round++;
        }
    }
}