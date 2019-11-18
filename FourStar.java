import java.util.ArrayList;

/**
 *
 * @author The bois
 */
public class FourStar extends Hotel {

    /**
     * Number of each of these rooms that are available
     */
    int numExecutiveDouble;
    int numExecutiveTwin;
    int numExecutiveSingle;

    /**
     *
     * @param numberOfRooms
     * @param Rooms
     * @param numExecutiveDouble
     * @param numExecutiveTwin
     * @param numExecutiveSingle
     */
    FourStar(int numberOfRooms, ArrayList<Room> Rooms, int numExecutiveDouble,
             int numExecutiveTwin, int numExecutiveSingle )
    {
        this.numberOfRooms = numberOfRooms; // from Hotel
        this.Rooms = Rooms; // from Hotel

        this.numExecutiveDouble = numExecutiveDouble;
        this.numExecutiveTwin = numExecutiveTwin;
        this.numExecutiveSingle = numExecutiveSingle;
    }

    FourStar(String description)
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

