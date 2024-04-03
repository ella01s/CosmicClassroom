package lessons.chapter01;

import functionality.InputHelper;
import functionality.LessonController;
import functionality.score.Score;
import ui.Formatting;

public class DirectionCosinesLesson02 {
    private static Score score = new Score();
    private String topic = "DirectionCosines02";
    private LessonController lessonController;
    private Formatting formatting;
    public static void main(String[] args) {
        InputHelper.closeScanner();
    }
    public DirectionCosinesLesson02(LessonController lessonController) {

        this.lessonController = lessonController;
        this.formatting = new Formatting();
    }

    public void startLesson(){
        topicInfo();
        formatting.textBreak();
        questionAndAnswer();
    }

    public void topicInfo(){
        LessonController.generateExplanation(topic, "A dextral set of orthogonal unit vectors refers to a set of three vectors that are mutually orthogonal (perpendicular to each other) \n" +
                "and form a right-handed coordinate system. One example of a shape that forms a dextral set of orthogonal unit vectors is a standard three-dimensional Cartesian coordinate system, \n" +
                "often represented by a cube as long as the edges align with the coordinate axes, which a cube naturally does.\n" +
                "The alignment of the edges of the cube with the coordinate axes is what defines the cube as a coordinate system. \n" +
                "Y\n" +
                        "|     Z\n" +
                        "|   /\n" +
                        "|  /\n" +
                        "| /\n" +
                        "|/______________ X\n"
                );
    }

    public void questionAndAnswer(){
        lessonController.generateQuestion("Which shape can we derive a dextral set of orthogonal unit vectors from?", "Rectangle",
                "Square","Rectangular prism", "Cube");

        String userAnswer = InputHelper.readLine();
        lessonController.checkAnswer(userAnswer, "C", "D",
                """
                        The correct answer was C or D.
                        Both a square and a rectangle are flat shapes without depth,\s
                        so they can't be used to define a dextral set of orthogonal unit vectors in three-dimensional space.\s""");

    }

    public void tryAgain(){
        formatting.textBreak();
        System.out.println("Try answering the question again");
        System.out.println(" ");
        questionAndAnswer();
    }

    public String getTopic() {
        return topic;
    }
}
