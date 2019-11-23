import java.util.ArrayList;

public class FiveStar extends Hotel {

    @Override
    public String toString() {
        return "FiveStar";
    }

    /**
     * Number of each of these rooms that are available
     */
    int numDeluxeDouble;
    int numDeluxeTwin;

    public int getNumDeluxeDouble() {
        return numDeluxeDouble;
    }

    public void setNumDeluxeDouble(int numDeluxeDouble) {
        this.numDeluxeDouble = numDeluxeDouble;
    }

    public int getNumDeluxeTwin() {
        return numDeluxeTwin;
    }

    public void setNumDeluxeTwin(int numDeluxeTwin) {
        this.numDeluxeTwin = numDeluxeTwin;
    }

    public int getNumDeluxeSingle() {
        return numDeluxeSingle;
    }

    public void setNumDeluxeSingle(int numDeluxeSingle) {
        this.numDeluxeSingle = numDeluxeSingle;
    }
    int numDeluxeSingle;
    private int numDeluxeFamily;


    FiveStar(ArrayList<Room> Rooms, int numDeluxeDouble,
             int numDeluxeTwin, int numDeluxeSingle, int numDeluxeFamily) {

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

    public int getNumDeluxeFamily() {
        return numDeluxeFamily;
    }

    public void setNumDeluxeFamily(int numDeluxeFamily) {
        this.numDeluxeFamily = numDeluxeFamily;
    }

}
