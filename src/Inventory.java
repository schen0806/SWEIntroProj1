import java.util.ArrayList;
public class Inventory {
    private ArrayList<Ship> ships;
    private int size;
    public Inventory() {
        size = 1;
        ships = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ships.add(new Ship());
        }
    }
    //enable the user to choose ship length

    //print out the length of the ships(data for inventory)
    public void printInventory(int starting) {
        for (int i = starting; i < ships.size(); i++) {
            System.out.print(ships.get(i).getLength()+" ");
        }
        System.out.println();
    }
    public int getSize() {
        return size;
    }

    public int getShip(int num){return ships.get(num).getLength();}

}