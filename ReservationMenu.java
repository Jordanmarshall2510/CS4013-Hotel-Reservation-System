import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;
import java.util.Arrays;

public class ReservationMenu {

    MenuPrinter menuPrinter = new MenuPrinter();
    private ArrayList<Reservation> reservations = new ArrayList<>();
    ArrayList<Room> five_star_rooms = new ArrayList();
    ArrayList<Room> four_star_rooms = new ArrayList();
    ArrayList<Room> three_star_rooms = new ArrayList();
    FiveStar five_star;
    FourStar four_star;
    ThreeStar three_star;

    private Scanner in;

    static int reservationNum = 0; // starts at one and increments

    public ReservationMenu()
    {
        this.in = new Scanner(System.in);
    }
    static boolean CheckRoomAvailability(Hotel hotel, String type, ArrayList<Room> roomArray)
    {
        boolean room_booked = false;
        for(Room r: hotel.getRooms())
        {
            if (r.getType().equals(type) && !r.isBooked())
            {
                r.setBooked(true);
                room_booked = true;
                roomArray.add(r);
                break;
            }
        }
        return room_booked;
    }
    
    private static void setRoomPrices(ArrayList<Room> roomArray)
    {
        for(Room r: roomArray )
        {
            if(r.getType() == "Deluxe Double")
            {
                r.setRate(90);
            }
            if(r.getType() == "Deluxe Twin")
            {
                r.setRate(80);
            }
            if(r.getType() == "Deluxe Single")
            {
                r.setRate(80);
            }
            if(r.getType() == "Deluxe Family")
            {
                r.setRate(100);
            }
            if(r.getType() == "Executive Double")
            {
                r.setRate(80);
            }
            if(r.getType() == "Executive Twin")
            {
                r.setRate(80);
            }
            if(r.getType() == "Executive Single")
            {
                r.setRate(70);
            }
            if(r.getType() == "Classic Double")
            {
                r.setRate(75);
            }
            if(r.getType() == "Classic Twin")
            {
                r.setRate(80);
            }
            if(r.getType() == "Classic Single")
            {
                r.setRate(75);
            }
        }
    }
    
    private static double getRoomPrices(ArrayList<Room> roomArray)
    {
      double price = 0;
        for(Room r: roomArray )
        {
             price = price + r.getRate();
        }
        return price;
    }
    
    private void aReservation()
    {
        ArrayList<Room> roomArray = new ArrayList<>();
        boolean fully_booked = true;
        Hotel[] all_hotels = {five_star, four_star, three_star};
        Hotel hotel = null;
        while (fully_booked)
        {
            System.out.println("Please choose a hotel");
            hotel = (Hotel) getChoice(all_hotels);
            for(Room r: hotel.getRooms())
            {
                if (!r.isBooked())
                {
                    fully_booked = false;
                    break;
                }
                else
                {
                    fully_booked = true;
                }
            }
            if (fully_booked)
            {
                System.out.println("Hotel tier fully booked, please select a different hotel tier");
            }
        }
        System.out.println("Enter your name: ");
        String reservationName = in.nextLine();
        System.out.println("Please enter the reservation type: S)tandard or A)dvanced: ");
        char reservationType = in.nextLine().charAt(0);
        System.out.println("What day would you like to check in? (DD/MM/YYYY): ");
        String checkInDay = in.nextLine();
        //This line is just testing the day of week
        System.out.println(Reservation.getDayOfWeek(Reservation.formatDate(checkInDay)));
        System.out.println("Number of Nights: ");
        int numOfNights = Integer.parseInt(in.nextLine());
        System.out.println("Number of rooms:(Each room costs a deposit of 50) ");
        int numOfRooms = Integer.parseInt(in.nextLine());
        boolean room_booked = false;
        System.out.println("Choose your rooms: "+"\n");
        for (int i = 0;i < numOfRooms; i++)
        {
            room_booked = false;
            while(!room_booked)
            {
                System.out.println("Room "+ (i + 1)+ "\n");
                String Type;
                if(hotel instanceof FiveStar)
                {
                    Type = (String) getChoice(Room.getRoomsFiveStar());
                }
                else if(hotel instanceof FourStar)
                {
                    Type = (String) getChoice(Room.getRoomsFourStar());
                }
                else
                {
                    Type = (String) getChoice(Room.getRoomsThreeStar());
                }
                System.out.println("How many adults?: ");
                int occupancyAdultMax = Integer.parseInt(in.nextLine());
                System.out.println("How many children?: ");
                int occupancyChildMax = Integer.parseInt(in.nextLine());
                System.out.println("Pick Room type: ");
                System.out.println("Breakfast included? (1)Yes or (0)No: ");
                int breakfast = Integer.parseInt(in.nextLine());
                room_booked = CheckRoomAvailability(hotel, Type, roomArray);
                if (!room_booked)
                {
                    System.out.println("Room tier fully booked, please select a different Room tier");
                }
            }
        }
        setRoomPrices(roomArray);
        double totalCost = getRoomPrices(roomArray);
        double Deposit = 50; // deposit for each room is 50
        reservations.add(new Reservation(reservationNum, reservationName, reservationType,
                checkInDay, numOfNights, numOfRooms,
                roomArray, totalCost, Deposit));
        for(int i = 0; i < reservations.size(); i++)
        {
            System.out.println(reservations.get(i));
        }
        CSV.csvWriterReservation(reservations);
        CSV.csvWriterRooms(reservations);
        reservationNum++;
    }

    private void cancel()
    {
        System.out.println("Enter your name for cancelation: ");
        String reservationName = in.nextLine();
        System.out.println("Enter your reservation number for cancelation: ");
        String reserve_num = in.nextLine();
        int res_num = Integer.parseInt((reserve_num));
        for (int i = 0;i < reservations.size(); i++)
        {
            if(reservations.get(i).getReservationName().equals(reservationName) && reservations.get(i).getReservationNum() == res_num)
            {
                reservations.remove(i);
                CSV.csvWriterReservation(reservations);
                CSV.csvWriterRooms(reservations);
            }
        }
    }

    public void run(Reservation aReservation)
            throws IOException
    {
        boolean more = true;
        int num_rooms_position = 20;
        File file = new File("Reservations.csv");
        file.createNewFile();
        File file2 = new File("Rooms.csv");
        file2.createNewFile();
        ArrayList<String> reservations_list = CSV.csvReader("Reservations.csv");
        ArrayList<String> rooms_list = CSV.csvReader("Rooms.csv");
        
        if (!reservations_list.isEmpty())
        {
            int i = 8;
            int j = 2;
            ArrayList<Room> rooms = new ArrayList();
            for(; i < reservations_list.size();i++)
            {
                int res_num = Integer.parseInt(reservations_list.get(i));
                String res_name = reservations_list.get(i+=1);
                int Type = Integer.parseInt(reservations_list.get(i+=1));
                String date = reservations_list.get(i+=1);
                LocalDate res_date = Reservation.formatDate(date);
                int  num_nights = Integer.parseInt(reservations_list.get(i+=1));
                int rooms_booked = Integer.parseInt(reservations_list.get(i+=1));
                double cost = Double.parseDouble(reservations_list.get(i+=1));
                double deposit = Double.parseDouble(reservations_list.get(i+=1));
                if (!rooms_list.isEmpty())
                {
                    for (; j < rooms_list.size(); j++)
                    {
                        if (res_num == Integer.parseInt(rooms_list.get(j)))
                        {
                            Room r = new Room(rooms_list.get(j+=1));
                            rooms.add(r);
                        }
                        else
                        {
                            j++;
                        }
                    }
                }

                reservations.add(new Reservation(res_num, res_name, Type, date, num_nights, rooms_booked, rooms, cost, deposit));

            }
            if (!reservations.isEmpty())
            {
                reservationNum = reservations.get(reservations.size()-1).getReservationNum();
                reservationNum++;
            }
        }
        
        
        
        ArrayList<String> hotels_string = CSV.csvReader("l4Hotels.csv");
        if (!hotels_string.isEmpty())
        {
            int num_dd = Integer.parseInt(hotels_string.get(num_rooms_position));
            int num_dt = Integer.parseInt(hotels_string.get(num_rooms_position+=12));
            int num_ds = Integer.parseInt(hotels_string.get(num_rooms_position+=12));
            int num_df = Integer.parseInt(hotels_string.get(num_rooms_position+=12));
            
            for(int i = 0; i < num_dd ; i++)
            {
                five_star_rooms.add(new Room("Deluxe Double"));
            }
            for(int i = 0; i < num_dt; i++)
            {
                five_star_rooms.add(new Room("Deluxe Twin"));
            }
            for(int i = 0; i < num_ds; i++)
            {
                five_star_rooms.add(new Room("Deluxe Single"));
            }
            for(int i = 0; i < num_df; i++)
            {
                five_star_rooms.add(new Room("Deluxe Family"));
            }
            five_star = new FiveStar(five_star_rooms, num_dd, num_dt, num_ds, num_df);
            
            int num_ed = Integer.parseInt(hotels_string.get(num_rooms_position+=12));
            int num_et = Integer.parseInt(hotels_string.get(num_rooms_position+=12));
            int num_es = Integer.parseInt(hotels_string.get(num_rooms_position+=12));
            
            for(int i = 0; i < num_ed ; i++)
            {
                four_star_rooms.add(new Room("Executive Double"));
            }
            for(int i = 0; i < num_et; i++)
            {
                four_star_rooms.add(new Room("Executive Twin"));
            }
            for(int i = 0; i < num_es; i++)
            {
                four_star_rooms.add(new Room("Executive Single"));
            }
            four_star = new FourStar(four_star_rooms, num_ed, num_et, num_es);
            
            int num_cd = Integer.parseInt(hotels_string.get(num_rooms_position+=12));
            int num_ct = Integer.parseInt(hotels_string.get(num_rooms_position+=12));
            int num_cs = Integer.parseInt(hotels_string.get(num_rooms_position+=12));
            
            for(int i = 0; i < num_ed ; i++)
            {
                three_star_rooms.add(new Room("Classic Double"));
            }
            for(int i = 0; i < num_et; i++)
            {
                three_star_rooms.add(new Room("Classic Twin"));
            }
            for(int i = 0; i < num_es; i++)
            {
                three_star_rooms.add(new Room("Classic Single"));
            }
            three_star = new ThreeStar(three_star_rooms, num_cd, num_ct, num_cs);
        }
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
                                        Analytics.numberOfRooms();
                                        break;
                                    }
                                    case "2":
                                    {
                                        Analytics.totalCost();
                                        break;
                                    }
                                    case "3":
                                    {
                                        Analytics.averageCost();
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
