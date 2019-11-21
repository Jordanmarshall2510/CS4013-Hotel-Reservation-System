import java.util.ArrayList;

public class FourStar extends Hotel {

    @Override
    public String toString() {
        return "FourStar";
    }

    /**
     * Number of each of these rooms that are available
     */
    int numExecutiveDouble;
    int numExecutiveTwin;
    int numExecutiveSingle;


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

}
