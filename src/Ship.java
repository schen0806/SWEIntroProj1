import java.util.Scanner;
public class Ship {
    Scanner a = new Scanner(System.in);
    private int length = (int)(Math.random()*3+2);

    public int getLength(){
        return length;
    }
}