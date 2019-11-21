import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

public class ReservationMenu {

    MenuPrinter menuPrinter = new MenuPrinter();

    private ArrayList<Reservation> reservations = new ArrayList<>();

    private Scanner in;

    static int reservationNum = 1; // starts at one and increments

    public ReservationMenu()
    {
        this.in = new Scanner(System.in);
    }

    private void aReservation()
    {
        ArrayList<Room> roomArray = new ArrayList<>();

        System.out.println("Please choose a hotel");
        Hotel hotel = (Hotel) getChoice(Hotel.reserve);
        System.out.println("Enter your name: ");
        String reservationName = in.nextLine();
        System.out.println("Please enter the reservation type: (1)standard or (0)advanced: ");
        int reservationType = Integer.parseInt(in.nextLine());
        System.out.println("What day would you like to check in? (DD/MM/YYYY): ");
        String checkInDay = in.nextLine();



        //This line is just testing the day of week
        System.out.println(Reservation.getDayOfWeek(Reservation.formatDate(checkInDay)));




        System.out.println("Number of Nights: ");
        int numOfNights = Integer.parseInt(in.nextLine());
        System.out.println("Number of rooms: ");
        int numOfRooms = Integer.parseInt(in.nextLine());
        System.out.println("Choose your rooms: "+"\n");
        for (int i = 0;i < numOfRooms; i++)
        {
            System.out.println("Room "+ (i + 1)+ "\n");
            String Type;
            if(hotel instanceof FiveStar)
            {
                Type = (String) getChoice(Room.roomsFiveStar);
            }
            else if(hotel instanceof FourStar)
            {
                Type = (String) getChoice(Room.roomsFourStar);
            }
            else
            {
                Type = (String) getChoice(Room.roomsThreeStar);
            }
            System.out.println("How many adults?: ");
            int occupancyAdultMax = Integer.parseInt(in.nextLine());
            System.out.println("How many children?: ");
            int occupancyChildMax = Integer.parseInt(in.nextLine());
            System.out.println("Pick Room type: ");




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
            menuPrinter.printLoginMenu();
            String command = in.nextLine().toUpperCase();

            switch (command)
            {
                case "1":
                {
                    boolean submore = true;

                    while (submore)
                    {
                        menuPrinter.printCustomerMenu();
                        String subcommand = in.nextLine().toUpperCase();

                        switch (subcommand)
                        {
                            case "1":
                            {
                                System.out.print("\n");
                                aReservation();

                                break;
                            }
                            case "2":
                            {
                                System.out.print("\n");
                                cancel();
                                break;
                            }
                            case "3":
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
                case "2":
                {
                    boolean submore = true;

                    while (submore)
                    {
                        menuPrinter.printDeskAdministratorMenu();
                        String subcommand = in.nextLine().toUpperCase();

                        switch (subcommand)
                        {
                            case "1":
                            {
                                System.out.print("\n");
                                aReservation();

                                break;
                            }
                            case "2":
                            {
                                System.out.print("\n");
                                cancel();
                                break;
                            }
                            case "3":
                            {

                                break;
                            }
                            case "4":
                            {

                                break;
                            }
                            case "5":
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
                case "3":
                {
                    boolean submore = true;

                    while (submore)
                    {
                        menuPrinter.printSupervisorMenu();

                        String subcommand = in.nextLine().toUpperCase();

                        switch (subcommand)
                        {
                            case "1":
                            {
                                System.out.print("\n");
                                aReservation();

                                break;
                            }
                            case "2":
                            {
                                System.out.print("\n");
                                cancel();
                                break;
                            }
                            case "3":
                            {

                                break;
                            }
                            case "4":
                            {

                                break;
                            }
                            case "5":
                            {

                                break;
                            }
                            case "6":
                            {
                                menuPrinter.printAnalyticsMenu();
                                String subcommand2 = in.nextLine().toUpperCase();
                                switch (subcommand2)
                                {
                                    case "1":
                                    {

                                        break;
                                    }
                                    case "2":
                                    {

                                        break;
                                    }
                                    case "3":
                                    {

                                        break;
                                    }
                                    case "4":
                                    {

                                        break;
                                    }
                                }
                                break;
                            }
                            case "7":
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
                case "4":
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
