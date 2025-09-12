import java.util.Scanner;
public class Ship {
    Scanner a = new Scanner(System.in);
    private int length;

    public Ship(){
        //make it fair for players
        length = (int)(Math.random()*5+2);
    }
    public int getLength(){
        return length;
    }
}