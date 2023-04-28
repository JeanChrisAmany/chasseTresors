package fr.carbonit.treasurehunt.technical;

import fr.carbonit.treasurehunt.functional.exceptions.FileNotFoundException;
import fr.carbonit.treasurehunt.functional.exceptions.ProgramException;
import fr.carbonit.treasurehunt.technical.io.FileReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTest {

    private final String resourcesPath = "src/test/resources/";

    @Test
    public void should_return_valid_list_of_lines() throws ProgramException {

        //GIVEN
        String testFilePath = new File(resourcesPath + "testInput.txt").getAbsolutePath();

        List<String> testLines = new ArrayList<>();
        testLines.add("C - 3 - 3");
        testLines.add("M - 2 - 2");
        testLines.add("M - 1 - 1");

        //WHEN
        List<String> readedLines = FileReader.getFileLines(testFilePath);

        //THEN
        assertEquals(3, readedLines.size());
        assertTrue(readedLines.get(0).equalsIgnoreCase(testLines.get(0)));
        assertTrue(readedLines.get(1).equalsIgnoreCase(testLines.get(1)));
        assertTrue(readedLines.get(2).equalsIgnoreCase(testLines.get(2)));
    }

    @Test
    public void should_throws_FileNotFoundException() {
        assertThrows(
                FileNotFoundException.class, () -> FileReader.getFileLines("")
        );
    }
}
