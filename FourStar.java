import java.util.ArrayList;

public class FourStar extends Hotel {



    /**
     * Number of each of these rooms that are available
     */
    private int numExecutiveDouble;
    private int numExecutiveTwin;
    private int numExecutiveSingle;


    FourStar(ArrayList<Room> Rooms, int numExecutiveDouble,
             int numExecutiveTwin, int numExecutiveSingle )
    {
        this.Rooms = Rooms; // from Hotel
        this.numExecutiveDouble = numExecutiveDouble;
        this.numExecutiveTwin = numExecutiveTwin;
        this.numExecutiveSingle = numExecutiveSingle;
    }

    @Override
    public String toString() 
    {
        return "FourStar";
    }
}
