package functionality.readWriteToFile;

import records.userRecords.UsersRecordUpdater;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVWriter {

    public static String userRecordFilePath = "/Users/emmanuellasolomon/Documents/Comp_Sci/repos/CosmicClassroom/Kinematics/src/main/resources/UserRecord.csv";


    public static void writeDataToCSV(String filePath, String[] rowData) {
        try (FileWriter writer = new FileWriter(filePath, true)) { // 'true' for append mode
            for (int i = 0; i < rowData.length; i++) {
                writer.append(rowData[i]);
                if (i != rowData.length - 1) {
                    writer.append(",");
                }
            }
            writer.append("\n"); // Append newline after the row data
            System.out.println("Data has been written to the CSV file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing data to the CSV file: " + e.getMessage());
        }
    }



    public static boolean isUsernameExists(String filePath, String username) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip the header line
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2 && parts[1].equals(username)) {
                    return true; // Username found
                }
            }
        }
        return false; // Username not found
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

    public static void RewriteCSVFile(String filePath, String header) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(header);
            writer.newLine();
            System.out.println("CSV file has been cleared and rewritten with header successfully.");
        } catch (IOException e) {
            System.err.println("Error clearing and rewriting CSV file: " + e.getMessage());
        }
    }

    public static void clearAndRewriteUserRecordHeadings() {
        clearCSVFile(userRecordFilePath);
        RewriteCSVFile(userRecordFilePath, "ID, Username, Level");
        UsersRecordUpdater.setLastKey(0);
    }
}
