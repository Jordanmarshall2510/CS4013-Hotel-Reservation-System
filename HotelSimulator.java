import java.io.IOException;

class HotelSimulation
{
    public static void main(String[] args)
            throws IOException
    {
        Reservation machine = new Reservation();
        ReservationMenu reserve = new ReservationMenu();
        reserve.run(machine);
    }
}