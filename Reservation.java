import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author The bois
 */
public class Reservation {

    @Override
    public String toString() {
        return "Reservation{"+ reservationNum +
                ", Name = " + reservationName
                + ", Reservation Type = " + reservationType
                + ", checkInDate = " + checkInDay +
                ", Number of Nights = " + numOfNights +
                ", Number of Rooms" + numOfRooms +
                ", Rooms Booked = " + roomsBooked.toString() +
                ", totalCost = " + totalCost +
                ", Deposit = " + Deposit + '}';
    }


    private int reservationNum; // Cannot be defined by the user must be automated !!

    private String reservationName; // Person making the reservation

    private int reservationType; // '1' for Standard '0' for Advanced

    private String checkInDay; // date of booking start

    private int numOfNights; // number of nights booked

    private int numOfRooms; // number of rooms booked

    private ArrayList<Room> roomsBooked = new ArrayList<>(); // the rooms booked

    private double totalCost; // total cost of the whole reservation

    private double Deposit; // deposit of the whole reservation

 
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
    
    
    
    
    
    
    
    public void addRoom(Room aRoom)
    {
        roomsBooked.add(aRoom);
    }

    public int getReservationNum() {
        return reservationNum;
    }

    public void setReservationNum(int reservationNum) {
        this.reservationNum = reservationNum;
    }

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public int getReservationType() {
        return reservationType;
    }

    public void setReservationType(int reservationType) {
        this.reservationType = reservationType;
    }

    public String getCheckInDay() {
        return checkInDay;
    }

    public void setCheckInDay(String checkInDay) {
        this.checkInDay = checkInDay;
    }

    public int getNumOfNights() {
        return numOfNights;
    }

    public void setNumOfNights(int numOfNights) {
        this.numOfNights = numOfNights;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public ArrayList<Room> getRoomsBooked() {
        return roomsBooked;
    }

    public void setRoomsBooked(ArrayList<Room> roomsBooked) {
        this.roomsBooked = roomsBooked;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getDeposit() {
        return Deposit;
    }

    public void setDeposit(double Deposit) {
        this.Deposit = Deposit;
    }
}
