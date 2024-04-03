package readAndWriteToFileTests;

import functionality.readWriteToFile.CSVReader;
import functionality.readWriteToFile.CSVWriter;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static functionality.readWriteToFile.CSVWriter.isUsernameExists;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVWriterTests {
    private static final String filePath = "/Users/emmanuellasolomon/Documents/Comp_Sci/repos/CosmicClassroom/Kinematics/src/main/resources/UserRecord.csv"; // Set the file path

    @ParameterizedTest(name = "Test writeDataToCSV method with rowData={0}")
    @CsvSource({
            "one,two,three",
            "alpha,beta,gamma,delta"
    })
    @DisplayName("test writeDataToCSV method")
    public void testWriteDataToCSV(String rowData) {
        String[] rowDataArray = rowData.split(",");
        CSVWriter.writeDataToCSV(filePath, rowDataArray);

        // Verify
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            List<String> lines = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            String lastLine = lines.get(lines.size() - 1);
            assertEquals(rowData, lastLine, "Expected row data is different from the actual data written to CSV.");
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @ParameterizedTest(name = "Test if user exists")
    @CsvSource({
            "ella",
            "jj"
    })
    @DisplayName("test if user exist checking method")
    public void testIfUserExists(String username) throws IOException {
        Boolean actual = isUsernameExists(filePath, username);
        Boolean expected = Boolean.TRUE;
        MatcherAssert.assertThat(actual, is(expected));
    }
}
