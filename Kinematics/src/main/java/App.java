import functionality.LessonController;
import functionality.readWriteToFile.CSVWriter;
import lessons.chapter01.SimpleRotationLesson01;
import records.userRecords.UsersRecordUpdater;
import records.incorrectAnswersRecords.lessonRecords.CompletedLessonsTracker;

public class App {

    private static CompletedLessonsTracker tracker;

    private static String path = "/Users/emmanuellasolomon/Documents/Comp_Sci/repos/CosmicClassroom/Kinematics/src/main/resources/UserRecord.csv";
    public static void main(String[] args) {
        //CSVWriter.clearAndRewriteUserRecordHeadings();
        //CSVWriter.deleteRowFromCSV(path, 2);
        LessonController lessonController = new LessonController();
        tracker = new CompletedLessonsTracker();

//        //instances of lesson classes
        SimpleRotationLesson01 simpleRotation = new SimpleRotationLesson01(lessonController);
//        DirectionCosinesLesson02 directionCosines = new DirectionCosinesLesson02(lessonController);
        UsersRecordUpdater.setUser();
        //System.out.println(UserInfo.getUsername());
//
//        //call lesson classes
        simpleRotation.startLesson();
//        //directionCosines.startLesson();

        //startNextLesson(lessonController);

    }

}
