package readAndWriteToFileTests;

import functionality.readWriteToFile.CSVReader;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;

public class CSVReaderTests {

    @ParameterizedTest(name = "Test getLevelByUsername method with username={0} and expected level={1}")
    @CsvSource({
            "jj, 0",
            "ella, 1"
    })
    @DisplayName("test getLevelByUsername method")
    public void testLevelGetter(String username, String expectedLevel) throws IOException {
        String filePath = "/Users/emmanuellasolomon/Documents/Comp_Sci/repos/CosmicClassroom/Kinematics/src/main/resources/UserRecord.csv";
        String actual = CSVReader.getLevelByUsername(filePath, username);
        MatcherAssert.assertThat(actual, is(expectedLevel));
    }
}
