import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static void main(String... args) {
        List<Room> rooms = readRoomsFromCSV("l4Hotels.txt");

        for (Room r : rooms) {
            System.out.println(r);
        }
    }

    private static List<Room> readRoomsFromCSV(String fileName) {
        List<Room> rooms = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            String line = br.readLine();

            while (line != null) {

                String[] attributes = line.split(",");

                Room room = createRoom(attributes);

                rooms.add(room);

                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return rooms;
    }

    private static Room createRoom(String[] metadata) {
        String name = metadata[0];

        return new Room(name);
    }

}