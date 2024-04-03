package readAndWriteToFileTests;

import functionality.readWriteToFile.CSVReader;

import java.io.IOException;

public class CSVReaderTests {
    public static void main(String[] args) {
        String filePath = "/Users/emmanuellasolomon/Documents/Comp_Sci/repos/CosmicClassroom/Kinematics/src/main/resources/UserRecord.csv"; // Provide the path to your CSV file
        String username = "jj"; // Provide the username you want to look up

        try {
            String level = CSVReader.getLevelByUsername(filePath, username);
            if (level != null) {
                System.out.println("Level for user " + username + " is: " + level);
            } else {
                System.out.println("User " + username + " not found in the CSV.");
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }

}
