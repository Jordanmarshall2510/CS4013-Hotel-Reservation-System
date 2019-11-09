
package Hotel_system;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author The bois
 */
public class Reservation {
    
    
    int reservationNum; // Cannot be defined by the user must be automated !!
    
    String reservationName; // Person making the reservation
      
    char reservationType; // 'S' for Standard 'A' for Advanced 
    
    LocalDateTime checkInDate; // date of booking start
    
    int numOfNights; // number of nights booked
    
    int numOfRooms; // number of rooms booked
    
    ArrayList<Room> roomsBooked = new ArrayList<>(); // the rooms booked
    
    double totalCost; // total cost of the whole reservation
    
    double Deposit; // deposit of the whole reservation
    
    /**
     * Yes this is big. Apparently thats okay
     * 
     * @param reservationNum
     * @param reservationName
     * @param reservationType
     * @param checkInDate
     * @param numOfNights
     * @param numOfRooms
     * @param roomsBooked
     * @param totalCost
     * @param Deposit 
     */
    Reservation(int reservationNum, String reservationName, char reservationType,
            LocalDateTime checkInDate, int numOfNights, int numOfRooms,
            ArrayList<Room> roomsBooked, double totalCost, double Deposit)
    {
        this.reservationName = reservationName;
        this.reservationType = reservationType;
        this.checkInDate = checkInDate;
        this.numOfNights = numOfNights;
        this.numOfRooms = numOfRooms;
        this.roomsBooked = roomsBooked;
        this.totalCost = totalCost;
        this.Deposit = Deposit;
    }
    
    
    
    
    
    
    
    
    
    
    
    
        //// to do later 
//    @Override
//    public String toString()
//    {
//        return some strings;
//    }
//    
}
