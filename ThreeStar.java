import java.util.ArrayList;

/**
 *
 * @author The bois
 */
public class ThreeStar extends Hotel {

    /**
     * Number of each of these rooms that are available
     */
    int numClassicDouble;
    int numClassicTwin;
    int numClassicSingle;

    /**
     *
     * @param numberOfRooms
     * @param Rooms
     * @param numClassicDouble
     * @param numClassicTwin
     * @param numClassicSingle
     */
    ThreeStar(int numberOfRooms, ArrayList<Room> Rooms, int numClassicDouble,
              int numClassicTwin, int numClassicSingle )
    {
        this.numberOfRooms = numberOfRooms; // from Hotel
        this.Rooms = Rooms; // from Hotel

        this.numClassicDouble = numClassicDouble;
        this.numClassicTwin = numClassicTwin;
        this.numClassicSingle = numClassicSingle;
    }


    ThreeStar(String description)
    {

    }










    //// to do later
//    @Override
//    public String toString()
//    {
//        return some strings;
//    }
//
}import java.util.ArrayList;


/**
 *
 * @author The bois
 */
public class ThreeStar extends Hotel {
    
    @Override
    public String toString() {
        return "ThreeStar";
    }
    
    

    /**
     * Number of each of these rooms that are available
     */
    int numClassicDouble;
    int numClassicTwin;
    int numClassicSingle;


    ThreeStar(int numberOfRooms, ArrayList<Room> Rooms, int numClassicDouble,
              int numClassicTwin, int numClassicSingle )
    {
        this.numberOfRooms = numberOfRooms; // from Hotel
        this.Rooms = Rooms; // from Hotel

        this.numClassicDouble = numClassicDouble;
        this.numClassicTwin = numClassicTwin;
        this.numClassicSingle = numClassicSingle;
    }


    ThreeStar(String description)
    {

    }

}

