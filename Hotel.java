import java.util.ArrayList;


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
