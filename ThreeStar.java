
package Hotel_system;

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
    
     
     
     
     
     
     
     
     
     
     
     
     
         //// to do later 
//    @Override
//    public String toString()
//    {
//        return some strings;
//    }
//    
}
