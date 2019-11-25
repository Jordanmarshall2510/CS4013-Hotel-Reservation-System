import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Analytics{

    public Analytics(){

    }
    /**
     * Gets number of rooms booked in a single day
     * @param startDate is a type LocalDate and is written in the format DD/MM/YYYY
     * @return count of all rooms booked on a certain day
     * @throws IOException 
     */
    public int numberOfRoomsDaily(LocalDate startDate) throws IOException {
        int count = 0;
        ArrayList<String> dailyRooms = CSV.csvReader("Reservations.csv");
        for (String dailyRoom : dailyRooms) {
            if (dailyRoom.contains(startDate.toString())) {
                count++;
            }
        }
        return count;
    }

    /**
     * Gets number of rooms booked
     * @return counts all rooms booked.
     * @throws IOException 
     */
    public static int numberOfRooms() throws IOException {
        int count = -1;
        BufferedReader reader = new BufferedReader(new FileReader("Reservations.csv"));
        while (reader.readLine() != null) {
            count++;
        }
        reader.close();
        if(count == -1){
            count = 0;
        };
        return count;
    }
/**
 * Gets total cost of rooms booked
 * @return cost of all rooms booked
 * @throws IOException 
 */
    public static double totalCost() throws IOException {
        double totalCost = 0;
        ArrayList<Double> totalCostArray = new ArrayList<>();
        ArrayList<String> rooms = CSV.csvReader("Reservations.csv");
        for (int i = 14; i<rooms.size();i = i+8){
           double cost = Double.parseDouble(rooms.get(i));
           totalCostArray.add(cost);
        }
        for(double j : totalCostArray){
            totalCost += j;
        }
        return totalCost;
    }
/**
 * Gets average cost of rooms booked
 * @return average cost of all rooms booked
 * @throws IOException 
 */
    public static double averageCost() throws IOException { ;
        return totalCost()/numberOfRooms();
    }
}