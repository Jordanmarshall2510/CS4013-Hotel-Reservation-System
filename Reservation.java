import java.time.LocalDate;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Reservation {



    private int reservationNum; // User reservation id
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
        this.reservationNum = reservationNum;
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

    /**
     *Adds Room to room arrayList
     * @param aRoom is a room type
     */
    public void addRoom(Room aRoom)
    {
        roomsBooked.add(aRoom);
    }

    /**
     *Get Reservation Number
     * @return a reservation number
     */
    public int getReservationNum() 
    {
        return reservationNum;
    }

    /**
     * Sets Reservation number
     * @param reservationNum is an int.
     */
    public void setReservationNum(int reservationNum) 
    {
        this.reservationNum = reservationNum;
    }

    /**
     *Get Reservation Name
     * @return a String
     */
    public String getReservationName() 
    {
        return reservationName;
    }

    /**
     *Sets Reservation Name
     * @param reservationName a string
     */
    public void setReservationName(String reservationName) 
    {
        this.reservationName = reservationName;
    }

    /**
     * Get Reservation Type
     * @return an int
     */
    public int getReservationType() 
    {
        return reservationType;
    }

    /**
     * Sets Reservation Number
     * @param reservationType an int
     */
    public void setReservationType(int reservationType) 
    {
        this.reservationType = reservationType;
    }

    /**
     * Gets check in day
     * @return a string
     */
    public String getCheckInDay() 
    {
        return checkInDay;
    }

    /**
     * Gets number of Nights
     * @return an int
     */
    public int getNumOfNights() 
    {
        return numOfNights;
    }


    /**
     * Gets number of rooms
     * @return int
     */
    public int getNumOfRooms() 
    {
        return numOfRooms;
    }

    /**
     * Gets all rooms booked
     * @return arraylist of rooms
     */
    public ArrayList<Room> getRoomsBooked() 
    {
        return roomsBooked;
    }

    /**
     * Gets total cost
     * @return double
     */
    public double getTotalCost() 
    {
        return totalCost;
    }

    /**
     *Gets deposit
     * @return double
     */
    public double getDeposit() 
    {
        return Deposit;
    }

    /**
     * Gets day of week from localdate
     * @param aDate LocalDate type
     * @return string
     */
    public static String getDayOfWeek(LocalDate aDate)
    {
        String day = aDate.getDayOfWeek().name();
        return day;
    }

    /**
     *Formats String to LocalDate type
     * @param date
     * @return
     */
    public static LocalDate formatDate(String date)
    {
        StringTokenizer st = new StringTokenizer(date);
        int day = Integer.parseInt(st.nextToken("/"));
        int month = Integer.parseInt(st.nextToken("/"));
        int year = Integer.parseInt(st.nextToken());
        LocalDate calDate = LocalDate.of(year, month, day);
        return calDate;
    }
    
    @Override
    public String toString() 
    {
        return reservationNum + "," + reservationName + "," + reservationType + "," + checkInDay + "," + numOfNights + "," + numOfRooms + "," + roomsBooked.toString() + "," + totalCost + ","  + Deposit;
    }

}
