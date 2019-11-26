import java.util.ArrayList;

public class FiveStar extends Hotel {



    /**
     * Number of each of these rooms that are available
     */
    private int numDeluxeDouble;
    private int numDeluxeTwin;
    private int numDeluxeSingle;
    private int numDeluxeFamily;


    FiveStar(ArrayList<Room> Rooms, int numDeluxeDouble,
             int numDeluxeTwin, int numDeluxeSingle, int numDeluxeFamily) 
    {

        this.Rooms = Rooms; // from Hotel

        this.numDeluxeDouble = numDeluxeDouble;
        this.numDeluxeTwin = numDeluxeTwin;
        this.numDeluxeSingle = numDeluxeSingle;
        this.numDeluxeFamily = numDeluxeFamily;
    }

    FiveStar()
    {
        super.Rooms = null;
        this.numDeluxeDouble = 0;
        this.numDeluxeFamily = 0;
        this.numDeluxeSingle = 0;
        this.numDeluxeTwin = 0;
    }

    @Override
    public String toString() 
    {
        return "FiveStar";
    }
}
