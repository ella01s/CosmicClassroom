package functionality.readWriteToFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static List<String[]> readDataFromCSV(String filePath) throws IOException {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] rowData = line.split(",");
                data.add(rowData);
            }
        }
        return data;
    }

    public static String getLevelByUsername(String filePath, String username) throws IOException {
        List<String[]> data = readDataFromCSV(filePath);
        for (String[] row : data) {
            if (row.length > 1 && row[1].equals(username)) {
                return row.length > 2 ? row[2] : null; // Assuming level is in the third column
            }
        }
        return null; // Username not found
    }



}

