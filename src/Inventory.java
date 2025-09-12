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
    //print out the length of the ships(data for inventory)
    public int[] getInventory() {
        int[] data = new int[ships.size()];
        for (int i = 0; i < ships.size(); i++) {
            data[i] = ships.get(i).getLength();
        }
        return data;
    }

    public int getSize(){
        return size;
    }

    //prints out the ships in the inventory
    public String printInventory(){
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < size; i++){
            // length of ships[2-5 units:
            text.append(ships.get(i).getLength()).append(", ");
        }
        return text.toString();
    }
}