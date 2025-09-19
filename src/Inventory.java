import java.util.ArrayList;
public class Inventory {
    private ArrayList<Ship> ships;
    private int size;
    public Inventory() {
        size = 5;
        ships = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ships.add(new Ship());
        }
    }
    //enable the user to choose ship length

    //print out the length of the ships(data for inventory)
    public void printInventory() {
        for (int i = 0; i < ships.size(); i++) {
            System.out.println(ships.get(i).getLength()+" ");
        }
    }
    public int getSize() {
        return size;
    }
}