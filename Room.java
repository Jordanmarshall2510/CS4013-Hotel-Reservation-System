
/**
 *
 * @author The bois
 */
public class Room {

    @Override
    public String toString() {
        return  "Room = " + Type +
                ", Rate = " + Rate +
                ", Adults = " + occupancyAdultMax +
                ", Children = " + occupancyChildMax +
                ", breakfast = " + breakfast +
                ", booked = " + booked + '}';
    }

    String Type; // room type 
    double Rate; // room rate

    int occupancyAdultMin; // Adult min for this room
    int occupancyAdultMax; // Adult max for this room

    int occupancyChildMin; // Child min for this room
    int occupancyChildMax; // child max for this room

    int breakfast; // if breakfast is included True
    boolean booked; // true if this room is currently booked

    
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
    }

    Room(String Type, int breakfast)
    {
        this.Type = Type;
        this.breakfast = breakfast;
    }

}
