
/**
 *
 * @author Dermot
 */
public class Room {



    private String Type; // room type 
    private double Rate; // room rate
    private int occupancyAdultMin; // Adult min for this room
    private int occupancyAdultMax; // Adult max for this room
    private int occupancyChildMin; // Child min for this room
    private int occupancyChildMax; // child max for this room
    private int breakfast; // if breakfast is included True
    private boolean booked; // true if this room is currently booked


    Room(String Type, double Rate, int breakfast)
    {
        this.Type = Type;
        this.Rate = Rate;
        this.occupancyAdultMax = occupancyAdultMax;
        this.occupancyChildMax = occupancyChildMax;
        this.breakfast = breakfast;
    }

    Room(String Type)
    {
        this.Type = Type;
        if (Type.equals("Deluxe Double"))
        {
            this.occupancyAdultMax = 2;
            this.occupancyAdultMin = 1;
        }
        //TODO: Dermot 
        //Update this to default all other values to the ones stated 
        // in l4Hotels.csv
        //Check the Type coming in against the expected type
    }

    Room(String Type, int breakfast)
    {
        this.Type = Type;
        this.breakfast = breakfast;
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
     *
     * @return
     */
    public String getType() 
    {
        return Type;
    }

    /**
     *
     * @param Type
     */
    public void setType(String Type) 
    {
        this.Type = Type;
    }

    /**
     *
     * @return
     */
    public double getRate() 
    {
        return Rate;
    }

    /**
     *
     * @param Rate
     */
    public void setRate(double Rate) 
    {
        this.Rate = Rate;
    }

    /**
     *
     * @return
     */
    public int getOccupancyAdultMin() 
    {
        return occupancyAdultMin;
    }

    /**
     *
     * @param occupancyAdultMin
     */
    public void setOccupancyAdultMin(int occupancyAdultMin) 
    {
        this.occupancyAdultMin = occupancyAdultMin;
    }

    /**
     *
     * @return
     */
    public int getOccupancyAdultMax() 
    {
        return occupancyAdultMax;
    }

    /**
     *
     * @param occupancyAdultMax
     */
    public void setOccupancyAdultMax(int occupancyAdultMax) 
    {
        this.occupancyAdultMax = occupancyAdultMax;
    }

    /**
     *
     * @return
     */
    public int getOccupancyChildMin() 
    {
        return occupancyChildMin;
    }

    /**
     *
     * @param occupancyChildMin
     */
    public void setOccupancyChildMin(int occupancyChildMin) 
    {
        this.occupancyChildMin = occupancyChildMin;
    }

    /**
     *
     * @return
     */
    public int getOccupancyChildMax() 
    {
        return occupancyChildMax;
    }

    /**
     *
     * @param occupancyChildMax
     */
    public void setOccupancyChildMax(int occupancyChildMax) 
    {
        this.occupancyChildMax = occupancyChildMax;
    }

    /**
     *
     * @return
     */
    public int getBreakfast() 
    {
        return breakfast;
    }

    /**
     *
     * @param breakfast
     */
    public void setBreakfast(int breakfast) 
    {
        this.breakfast = breakfast;
    }

    /**
     *
     * @return
     */
    public boolean isBooked() 
    {
        return booked;
    }

    /**
     *
     * @param booked
     */
    public void setBooked(boolean booked) 
    {
        this.booked = booked;
    }

    /**
     *
     * @return
     */
    public static String[] getRoomsFiveStar() 
        {
        return roomsFiveStar;
    }

    /**
     *
     * @param aRoomsFiveStar
     */
    public static void setRoomsFiveStar(String[] aRoomsFiveStar) 
    {
        roomsFiveStar = aRoomsFiveStar;
    }

    /**
     *
     * @return
     */
    public static String[] getRoomsFourStar() 
    {
        return roomsFourStar;
    }

    /**
     *
     * @param aRoomsFourStar
     */
    public static void setRoomsFourStar(String[] aRoomsFourStar) 
    {
        roomsFourStar = aRoomsFourStar;
    }

    /**
     *
     * @return
     */
    public static String[] getRoomsThreeStar() 
    {
        return roomsThreeStar;
    }

    /**
     *
     * @param aRoomsThreeStar
     */
    public static void setRoomsThreeStar(String[] aRoomsThreeStar) 
    {
        roomsThreeStar = aRoomsThreeStar;
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
