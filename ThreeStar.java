import java.util.ArrayList;

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
