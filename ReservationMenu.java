import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;
import java.util.Calendar;

/**
 *
 * @author The bois
 */
public class ReservationMenu {

    // Empoyee and Superviser have passwords // not to be complicated
    
    // DataAnalysis to be done with serialisation from the CSV file database 


    private ArrayList<Reservation> reservations = new ArrayList<>();

    private Scanner in;
    
    static int reservationNum = 1; // starts at one and increments
    
    private static Hotel[] reserve = { new FiveStar("Five Star"),
                                       new FourStar("Four Star"),
                                       new ThreeStar("Three Star")};
    
    private static String[] roomsFiveStar = { new String("Deluxe Double"),
                                              new String("Deluxe Twin"),
                                              new String("Deluxe Single"),
                                              new String("Deluxe Family")};
    
    private static String[] roomsFourStar = { new String("Executive Double"),
                                              new String("Executive Twin"),
                                              new String("Executive Single")};
    
    private static String[] roomsThreeStar = { new String("Classic Double"),
                                               new String("Classic Twin"),
                                               new String("Classic Single")};
    
    private static String[] days = { new String("Monday"),
                                     new String("Tuesday"),
                                     new String("Wednesday"),
                                     new String("Thursday"),
                                     new String("Friday"),
                                     new String("Saturday"),
                                     new String("Sunday")};


    public ReservationMenu() 
    {
        this.in = new Scanner(System.in); 
    }
    
    private void setDate()
    {
        
    }
    
    private void aReservation()
    {
        ArrayList<Room> roomArray = new ArrayList<>();
        System.out.println("Please choose a hotel");
        Hotel hotel = (Hotel) getChoice(reserve);
        System.out.println("Enter your name: ");
        String reservationName = in.nextLine();
        System.out.println("Please enter the reservation type: (1)standard or (0)advanced: ");
        int reservationType = Integer.parseInt(in.nextLine());
        
        
        System.out.println("What day would you like to check in? (DD MM YYYY): ");
        String checkInDay = in.nextLine();               
        
        
        
        
        System.out.println("Number of Nights: ");
        int numOfNights = Integer.parseInt(in.nextLine());
        
        System.out.println("Number of rooms: ");
        int numOfRooms = Integer.parseInt(in.nextLine());
        System.out.println("Choose your rooms: "+"\n");
        for (int i = 0;i < numOfRooms; i++)
        {
            System.out.println("Room "+ (i + 1)+ "\n");
            System.out.println("How many adults?: ");
            int occupancyAdultMax = Integer.parseInt(in.nextLine());
            System.out.println("How many children?: ");
            int occupancyChildMax = Integer.parseInt(in.nextLine());
            System.out.println("Pick Room type: ");
            
            String Type; 
            if(hotel instanceof FiveStar)
            {
                Type = (String) getChoice(roomsFiveStar);            
            }
            else if(hotel instanceof FourStar)
            {
                Type = (String) getChoice(roomsFourStar);
            }
            else
            {
                Type = (String) getChoice(roomsThreeStar);
            }
            
            
            System.out.println("Breakfast included? (1)Yes or (0)No: ");
            int breakfast = Integer.parseInt(in.nextLine());
            roomArray.add(new Room(Type, breakfast));
        }
        double totalCost = roomArray.size();
        double Deposit = roomArray.size();
        reservationNum++;
        reservations.add(new Reservation(reservationNum, reservationName, reservationType,
                                               checkInDay, numOfNights, numOfRooms,
                                              roomArray, totalCost, Deposit));
        
        for(int i = 0; i < reservations.size(); i++)
        {
            System.out.println(reservations.get(i));
        }
    }
    
    private void cancel()
    {
        System.out.println("Enter your name for cancelation: ");
        String reservationName = in.nextLine();
        for (int i = 0;i < reservations.size(); i++)
            {
                if(reservations.get(i).getReservationName().equals(reservationName))
                {
                    reservations.remove(i);
                }
            }
        
    }


    public void run(Reservation aReservation)
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
                    {
                        boolean submore = true;

                        while (submore)
                        {
                             System.out.println("R)eserve C)ancel B)ack");
                             String subcommand = in.nextLine().toUpperCase();

                            switch (subcommand) 
                            {    
                                case "R":
                                    {
                                        aReservation();

                                        break;
                                    }
                                case "C":
                                    {
                                        cancel();
                                        break;
                                    }
                                case "B":
                                    {                                       
                                     submore = false;
                                     break;
                                    }
                                 default:  
                                    {
                                        
                                    break;
                                    }
                            }
                        }
                        break;

                    }
                case "E":
                    {
                        boolean submore = true;

                        while (submore)
                        {
                             System.out.println("R)eserve C)ancel O)check Out I)check In B)ack");
                             String subcommand = in.nextLine().toUpperCase();

                            switch (subcommand) 
                            {    
                                case "R":
                                    {
                                        aReservation();
                                        
                                        break;
                                    }
                                case "C":
                                    {
                                        cancel();
                                        break;
                                    }
                                    case "O":
                                    {
                                        
                                        break;
                                    }
                                    case "I":
                                    {
                                        
                                        break;
                                    }                                   
                                case "B":
                                    {                                      
                                     submore = false;
                                     break;
                                    }
                                 default:  
                                    {
                                        
                                    break;
                                    }
                            }
                        }
                        break;
                    }
                case "S":
                    {
                        boolean submore = true;

                        while (submore)
                        {
                             System.out.println("R)eserve C)ancel O)check Out I)check In D)iscount A)data Analysis B)ack");
                             String subcommand = in.nextLine().toUpperCase();

                            switch (subcommand) 
                            {    
                                case "R":
                                    {
                                        aReservation();

                                        break;
                                    }
                                case "C":
                                    {
                                        cancel();
                                        break;
                                    }
                                    case "O":
                                    {
                                        
                                        break;
                                    }
                                    case "I":
                                    {
                                        
                                        break;
                                    }
                                    case "D":
                                    {
                                        
                                        break;
                                    }
                                    case "A":
                                    {
                                        
                                        break;
                                    }
                                case "B":
                                    {                                    
                                     submore = false;
                                     break;
                                    }
                                 default:  
                                    {
                                        
                                    break;
                                    }
                            }
                        }
                        break;
                    }
                case "Q":
                    {
                        more = false;
                        break;
                    }
                default:  
                    {
                        break;
                    }
            }

        }

    }


    public void addReservation(Reservation aReservation)
    {
        reservations.add(aReservation);
    }


    
    
    
    /// currently unused ////
//    private Object getChoiceString(String[] choices)
//    {
//        while (true)
//        {
//            char c = 'A';
//            for (String choice : choices)
//            {
//                System.out.println(c + ") " + choice);
//                c++;
//            }
//            String input = in.nextLine();
//            int n = input.toUpperCase().charAt(0) - 'A';
//            if (0 <= n && n < choices.length)
//                return choices[n];
//        }
//    }

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

