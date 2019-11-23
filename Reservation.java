import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Reservation {

    /*@Override
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
    }*/
    @Override
    public String toString() {
        return reservationNum + "," + reservationName + "," + reservationType + "," + checkInDay + "," + numOfNights + "," + numOfRooms + "," + roomsBooked.toString() + "," + totalCost + ","  + Deposit;
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

    public static String getDayOfWeek(LocalDate aDate){
        String day = aDate.getDayOfWeek().name();
        return day;
    }

    public static LocalDate formatDate(String date){
        StringTokenizer st = new StringTokenizer(date);
        int day = Integer.parseInt(st.nextToken("/"));
        int month = Integer.parseInt(st.nextToken("/"));
        int year = Integer.parseInt(st.nextToken());
        LocalDate calDate = LocalDate.of(year, month, day);
        return calDate;
    }
}
