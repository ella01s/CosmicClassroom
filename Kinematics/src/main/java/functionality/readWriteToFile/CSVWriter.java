package functionality.readWriteToFile;

import records.incorrectAnswersRecords.UsersRecordUpdater;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static records.incorrectAnswersRecords.UsersRecordUpdater.saveLastKey;

public class CSVWriter {

    public static String userRecordFilePath = "/Users/emmanuellasolomon/Documents/Comp_Sci/repos/CosmicClassroom/Kinematics/src/main/resources/UserRecord.csv";


    public static void writeDataToCSV(String filePath, String[] rowData) {
        try {
            boolean isEmpty = isFileEmpty(filePath);
            try (FileWriter writer = new FileWriter(filePath, true)) { // 'true' for append mode
                if (!isEmpty) {
                    writer.append("\n"); // Append newline if file is not empty
                } else {
                    // Write the header if the file is empty
                    writer.append("ID,Username\n");
                }
                for (int i = 0; i < rowData.length; i++) {
                    writer.append(rowData[i]);
                    if (i != rowData.length - 1) {
                        writer.append(",");
                    }
                }
                System.out.println("Data has been written to the CSV file successfully.");
            } catch (IOException e) {
                System.err.println("Error writing data to the CSV file: " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Error checking if file is empty: " + e.getMessage());
        }
    }

    public static boolean isFileEmpty(String filePath) throws IOException {
        File file = new File(filePath);
        return file.length() == 0;
    }

    public static void clearCSVFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath, false)) { // 'false' to overwrite mode
            writer.write(""); // Write an empty string to clear the file
            System.out.println("CSV file has been cleared successfully.");
        } catch (IOException e) {
            System.err.println("Error clearing CSV file: " + e.getMessage());
        };
    }

    public static void clearAndRewriteUserRecordHeadings() {
        clearCSVFile(userRecordFilePath);
        RewriteCSVFile(userRecordFilePath, "ID, Username");
        UsersRecordUpdater.setLastKey(0);
    }

    public static void RewriteCSVFile(String filePath, String header) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(header);
            writer.newLine();
            System.out.println("CSV file has been cleared and rewritten with header successfully.");
        } catch (IOException e) {
            System.err.println("Error clearing and rewriting CSV file: " + e.getMessage());
        }
    }

    public static void appendHeader(String filePath, String header) {
        File file = new File(filePath);
        boolean fileExists = file.exists() && !file.isDirectory();
        try (FileWriter writer = new FileWriter(filePath, true)) { // 'true' for append mode
            if (!fileExists || file.length() == 0) { // Check if file is empty or doesn't exist
                writer.append(header).append('\n');
                System.out.println("Header has been appended successfully.");
            }
        } catch (IOException e) {
            System.err.println("Error appending header to CSV file: " + e.getMessage());
        }
    }




    public static void deleteRowFromCSV(String filePath, int rowToDelete) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Read all lines from the CSV file
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            // Check if the row exists
            if (rowToDelete > 0 && rowToDelete <= lines.size()) {
                // Remove the specified row
                lines.remove(rowToDelete - 1);

                // Write the modified data back to the file
                try (FileWriter writer = new FileWriter(filePath)) {
                    for (String data : lines) {
                        writer.write(data + "\n");
                    }
                    System.out.println("Data has been deleted from row " + rowToDelete + " in the CSV file.");
                } catch (IOException e) {
                    System.err.println("Error writing data to the CSV file: " + e.getMessage());
                }
            } else {
                System.out.println("Row " + rowToDelete + " does not exist in the CSV file.");
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }

}
