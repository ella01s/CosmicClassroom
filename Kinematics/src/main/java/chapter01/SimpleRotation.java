package chapter01;

import functionality.InputHelper;
import functionality.LessonController;
import functionality.score.Score;


public class SimpleRotation {
    private static Score score = new Score();
    private String topic = "Simple Rotation";
    private LessonController lessonController;

    public static void main(String[] args) {
        InputHelper.closeScanner();
    }
    public SimpleRotation(LessonController lessonController) {
        this.lessonController = lessonController;
    }

    public void startLesson(){
        explain();
        textBreak();
        questionAndAnswer();
    }

    public void explain(){
        System.out.println("This lesson will discuss Simple rotation.");
        System.out.println(" ");
        System.out.println("In simple rotation, points on a rigid object move on circular paths around an axis of rotation.\n" +
                "The axis of rotation is like an imaginary line that runs through an object when it spins or rotates.");
    }

    public void questionAndAnswer(){
        System.out.println("Which of the following is an example of simple rotation?");
        System.out.println("A: A spinning top spinning in place.");
        System.out.println("B: A football spinning through the air as it travels across a football pitch.");
        System.out.println("C: An ice skater spinning on one spot.");
        System.out.println("D: A pendulum moving from side to side.");
        System.out.println(" ");
        System.out.println("Type A, B, C or D in the terminal");

        String userAnswer = InputHelper.readLine();
        lessonController.checkAnswer(userAnswer, "C", "A",
                """
                        The correct answer was A or C.
                        Option B involves both translational motion (the movement across the football pitch) and rotational motion (the spinning).\s
                        Option D describes an oscillatory motion rather than a simple rotation.\s
                        B and D are incorrect because they describe different types of motion, not simple rotation.\s""");
    }

    public void tryAgain(){
        textBreak();
        System.out.println("Try answering the question again");
        System.out.println(" ");
        questionAndAnswer();
    }

    public void textBreak(){
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println(" ");
    }

    public String getTopic() {
        return topic;
    }


}
