

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSV {

        

    public static ArrayList<String> csvReader(String fromFilename) throws IOException 
    {
        BufferedReader csvReader = new BufferedReader(new FileReader(fromFilename));
        String row;
        String[] data = null;
        row = csvReader.readLine();
        data = row.split(",");
        ArrayList<String> final_data = new ArrayList<String>(Arrays.asList(data));
        
        while ((row = csvReader.readLine()) != null) 
        {
            data = row.split(",");
            final_data.addAll(Arrays.asList(data));
        }
        csvReader.close();
        return final_data;
    }
    
    static public void csvWriter(Reservation aReservation)
    {
        try{
        FileWriter csvWriter = new FileWriter("C:\\Users\\Dermot\\Desktop\\reservations.csv");

        csvWriter.append("Reservation Number");
        csvWriter.append(",");
        csvWriter.append("Reservation Name");
        csvWriter.append(",");
        csvWriter.append("Type");
        csvWriter.append(",");
        csvWriter.append("Check-In");
        csvWriter.append(",");
        csvWriter.append("No. oF Nights");
        csvWriter.append(",");
        csvWriter.append("Rooms Booked");
        csvWriter.append(",");
        csvWriter.append("Cost");
        csvWriter.append(",");
        csvWriter.append("Deposit");
        csvWriter.append(",");
        for (Room r : aReservation.getRoomsBooked())
        {
            csvWriter.append(Integer.toString(aReservation.getReservationNum()));
            csvWriter.append(",");
            csvWriter.append(aReservation.getReservationName());
            csvWriter.append(",");
            csvWriter.append(Integer.toString(aReservation.getReservationType()));
            csvWriter.append(",");
            csvWriter.append(aReservation.getCheckInDay());
            csvWriter.append(",");
            csvWriter.append(Integer.toString(aReservation.getNumOfNights()));
            csvWriter.append(",");
            csvWriter.append(Double.toString(aReservation.getTotalCost()));
            csvWriter.append(",");
            csvWriter.append(Double.toString(aReservation.getDeposit()));
            csvWriter.append(",");
            csvWriter.append("\n");
        }
        csvWriter.close();
        }
        catch(Exception IOException)
        {
            System.out.print(IOException);
        }
    }
}
