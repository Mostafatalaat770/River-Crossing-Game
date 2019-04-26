package Boat;

/**
 * @author Mostafa Talaat
 */
public class Boat {

    private int capacity;
    private boolean full;
    private static Boat ourInstance = new Boat();

    private Boat() {
        capacity = 0;
        full = false;
    }

    public static Boat getInstance() {
        return ourInstance;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }
}
