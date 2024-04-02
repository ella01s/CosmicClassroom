import functionality.readWriteToFile.CSVWriter;
import lessons.chapter01.DirectionCosinesLesson02;
import lessons.chapter01.SimpleRotationLesson01;
import functionality.LessonController;
import records.incorrectAnswersRecords.UsersRecordUpdater;

public class App {

    private static String path = "/Users/emmanuellasolomon/Documents/Comp_Sci/repos/CosmicClassroom/Kinematics/src/main/resources/UserRecord.csv";
    public static void main(String[] args) {
        //CSVWriter.clearAndRewriteUserRecordHeadings();
        //CSVWriter.deleteRowFromCSV(path, 2);
        LessonController lessonController = new LessonController();
        //instances of lesson classes
        SimpleRotationLesson01 simpleRotation = new SimpleRotationLesson01(lessonController);
        DirectionCosinesLesson02 directionCosines = new DirectionCosinesLesson02(lessonController);
        UsersRecordUpdater.getUsername();

        //call lesson classes
        //simpleRotation.startLesson();
        //directionCosines.startLesson();

    }


}
