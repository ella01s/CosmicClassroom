package records.incorrectAnswersRecords;

import functionality.InputHelper;
import functionality.readWriteToFile.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class UsersRecordUpdater {
    private static final String KEY_FILE = "lastKey.txt";
    private static int lastKey;
    private static HashMap<Integer, String> usernamesRecord = new HashMap<>();

    public static void main (String []args){
        //printUsernamesRecord();
    }
    static {
        try (BufferedReader reader = new BufferedReader(new FileReader(KEY_FILE))) {
            lastKey = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            // Handle the case when the file doesn't exist or doesn't contain a valid integer
            lastKey = 0;
        }
    }
    public static void setLastKey(int key) {
        lastKey = key;
    }


    public static int generateKey() {
        saveLastKey(lastKey + 1); // Save the new key to the file
        return lastKey++;
    }

    public static void saveLastKey(int key) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(KEY_FILE))) {
            writer.write(Integer.toString(key));
        } catch (IOException e) {
            // Handle IOException, such as file permission issues
            e.printStackTrace();
        }
    }


    public static void getUsername(){
        System.out.println("What is your name? please type it into the terminal");
        String username = InputHelper.readLine();
        //usernamesRecord.put(generateKey(), username);
        int userID = generateKey();
        String[] userdata = {String.valueOf(userID), username};
        String filepath = "/Users/emmanuellasolomon/Documents/Comp_Sci/repos/CosmicClassroom/Kinematics/src/main/resources/UserRecord.csv";
        CSVWriter.writeDataToCSV(filepath, userdata);
    }

}
