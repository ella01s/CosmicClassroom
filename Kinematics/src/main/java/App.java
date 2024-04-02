import chapter01.SimpleRotation;
import functionality.LessonController;
import functionality.readWriteToFile.CSVWriter;
import records.incorrectAnswersRecords.UsersRecordUpdater;

public class App {

    private static String path = "/Users/emmanuellasolomon/Documents/Comp_Sci/repos/CosmicClassroom/Kinematics/src/main/resources/UserRecord.csv";
    public static void main(String[] args) {
        //CSVWriter.clearAndRewriteUserRecordHeadings();
        //CSVWriter.deleteRowFromCSV(path, 2);
        LessonController lessonController = new LessonController();
        //instances of lesson classes
        SimpleRotation simpleRotation = new SimpleRotation(lessonController);
        UsersRecordUpdater.getUsername();

        //call lesson classes
        //simpleRotation.startLesson();

    }


}
