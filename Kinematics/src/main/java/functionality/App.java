package functionality;

import functionality.readWriteToFile.CSVWriter;
import records.userRecords.UsersRecordUpdater;
import records.incorrectAnswersRecords.lessonRecords.CompletedLessonsTracker;

import static records.userRecords.UserInfo.getUsername;

public class App {
    private static CompletedLessonsTracker tracker;
    public static void main(String[] args) {
        //CSVWriter.clearAndRewriteUserRecordHeadings();
        startGame();
    }

    public static void startGame(){
        LessonController lessonController = new LessonController();
        tracker = new CompletedLessonsTracker();

        UsersRecordUpdater.setUser();
        String username = getUsername();
        int level = tracker.getUserCompletionLevel(username);
        tracker.startLesson(level, username, lessonController);
    }
}
