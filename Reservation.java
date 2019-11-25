import java.time.LocalDate;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Dermot
 */
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
     *
     * @param aRoom
     */
    public void addRoom(Room aRoom)
    {
        roomsBooked.add(aRoom);
    }

    /**
     *
     * @return
     */
    public int getReservationNum() 
    {
        return reservationNum;
    }

    /**
     *
     * @param reservationNum
     */
    public void setReservationNum(int reservationNum) 
    {
        this.reservationNum = reservationNum;
    }

    /**
     *
     * @return
     */
    public String getReservationName() 
    {
        return reservationName;
    }

    /**
     *
     * @param reservationName
     */
    public void setReservationName(String reservationName) 
    {
        this.reservationName = reservationName;
    }

    /**
     *
     * @return
     */
    public int getReservationType() 
    {
        return reservationType;
    }

    /**
     *
     * @param reservationType
     */
    public void setReservationType(int reservationType) 
    {
        this.reservationType = reservationType;
    }

    /**
     *
     * @return
     */
    public String getCheckInDay() 
    {
        return checkInDay;
    }

    /**
     *
     * @param checkInDay
     */
    public void setCheckInDay(String checkInDay) 
    {
        this.checkInDay = checkInDay;
    }

    /**
     *
     * @return
     */
    public int getNumOfNights() 
    {
        return numOfNights;
    }

    /**
     *
     * @param numOfNights
     */
    public void setNumOfNights(int numOfNights) 
    {
        this.numOfNights = numOfNights;
    }

    /**
     *
     * @return
     */
    public int getNumOfRooms() 
    {
        return numOfRooms;
    }

    /**
     *
     * @param numOfRooms
     */
    public void setNumOfRooms(int numOfRooms) 
    {
        this.numOfRooms = numOfRooms;
    }

    /**
     *
     * @return
     */
    public ArrayList<Room> getRoomsBooked() 
    {
        return roomsBooked;
    }

    /**
     *
     * @param roomsBooked
     */
    public void setRoomsBooked(ArrayList<Room> roomsBooked) 
    {
        this.roomsBooked = roomsBooked;
    }

    /**
     *
     * @return
     */
    public double getTotalCost() 
    {
        return totalCost;
    }

    /**
     *
     * @param totalCost
     */
    public void setTotalCost(double totalCost) 
    {
        this.totalCost = totalCost;
    }

    /**
     *
     * @return
     */
    public double getDeposit() 
    {
        return Deposit;
    }

    /**
     *
     * @param Deposit
     */
    public void setDeposit(double Deposit) 
    {
        this.Deposit = Deposit;
    }

    /**
     *
     * @param aDate
     * @return
     */
    public static String getDayOfWeek(LocalDate aDate)
    {
        String day = aDate.getDayOfWeek().name();
        return day;
    }

    /**
     *
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
