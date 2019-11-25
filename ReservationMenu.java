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

/**
 *
 * @author Dermot
 */
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
    static int reservationNum = 0; // starts at one and increments never repeating

    /**
     *The scanner for the ReservationMenu
     */
    public ReservationMenu()
    {
        this.in = new Scanner(System.in);
    }
    
    /**
     * Checks the availability of rooms in the hotel
     * @param hotel
     * @param type
     * @param roomArray
     * @return a boolean whether a room is booked or not
     */
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
    
    /**
     * Sets the price of each room Type
     * @param roomArray 
     */
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
    
    /**
     * Takes in an Arraylist of rooms and returns their total cost
     * 
     * @param roomArray
     * @return returns a double for price of all the rooms in a select Arraylist
     */
    private static double getRoomPrices(ArrayList<Room> roomArray)
    {
      double price = 0;
        for(Room r: roomArray )
        {
             price = price + r.getRate();
        }
        return price;
    }
    
    /**
    *  This method creates a reservation by taking input from the scanner and adding it to a constructor which also adds the data to the Reservations.csv and Rooms.csv
    */
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
        System.out.println("Please enter the reservation type: 0)Standard or 1)Advanced Purchase: ");
        int reservationType = Integer.parseInt(in.nextLine());
        System.out.println("What day would you like to check in? (DD/MM/YYYY): ");
        String checkInDay = in.nextLine();
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
        if(reservationType == 1)
        {
            totalCost = totalCost*0.95; // 5% discount
        }
        double Deposit = 50;
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

    /**
     * Cancels a reservation based on user reservation id
     */
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
    
    /**
     * Checks in the user
     */
    private void CheckIn()
    {
        System.out.println("Check-in complete. Room(s) booked.");
    }
    
    /**
     *  Checks out the user
     */
    private void CheckOut()
    {
        cancel();
        System.out.println("Check-Out complete.");
    }

    /**
     * Runs the reservation system and takes in data from the csv files 
     * 
     * @param aReservation
     * @throws IOException
     */
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
                                CheckIn();
                                break;
                            }
                            case "4":
                            {
                                CheckOut();
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
                                CheckIn();
                                break;
                            }
                            case "4":
                            {
                                CheckOut();
                                break;
                            }
                            case "5":
                            {
                                //Discount();
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
                                        System.out.println("Number of Rooms Booked: "+Analytics.numberOfRooms());
                                        break;
                                    }
                                    case "2":
                                    {
                                        System.out.println("Total cost of all rooms: " +Analytics.totalCost());
                                        break;
                                    }
                                    case "3":
                                    {
                                        System.out.println("Average cost of all rooms: "+Analytics.averageCost());
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

    /**
     * Adds a reservation to the reservations Arraylist
     * @param aReservation
     * 
     */
    public void addReservation(Reservation aReservation)
    {
        reservations.add(aReservation);
    }

    /**
     * 
     * @param choices
     * @return An object at [n]
     */
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
    
    /**
     * Gets the price of a room on a given day
     * @param room
     * @param date
     * @return a price for a room (double)
     */
    public double getPrice (Room room, LocalDate date)
    {
        double finalPrice = 0;
        double[][] prices = 
        {
                /*Deluxe Double*/{75,75,75,80,90,90,75},
                /*Deluxe Twin*/{75,75,75,80,90,90,75},
                /*Deluxe Single*/{70,70,70,75,80,80,65},
                /*Deluxe Family*/{80,80,80,80,100,100,80},
                /*Executive Double*/{70,70,70,70,80,85,85},
                /*Executive Twin*/{70,70,70,70,80,85,85},
                /*Executive Single*/{65,65,65,65,70,75,80},
                /*Classic Double*/{65,65,70,70,75,80,65},
                /*Classic Twin*/{65,65,70,70,80,85,65},
                /*Classic Single*/{50,50,50,60,75,75,50}
        };
        if(room == new Room("Deluxe Double"))
        {
            finalPrice = prices[0][date.getDayOfWeek().getValue()];
        }
        if(room == new Room("Deluxe Twin"))
        {
            finalPrice = prices[1][date.getDayOfWeek().getValue()];
        }
        if(room == new Room("Deluxe Single"))
        {
            finalPrice =  prices[2][date.getDayOfWeek().getValue()];
        }
        if(room == new Room("Deluxe Family"))
        {
            finalPrice =  prices[3][date.getDayOfWeek().getValue()];
        }
        if(room == new Room("Executive Double"))
        {
            finalPrice = prices[4][date.getDayOfWeek().getValue()];
        }
        if(room == new Room("Executive Twin"))
        {
            finalPrice = prices[5][date.getDayOfWeek().getValue()];
        }
        if(room == new Room("Executive Single"))
        {
            finalPrice =  prices[6][date.getDayOfWeek().getValue()];
        }
        if(room == new Room("Classic Double"))
        {
            finalPrice = prices[7][date.getDayOfWeek().getValue()];
        }
        if(room == new Room("Classic Twin"))
        {
            finalPrice =  prices[8][date.getDayOfWeek().getValue()];
        }
        if(room == new Room("Classic Single"))
        {
            finalPrice =  prices[9][date.getDayOfWeek().getValue()];
        }
        return finalPrice;
    }
}
