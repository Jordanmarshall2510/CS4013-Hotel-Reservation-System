
import java.time.LocalDateTime;


/**
 *
 * @author Dermot Parker
 */
public class Reservation {
    
    
   int reservationNumber;
   int numberofNights;
   int numberofRooms;
   
   String reservationName;
   String reservationType;
   
   double totalCost;
   double deposit;
   
   LocalDateTime checkinDate;
   LocalDateTime checkoutDate;
   
   boolean breakfast;
   
   public Reservation()
   {
       
   }
    
}
