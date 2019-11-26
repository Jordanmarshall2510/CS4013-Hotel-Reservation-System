
public class Room {

    private String Type; // room type 
    private double Rate; // room rate
    private int occupancyAdultMin; // Adult min for this room
    private int occupancyAdultMax; // Adult max for this room
    private int occupancyChildMin; // Child min for this room
    private int occupancyChildMax; // child max for this room
    private int breakfast; // if breakfast is included True
    private boolean booked; // true if this room is currently booked


    Room(String Type)
    {
        this.Type = Type;
        if (Type.equals("Deluxe Double"))
        {
            this.occupancyAdultMax = 2;
            this.occupancyAdultMin = 1;
        }

    }


    private static String[] roomsFiveStar = {new String("Deluxe Double"),
                                             new String("Deluxe Twin"),
                                             new String("Deluxe Single"),
                                             new String("Deluxe Family")};

    private static String[] roomsFourStar = {new String("Executive Double"),
                                             new String("Executive Twin"),
                                             new String("Executive Single")};

    private static String[] roomsThreeStar = {new String("Classic Double"),
                                              new String("Classic Twin"),
                                              new String("Classic Single")};

    /**
     * Gets type
     * @return string
     */
    public String getType() 
    {
        return Type;
    }

    /**
     * Gets rate
     * @return double
     */
    public double getRate() 
    {
        return Rate;
    }

    /**
     * Sets rate
     * @param Rate  is a double
     */
    public void setRate(double Rate) 
    {
        this.Rate = Rate;
    }

    /**
     * Check if room is booked
     * @return a boolean
     */
    public boolean isBooked() 
    {
        return booked;
    }

    /**
     *Sets a room to booked or not
     * @param booked is a boolean
     */
    public void setBooked(boolean booked) 
    {
        this.booked = booked;
    }

    /**
     * String array of all five star rooms
     * @return string array
     */
    public static String[] getRoomsFiveStar() 
        {
        return roomsFiveStar;
    }

    /**
     *String array of all four star rooms
     * @return string array
     */
    public static String[] getRoomsFourStar() 
    {
        return roomsFourStar;
    }

    /**
     *String array of all three star rooms
     * @return
     */
    public static String[] getRoomsThreeStar() 
    {
        return roomsThreeStar;
    }

    @Override
    public String toString() {
        return  Type + " "
                + Rate + " "
                + occupancyAdultMax + " "
                + occupancyChildMax + " "
                + breakfast + " "
                + booked;
    }
    
}
