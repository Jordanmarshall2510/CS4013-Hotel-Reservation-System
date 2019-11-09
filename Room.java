
package Hotel_system;

/**
 *
 * @author The bois
 */
public class Room {
    
    String Type; // room type // might change type
    double Rate; // room rate
    
    int occupancyAdultMin; // Adult min for this room
    int occupancyAdultMax; // Adult max for this room
    
    int occupancyChildMin; // Child min for this room
    int occupancyChildMax; // child max for this room
    
    boolean breakfast; // if breakfast is included True
    
    /**
     * 
     * @param Type
     * @param Rate
     * @param occupancyAdultMin
     * @param occupancyAdultMax
     * @param occupancyChildMin
     * @param occupancyChildMax
     * @param breakfast 
     */
    Room(String Type, double Rate, int occupancyAdultMin, int occupancyAdultMax, 
            int occupancyChildMin, int occupancyChildMax, boolean breakfast)
         {
             this.Type = Type;
             this.Rate = Rate;
             
             this.occupancyAdultMin = occupancyAdultMin;
             this.occupancyAdultMax = occupancyAdultMax;
             
             this.occupancyChildMin = occupancyChildMin;
             this.occupancyChildMax = occupancyChildMax;
             
             this.breakfast = breakfast;                   
         }
         
         
         
         
         
         
         
         
         
         
         
         
         
             //// to do later 
//    @Override
//    public String toString()
//    {
//        return some strings;
//    }
//    
}
