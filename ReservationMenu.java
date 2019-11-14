import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

//    private static Room[] room = { new Room("Double"),
//                                   new Room("Twin"),
//                                   new Room("Single")};
    
    private static String[] rooms = new String[]{"Double",
                                                 "Twin",
                                                 "Single"};
    
    private static String[] days = new String[]{"Monday",
                                                "Tuesday",
                                                "Wednesday",
                                                "Thursday",
                                                "Friday",
                                                "Saturday",
                                                "Sunday"};


    public ReservationMenu() 
    {
        this.in = new Scanner(System.in); 
    }

    public void Reservations() 
    {
        getChoice(reserve);
    }
//    public void roomType() 
//    {
//        getChoice(rooms);
//    }
//    public void setNights() 
//    {
//        System.out.println("How Many Nights: ");
//        int numOfNights = in.nextInt();
//        System.out.println("How Many Adults: ");
//        String numOfAdults = in.nextLine();
//        System.out.println("How Many Children: ");
//        String numOfChildren = in.nextLine();
//        //machine.addReservation(new Reservation(numOfNights, numOfAdults, numOfChildren));
//
//    }
    
    public void pickRoom()
    {
        System.out.println("Pick Room type: ");
        Object Type = getChoiceString(rooms);
        System.out.println("Breakfast included? (1)Yes or (0)No: ");
        int breakfast = in.nextInt();
        //machine.addRoom(new Room(Object Type, double Rate, boolean breakfast);
                         
    }
    
    public void makeReservation()
    {
        System.out.println("Enter your name: ");
        String reservationName = in.nextLine();
        System.out.println("Please enter the reservation type: (1)standard or (0)advanced: ");
        int reservationType = in.nextInt();
        System.out.println("Number of Nights: ");
        int numOfNights = in.nextInt();
        System.out.println("Number of rooms: ");
        int numOfRooms = in.nextInt();
        System.out.println("Choose your rooms: ");
        for (int i = 0;i < numOfRooms; i++)
        {
            pickRoom();  /// problem with getchoice at the moment ///////////////////////////////////
        }
        System.out.println("What day would you like to check in? (DD MM YYYY): ");
        String checkInDay = in.nextLine();
       //machine.addReservation(new Reservation(int reservationNum, String reservationName, boolean reservationType,
       //                       String checkInDay, int numOfNights, int numOfRooms,
       //                       ArrayList<Room> roomsBooked, double totalCost, double Deposit)
    }






    public void run(Reservation machine)
            throws IOException
    {
        boolean more = true;

        while (more)
        {
            System.out.println("C)ustomer E)mployee S)upervisor Q)uit");
            String command = in.nextLine().toUpperCase();

            switch (command) 
            {
                case "C":
                     Reservations();
                     makeReservation();
                     
                     // roomType();
                     // setNights();
                    break;
                    
            
                case "E":
                    
                    
                    break;
                    
                case "S":
                    
                    
                    break;
                    
                case "Q":
                    
                    
                    more = false;
                    break;
                    
                default:  
                    
                    break;
            }

        }

    }




    
    
    
    
    private Object getChoiceString(String[] choices)
    {
        while (true)
        {
            char c = 'A';
            for (String choice : choices)
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

