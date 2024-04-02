package functionality;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;

public class LessonControllerTests {

    @Test
    @DisplayName("test topic explanation generator")
    public void testExplanationGenerator(){
        String topic = "Apples";
        String lessonInfo = "Apples can be green or red.";
        // Capture the printed output using System.setOut()
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);

        // Call the method that prints the explanation
        LessonController.generateExplanation(topic, lessonInfo);

        // Reset System.out to its original value
        System.setOut(originalOut);

        // Convert the captured output to a string
        String actualResult = outputStream.toString().trim();

        // Define the expected result
        String expectedResult = "This lesson will discuss Apples\n \nApples can be green or red.";

        // Assert that the actual result matches the expected result
        MatcherAssert.assertThat(actualResult, is(expectedResult));
    }

    @Test
    @DisplayName("test question generator")
    public void questionGeneratorTest(){
        String question = "What colour is the sky?";
        String OptionA = "blue";
        String OptionB = "gold";
        String OptionC = "silver";
        String OptionD = "the same as the sea";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); //make an instance of ByteArrayOutputStream
        PrintStream printStream = new PrintStream(outputStream); //make an instance of PrintStream and pass ByteArrayOutputStream instance to it
        PrintStream originalOut = System.out; //make PrintStream instance of the original System.out
        System.setOut(printStream);

        LessonController.generateQuestion(question, OptionA, OptionB, OptionC, OptionD);
        System.setOut(originalOut);

        String actualResult = outputStream.toString().trim();
        String expectedResult = "What colour is the sky?\nA: blue\nB: gold\nC: silver\nD: the same as the sea\n \nType A, B, C or D in the terminal";

        MatcherAssert.assertThat(actualResult, is(expectedResult));
    }

    @Test
    @DisplayName("test checkAnswer method - correct answer, expected1")
    public void checkAnswerTestCorrect01(){
        String userAnswer = "blue";
        String expected1 = "blue";
        String expected2 = "the same as the sea";
        String wrongAnswerResponse= "the sky is blue";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);

        LessonController.checkAnswer(userAnswer, expected1, expected2, wrongAnswerResponse);
        System.setOut(originalOut);

        String actualResult = outputStream.toString().trim();
        String expectedResult = "correct\n \nYour current score is: 1";

        MatcherAssert.assertThat(actualResult, is(expectedResult));
    }

    @Test
    @DisplayName("test checkAnswer method - correct answer, expected2")
    public void checkAnswerTestCorrect02() {
        String userAnswer = "the same as the sea";
        String expected1 = "blue";
        String expected2 = "the same as the sea";
        String wrongAnswerResponse = "the sky is blue";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);

        LessonController.checkAnswer(userAnswer, expected1, expected2, wrongAnswerResponse);
        System.setOut(originalOut);

        String actualResult = outputStream.toString().trim();
        String expectedResult = "correct\n \nYour current score is: 2";

        MatcherAssert.assertThat(actualResult, is(expectedResult));
    }

    @Test
    @DisplayName("test checkAnswer method - incorrect answer")
    public void checkAnswerTestIncorrect() {
        String userAnswer = "pink";
        String expected1 = "blue";
        String expected2 = "the same as the sea";
        String wrongAnswerResponse = "the sky is blue";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream orginalOut = System.out;
        System.setOut(printStream);

        LessonController.checkAnswer(userAnswer, expected1, expected2, wrongAnswerResponse);

        String actualResult = outputStream.toString().trim();
        String expectResult = "incorrect  :(\nthe sky is blue";
        MatcherAssert.assertThat(actualResult, is(expectResult));
    }
}
