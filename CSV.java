import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSV {

        public void csvReader(String fromFilename) throws IOException {
            List<List<String>> elements = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(fromFilename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    elements.add(Arrays.asList(values));
                }
            }
        }

        public void csvWriter(ArrayList<Reservation> aReservation) throws IOException {
            FileWriter csvWriter = new FileWriter("l4Hotels.csv");

            csvWriter.append("Reservation Number");
            csvWriter.append(",");
            csvWriter.append("Reservation Number");
            csvWriter.append(",");
            csvWriter.append("Type");
            csvWriter.append(",");
            csvWriter.append("Check-In");
            csvWriter.append(",");
            csvWriter.append("No. oF Nights");
            csvWriter.append(",");
            csvWriter.append("No. oF Rooms");
            csvWriter.append(",");
            csvWriter.append("Rooms Booked");
            csvWriter.append(",");
            csvWriter.append("Cost");
            csvWriter.append(",");
            csvWriter.append("Deposit");
            csvWriter.append("\n");

            for(aReservation : ArrayList<Reservation>){
                csvWriter.append(aReservation.csvString());
                csvWriter.append("\n");
            }

        }
}
