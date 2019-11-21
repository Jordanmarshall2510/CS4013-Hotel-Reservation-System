import java.util.ArrayList;

public abstract class Hotel {

    protected int numberOfRooms; // Each hotel type uses its own

    protected ArrayList<Room> Rooms = new ArrayList<>(); // Each hotel type uses its own

    public static Hotel[] reserve = { new FiveStar("Five Star"),
            new FourStar("Four Star"),
            new ThreeStar("Three Star")};

}
