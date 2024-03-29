package functionality;

import functionality.score.IncorrectAnswersRecord;
import functionality.score.Score;

public class LessonController {
    private final IncorrectAnswersRecord incorrectAnswersRecord;
    private String userAnswer = "";
    private static Score score = new Score();

    // Constructor
    public LessonController() {
        // Create an instance of IncorrectAnswersRecord
        this.incorrectAnswersRecord = new IncorrectAnswersRecord();
    }

    public void checkAnswer(String userAnswer, String expected1, String expected2, String wrongAnswerResponse) {
        if (userAnswer.equalsIgnoreCase(expected1) || userAnswer.equalsIgnoreCase(expected2)) {
            System.out.println("correct");
            score.incrementScore();
            score.incrementChapter01Score();
            System.out.println(score);
        } else {
            System.out.println("incorrect");
            System.out.println(wrongAnswerResponse);
        }
    }

    public void questionAndAnswer(String question, String optionA, String optionB, String optionC, String optionD){
        System.out.println(question);
        System.out.println("A: "+ optionA);
        System.out.println("B: "+ optionB);
        System.out.println("C: "+ optionC);
        System.out.println("D: "+ optionD);
        System.out.println(" ");
        System.out.println("Type A, B, C or D in the terminal");
        String userAnswer = InputHelper.readLine();
    }

}


