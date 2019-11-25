import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Analytics{

    public Analytics(){

    }

    public int numberOfRoomsDaily(LocalDate startDate) throws IOException {
        int count = 0;
        ArrayList<String> dailyRooms = CSV.csvReader("C:\\Users\\Dermot\\Desktop\\reservations.csv");
        for (String dailyRoom : dailyRooms) {
            if (dailyRoom.contains(startDate.toString())) {
                count++;
            }
        }
        return count;
    }

    public static int numberOfRooms() throws IOException {
        int count = -1;
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Dermot\\Desktop\\reservations.csv"));
        while (reader.readLine() != null) {
            count++;
        }
        reader.close();
        System.out.println(count);
        return count;
    }

    public static double totalCost() throws IOException {
        double totalCost = 0;
        ArrayList<Double> totalCostArray = new ArrayList<>();
        ArrayList<String> rooms = CSV.csvReader("C:\\Users\\Dermot\\Desktop\\reservations.csv");
        for (int i = 12; i<rooms.size();i = i+7){
           double cost = Double.parseDouble(rooms.get(i));
           totalCostArray.add(cost);
        }
        for(double j : totalCostArray){
            totalCost += j;
        }
        System.out.println(totalCost);
        return totalCost;
    }

    public static double averageCost() throws IOException {
        System.out.println(totalCost()/numberOfRooms());
        return totalCost()/numberOfRooms();
    }
}