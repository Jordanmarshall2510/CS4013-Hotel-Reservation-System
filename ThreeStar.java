import java.util.ArrayList;

public class ThreeStar extends Hotel {

    /**
     * Number of each of these rooms that are available
     */
    private int numClassicDouble;
    private int numClassicTwin;
    private int numClassicSingle;


    ThreeStar(ArrayList<Room> Rooms, int numClassicDouble,
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

    /**
     *
     * @return 
     */
    public int getNumClassicDouble() 
    {
        return numClassicDouble;
    }

    /**
     *
     * @param numClassicDouble
     */
    public void setNumClassicDouble(int numClassicDouble) 
    {
        this.numClassicDouble = numClassicDouble;
    }

    /**
     *
     * @return
     */
    public int getNumClassicTwin() 
    {
        return numClassicTwin;
    }

    /**
     *
     * @param numClassicTwin
     */
    public void setNumClassicTwin(int numClassicTwin) 
    {
        this.numClassicTwin = numClassicTwin;
    }

    /**
     *
     * @return
     */
    public int getNumClassicSingle() 
    {
        return numClassicSingle;
    }

    /**
     *
     * @param numClassicSingle
     */
    public void setNumClassicSingle(int numClassicSingle) 
    {
        this.numClassicSingle = numClassicSingle;
    }
    
    
    @Override
    public String toString() 
    {
        return "ThreeStar";
    }

}
