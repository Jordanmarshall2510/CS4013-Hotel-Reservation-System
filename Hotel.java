import java.util.ArrayList;

/**
 *
 * @author Dermot
 */
public abstract class Hotel {

    /**
     *
     */
    protected int numberOfRooms; // Each hotel type uses its own

    /**
     *
     */
    protected ArrayList<Room> Rooms = new ArrayList<>(); // Each hotel type uses its own

    /**
     *
     * @return
     */
    public int getNumberOfRooms() 
    {
        return numberOfRooms;
    }

    /**
     *
     * @param numberOfRooms
     */
    public void setNumberOfRooms(int numberOfRooms) 
    {
        this.numberOfRooms = numberOfRooms;
    }

    /**
     *
     * @return
     */
    public ArrayList<Room> getRooms() 
    {
        return Rooms;
    }

    /**
     *
     * @param Rooms
     */
    public void setRooms(ArrayList<Room> Rooms) 
    {
        this.Rooms = Rooms;
    }

}
