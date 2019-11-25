import java.util.ArrayList;

public abstract class Hotel {

    protected int numberOfRooms; // Each hotel type uses its own

    protected ArrayList<Room> Rooms = new ArrayList<>(); // Each hotel type uses its own

    public int getNumberOfRooms() 
    {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) 
    {
        this.numberOfRooms = numberOfRooms;
    }

    public ArrayList<Room> getRooms() 
    {
        return Rooms;
    }

    public void setRooms(ArrayList<Room> Rooms) 
    {
        this.Rooms = Rooms;
    }

}
