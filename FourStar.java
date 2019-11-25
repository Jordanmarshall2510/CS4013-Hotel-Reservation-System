import java.util.ArrayList;

/**
 *
 * @author Dermot
 */
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

    FourStar(String description)
    {

    }

    /**
     *
     * @return
     */
    public int getNumExecutiveDouble() 
    {
        return numExecutiveDouble;
    }

    /**
     *
     * @param numExecutiveDouble
     */
    public void setNumExecutiveDouble(int numExecutiveDouble) 
    {
        this.numExecutiveDouble = numExecutiveDouble;
    }

    /**
     *
     * @return
     */
    public int getNumExecutiveTwin() 
    {
        return numExecutiveTwin;
    }

    /**
     *
     * @param numExecutiveTwin
     */
    public void setNumExecutiveTwin(int numExecutiveTwin) 
    {
        this.numExecutiveTwin = numExecutiveTwin;
    }

    /**
     *
     * @return
     */
    public int getNumExecutiveSingle() 
    {
        return numExecutiveSingle;
    }

    /**
     *
     * @param numExecutiveSingle
     */
    public void setNumExecutiveSingle(int numExecutiveSingle) 
    {
        this.numExecutiveSingle = numExecutiveSingle;
    }
    
    @Override
    public String toString() 
    {
        return "FourStar";
    }
}
