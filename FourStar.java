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

    FourStar(String description)
    {

    }

    public int getNumExecutiveDouble() 
    {
        return numExecutiveDouble;
    }

    public void setNumExecutiveDouble(int numExecutiveDouble) 
    {
        this.numExecutiveDouble = numExecutiveDouble;
    }

    public int getNumExecutiveTwin() 
    {
        return numExecutiveTwin;
    }

    public void setNumExecutiveTwin(int numExecutiveTwin) 
    {
        this.numExecutiveTwin = numExecutiveTwin;
    }

    public int getNumExecutiveSingle() 
    {
        return numExecutiveSingle;
    }

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
