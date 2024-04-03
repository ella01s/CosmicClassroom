package records.userRecords;

import functionality.InputHelper;
import functionality.readWriteToFile.CSVWriter;
import records.incorrectAnswersRecords.lessonRecords.CompletedLessonsTracker;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class UsersRecordUpdater {
    private static final String KEY_FILE = "lastKey.txt";
    private static int lastKey;
    private static UserInfo userInfo;
    private static CompletedLessonsTracker tracker;
    private static HashMap<Integer, String> usernamesRecord = new HashMap<>();

    public UsersRecordUpdater(CompletedLessonsTracker tracker) {
        this.tracker = tracker;
    }

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


    public static void setUser() {
        System.out.println("What is your name? please type it into the terminal");
        String username = InputHelper.readLine();
        String filepath = "/Users/emmanuellasolomon/Documents/Comp_Sci/repos/CosmicClassroom/Kinematics/src/main/resources/UserRecord.csv";

        if (isUsernameAccepted(username, filepath)) {
            int userID = generateKey();
            String[] userdata = {String.valueOf(userID), username, "0"};
            CSVWriter.writeDataToCSV(filepath, userdata);
            UserInfo.getInstance().setname(username);
        } else {
            System.out.println("Welcome back "+username);
            UserInfo.getInstance().setname(username);
        }
    }



    private static boolean isUsernameAccepted(String username, String filepath) {
        try {
            return !CSVWriter.isUsernameExists(filepath, username);
        } catch (IOException e) {
            System.err.println("Error checking username: " + e.getMessage());
            return false;
        }
    }

    public static void updateUserLevel() {
        String filepath = "/Users/emmanuellasolomon/Documents/Comp_Sci/repos/CosmicClassroom/Kinematics/src/main/resources/UserRecord.csv";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String line;
            List<String[]> lines = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3 && parts[1].trim().equals(userInfo.getUsername())) {
                    parts[2] = String.valueOf(tracker.getUserCompletionLevel());
                }
                lines.add(parts);
            }
            br.close();

            FileWriter writer = new FileWriter(filepath);
            for (String[] parts : lines) {
                writer.append(String.join(",", parts));
                writer.append("\n");
            }
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
