package records.incorrectAnswersRecords.lessonRecords;

import functionality.LessonController;
import functionality.readWriteToFile.CSVReader;
import lessons.chapter01.DirectionCosinesLesson02;
import lessons.chapter01.SimpleRotationLesson01;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompletedLessonsTracker {
    private Map<String, Boolean> completedLessons;


    public CompletedLessonsTracker() {
        completedLessons = new HashMap<>();
    }

    public static void main(String[] args) {
        CompletedLessonsTracker tracker = new CompletedLessonsTracker();
        List<String> allLessonNames = Arrays.asList("SimpleRotation01", "DirectionCosines02");
        // Initialize all lessons as incomplete
        for (String lessonName : allLessonNames) {
            tracker.markLesson(lessonName, false);
        }
    }
    public void markLesson(String lessonName, boolean b) {
        completedLessons.put(lessonName, true);
    }
    public void markLessonAsComplete(String topic) {
        completedLessons.put(topic, true);
    }

    public int getUserCompletionLevel(String username) {
        String filePath = "/Users/emmanuellasolomon/Documents/Comp_Sci/repos/CosmicClassroom/Kinematics/src/main/resources/UserRecord.csv";
        try {
            String userLevel = CSVReader.getLevelByUsername(filePath, username);
            if (userLevel != null) {
                return Integer.parseInt(userLevel);
            } else {
                System.out.println("User " + username + " not found in the CSV.");
                return -1; // Return a default value or handle appropriately
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
            return -1; // Return a default value or handle appropriately
        }
    }


    public boolean isLessonCompleted(String topic) {
        return completedLessons.getOrDefault(topic, false);
    }

    public void startLesson(int userCompletionLevel, String username, LessonController lessonController) {
        System.out.println("Starting lesson for user: " + username);
        System.out.println("Requested completion level: " + userCompletionLevel);

        // Determine the next lesson topic based on the completion level
        String nextLessonTopic = getNextIncompleteLesson(userCompletionLevel, username);
        System.out.println("Next incomplete lesson topic: " + nextLessonTopic);

        // Start the lesson corresponding to the completion level
        if (nextLessonTopic != null) {
            switch (userCompletionLevel) {
                case 0:
                    System.out.println("Starting SimpleRotation01 lesson...");
                    SimpleRotationLesson01 simpleRotation = new SimpleRotationLesson01(lessonController);
                    simpleRotation.startLesson();
                    markLessonAsComplete("SimpleRotation01");
                    break;
                case 1:
                    System.out.println("Starting DirectionCosines02 lesson...");
                    DirectionCosinesLesson02 directionCosines = new DirectionCosinesLesson02(lessonController);
                    directionCosines.startLesson();
                    markLessonAsComplete("DirectionCosines02");
                    break;
                // Add cases for other completion levels as needed
                default:
                    System.out.println("No lesson available for completion level " + userCompletionLevel);
                    break;
            }
        } else {
            System.out.println("No lesson available for completion level " + userCompletionLevel);
        }
    }



    public String getNextIncompleteLesson(int completionLevel, String username) {
        String userLevel = null;
        try {
            String filePath = "/Users/emmanuellasolomon/Documents/Comp_Sci/repos/CosmicClassroom/Kinematics/src/main/resources/UserRecord.csv";
            userLevel = CSVReader.getLevelByUsername(filePath, username);
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
            return null; // Return null if an error occurs
        }

        if (userLevel != null) {
            int userCompletionLevel = Integer.parseInt(userLevel);
            if (userCompletionLevel >= completionLevel) {
                int nextLessonNumber = completionLevel + 1; // Calculate the next lesson number
                String nextLessonTopic = "Lesson" + String.format("%02d", nextLessonNumber); // Format lesson number with leading zero
                return nextLessonTopic;
            } else {
                System.out.println("User " + username + " completion level is lower than requested.");
            }
        } else {
            System.out.println("User " + username + " not found in the CSV.");
        }

        return null; // Return null if no lesson is available for the completion level or user's completion level is lower
    }







}

