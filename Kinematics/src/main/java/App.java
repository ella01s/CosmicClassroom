import functionality.LessonController;
import functionality.readWriteToFile.CSVWriter;
import lessons.chapter01.SimpleRotationLesson01;
import records.userRecords.UsersRecordUpdater;
import records.incorrectAnswersRecords.lessonRecords.CompletedLessonsTracker;

import static records.userRecords.UserInfo.getUsername;

public class App {

    private static CompletedLessonsTracker tracker;

    private static String path = "/Users/emmanuellasolomon/Documents/Comp_Sci/repos/CosmicClassroom/Kinematics/src/main/resources/UserRecord.csv";
    public static void main(String[] args) {
        //CSVWriter.clearAndRewriteUserRecordHeadings();

        LessonController lessonController = new LessonController();
        tracker = new CompletedLessonsTracker();

        UsersRecordUpdater.setUser();
        String username = getUsername();
        int level = tracker.getUserCompletionLevel(username);
        System.out.println(level);
        tracker.startLesson(level, username, lessonController);
    }

}
