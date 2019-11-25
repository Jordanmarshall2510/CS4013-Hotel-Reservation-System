import java.util.ArrayList;

/**
 *
 * @author Dermot
 */
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

    /**
     *
     * @return
     */
    public int getNumDeluxeFamily() 
    {
        return numDeluxeFamily;
    }

    /**
     *
     * @param numDeluxeFamily
     */
    public void setNumDeluxeFamily(int numDeluxeFamily) 
    {
        this.numDeluxeFamily = numDeluxeFamily;
    }

    /**
     *
     * @return
     */
    public int getNumDeluxeDouble() 
    {
        return numDeluxeDouble;
    }

    /**
     *
     * @param numDeluxeDouble
     */
    public void setNumDeluxeDouble(int numDeluxeDouble) 
    {
        this.numDeluxeDouble = numDeluxeDouble;
    }

    /**
     *
     * @return
     */
    public int getNumDeluxeTwin() 
    {
        return numDeluxeTwin;
    }

    /**
     *
     * @param numDeluxeTwin
     */
    public void setNumDeluxeTwin(int numDeluxeTwin) 
    {
        this.numDeluxeTwin = numDeluxeTwin;
    }

    /**
     *
     * @return
     */
    public int getNumDeluxeSingle() 
    {
        return numDeluxeSingle;
    }

    /**
     *
     * @param numDeluxeSingle
     */
    public void setNumDeluxeSingle(int numDeluxeSingle) 
    {
        this.numDeluxeSingle = numDeluxeSingle;
    }
    
    @Override
    public String toString() 
    {
        return "FiveStar";
    }
}
