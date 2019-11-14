import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author The bois
 */
public class Reservation {


    int reservationNum; // Cannot be defined by the user must be automated !!

    String reservationName; // Person making the reservation

    int reservationType; // '1' for Standard '0' for Advanced

    String checkInDay; // date of booking start

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
    Reservation(int reservationNum, String reservationName, int reservationType,
                String checkInDay, int numOfNights, int numOfRooms,
                ArrayList<Room> roomsBooked, double totalCost, double Deposit)
    {
        this.reservationName = reservationName;
        this.reservationType = reservationType;
        this.checkInDay = checkInDay;
        this.numOfNights = numOfNights;
        this.numOfRooms = numOfRooms;
        this.roomsBooked = roomsBooked;
        this.totalCost = totalCost;
        this.Deposit = Deposit;
    }

    Reservation()
    {

    }











    //// to do later
//    @Override
//    public String toString()
//    {
//        return some strings;
//    }
//
}
