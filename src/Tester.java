
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Tester {
    public static void main(String[] args) {
        Board board1 = new Board(new Inventory(),"a");
        board1.printBoard();
        board1.deploy();
        board1.printBoard();
    }
}