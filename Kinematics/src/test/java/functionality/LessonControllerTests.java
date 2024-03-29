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
}
