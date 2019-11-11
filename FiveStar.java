import java.util.ArrayList;

/**
 *
 * @author The bois
 */
public class FiveStar extends Hotel {

    /**
     * Number of each of these rooms that are available
     */
    int numDeluxeDouble;
    int numDeluxeTwin;
    int numDeluxeSingle;
    int numDeluxeFamily;

    /**
     * @param numberOfRooms
     * @param Rooms
     * @param numDeluxeDouble
     * @param numDeluxeTwin
     * @param numDeluxeSingle
     * @param numDeluxeFamily
     */
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









    //// to do later
//    @Override
//    public String toString()
//    {
//        return some strings;
//    }
//
}
