

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Dermot
 */
public class CSV {

    /**
     *Reads .csv File
     * @param fromFilename is the name of the file
     * @return arraylist of all elements from the file
     */
    public static ArrayList<String> csvReader(String fromFilename)
    {
        ArrayList<String> final_data = new ArrayList();
        try
        {
            BufferedReader csvReader = new BufferedReader(new FileReader(fromFilename));
            String row;
            String[] data;
            row = csvReader.readLine();
            final_data.addAll(Arrays.asList(row.split(",")));

            while ((row = csvReader.readLine()) != null) 
            {
                final_data.addAll(Arrays.asList(row.split(",")));
            }
            csvReader.close();
        }
        catch(IOException | NullPointerException io)
        {
            System.out.println("File is empty\n");
        }
        return final_data;
    }
    
    /**
     *Writes all reservations to .csv file
     * @param reservations is a arraylist of type reservations
     */
    static public void csvWriterReservation(ArrayList<Reservation> reservations)
    {
        try{
        FileWriter csvWriter = new FileWriter("Reservations.csv");

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
        csvWriter.append("\n");
        
        for (Reservation aReservation: reservations)
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
            csvWriter.append(Integer.toString(aReservation.getNumOfRooms()));
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
    
    /**
     *Writes all rooms to .csv file
     * @param reservations is a arraylist of type reservations
     */
    static public void csvWriterRooms(ArrayList<Reservation> reservations)
    {
        try
        {
            FileWriter csvWriter = new FileWriter("Rooms.csv");

            csvWriter.append("Reservation Number");
            csvWriter.append(",");
            csvWriter.append("Room Type");
            csvWriter.append(",");
            csvWriter.append("\n");
            for (Reservation aReservation: reservations)
            {
                for (Room r: aReservation.getRoomsBooked())
                {
                    csvWriter.append(Integer.toString(aReservation.getReservationNum()));
                    csvWriter.append(",");
                    csvWriter.append(r.getType());
                    csvWriter.append(",");
                    csvWriter.append("\n");
                }
            }
            csvWriter.close();
        }
        catch(Exception IOException)
        {
            System.out.print(IOException);
        }
    }
}
