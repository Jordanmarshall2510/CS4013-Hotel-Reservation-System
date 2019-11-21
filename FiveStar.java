import java.util.ArrayList;

public class FiveStar extends Hotel {

    @Override
    public String toString() {
        return "FiveStar";
    }

    /**
     * Number of each of these rooms that are available
     */
    int numDeluxeDouble;
    int numDeluxeTwin;
    int numDeluxeSingle;
    int numDeluxeFamily;


    FiveStar(int numberOfRooms, ArrayList<Room> Rooms, int numDeluxeDouble,
             int numDeluxeTwin, int numDeluxeSingle, int numDeluxeFamily) {
        this.numberOfRooms = numberOfRooms; // from Hotel
        this.Rooms = Rooms; // from Hotel

        this.numDeluxeDouble = numDeluxeDouble;
        this.numDeluxeTwin = numDeluxeTwin;
        this.numDeluxeSingle = numDeluxeSingle;
        this.numDeluxeFamily = numDeluxeFamily;
    }

    FiveStar(String description)
    {

    }

}
