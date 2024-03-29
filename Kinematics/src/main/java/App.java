import chapter01.SimpleRotation;
import functionality.LessonController;

public class App {
    public static void main(String[] args) {
        LessonController lessonController = new LessonController();
        //instances of lesson classes
        SimpleRotation simpleRotation = new SimpleRotation(lessonController);

        //call lesson classes
        simpleRotation.startLesson();

    }


}
