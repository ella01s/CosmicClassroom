package functionality;

import functionality.score.IncorrectAnswersRecord;
import functionality.score.Score;

public class LessonController {
    private final IncorrectAnswersRecord incorrectAnswersRecord;
    private static Score score = new Score();

    public LessonController() {
        this.incorrectAnswersRecord = new IncorrectAnswersRecord();
    }

    public static void checkAnswer(String userAnswer, String expected1, String expected2, String wrongAnswerResponse) {
        if (userAnswer.equalsIgnoreCase(expected1) || userAnswer.equalsIgnoreCase(expected2)) {
            System.out.println("correct");
            score.incrementScore();
            score.incrementChapter01Score();
            System.out.println(score);
        } else {
            System.out.println("incorrect  :(");
            System.out.println(wrongAnswerResponse);
        }
    }

    public static void generateQuestion(String question, String optionA, String optionB, String optionC, String optionD){
        System.out.println(question);
        System.out.println("A: "+ optionA);
        System.out.println("B: "+ optionB);
        System.out.println("C: "+ optionC);
        System.out.println("D: "+ optionD);
        System.out.println(" ");
        System.out.println("Type A, B, C or D in the terminal");
    }

    public static void generateExplanation(String topic, String lessonInfo){
        System.out.println("This lesson will discuss "+ topic);
        System.out.println(" ");
        System.out.println(lessonInfo);
    }
}


