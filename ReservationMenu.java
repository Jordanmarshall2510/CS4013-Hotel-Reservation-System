import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author The bois
 */
public class ReservationMenu {

    // To be decided fully in ICT

    // first Shell is " Customer(C) Employee(E) Superviser(S) "

    // Empoyee and Superviser have passwords // not to be complicated

    // Customer can: Reservation(R) Cancel(C) Quit(Q)

    // Empoyee can: Reservation(R) Cancel(C) CheckIn(I) CheckOut(O) Quit(Q)

    // Superviser can: Reservation(R) Cancel(C) CheckIn(I) CheckOut(O) Discount(D) DataAnalysis(A) Quit(Q)

    // DataAnalysis to be done with serialisation from the CSV file database // last job //



    private Scanner in;
    private static Hotel[] reserve = { new FiveStar("Five Star"),
            new FourStar("Four Star"),
            new ThreeStar("Three Star")};

    private static Room[] room = { new Room("Double"),
            new Room("Twin"),
            new Room("Single")};


    public ReservationMenu() { this.in = new Scanner(System.in); }

    public void Reservations() {
        getChoice(reserve);
    }
    public void roomType() {
        getChoice(room);
    }
    public void setNights() {
        System.out.println("How Many Nights: ");
        String numOfNights = in.nextLine();
        System.out.println("How Many Adults: ");
        String numOfAdults = in.nextLine();
        System.out.println("How Many Children: ");
        String numOfChildren = in.nextLine();
        //machine.addReservation(new Reservation(numOfNights, numOfAdults, numOfChildren));

    }






    public void run(Reservation machine)
            throws IOException
    {
        boolean more = true;

        while (more)
        {
            System.out.println("C)ustomer E)mployee S)upervisor Q)uit");
            String command = in.nextLine().toUpperCase();

            if (command.equals("C"))
            {
                Reservations();
                roomType();
                setNights();
            }
            else if (command.equals("E")) //allows one coin be inserted at a time
            {

            }
            else if (command.equals("S"))
            {

            }
            else if (command.equals("Q"))
            {
                more = false;
            }

        }

    }





    private Object getChoice(Object[] choices)
    {
        while (true)
        {
            char c = 'A';
            for (Object choice : choices)
            {
                System.out.println(c + ") " + choice);
                c++;
            }
            String input = in.nextLine();
            int n = input.toUpperCase().charAt(0) - 'A';
            if (0 <= n && n < choices.length)
                return choices[n];
        }
    }




}
