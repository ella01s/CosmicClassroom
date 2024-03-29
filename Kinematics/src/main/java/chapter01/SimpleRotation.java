package chapter01;

import functionality.InputHelper;
import functionality.LessonController;
import functionality.score.Score;
import ui.Formatting;


public class SimpleRotation {
    private static Score score = new Score();
    private String topic = "Simple Rotation";
    private LessonController lessonController;
    private Formatting formatting;
    public static void main(String[] args) {
        InputHelper.closeScanner();
    }
    public SimpleRotation(LessonController lessonController) {

        this.lessonController = lessonController;
        this.formatting = new Formatting();
    }

    public void startLesson(){
        topicInfo();
        formatting.textBreak();
        questionAndAnswer();
    }

    public void topicInfo(){
        LessonController.generateExplanation(topic, "In simple rotation, points on a rigid object move on circular paths around an axis of rotation.\n" +
                "The axis of rotation is like an imaginary line that runs through an object when it spins or rotates.");
    }

    public void questionAndAnswer(){
        lessonController.generateQuestion("Which of the following is an example of simple rotation?", "A spinning top spinning in place.",
                "A football spinning through the air as it travels across a football pitch.","An ice skater spinning on one spot.", "An ice skater spinning on one spot.");

        String userAnswer = InputHelper.readLine();
        lessonController.checkAnswer(userAnswer, "C", "A",
                """
                        The correct answer was A or C.
                        Option B involves both translational motion (the movement across the football pitch) and rotational motion (the spinning).\s
                        Option D describes an oscillatory motion rather than a simple rotation.\s
                        B and D are incorrect because they describe different types of motion, not simple rotation.\s""");
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
