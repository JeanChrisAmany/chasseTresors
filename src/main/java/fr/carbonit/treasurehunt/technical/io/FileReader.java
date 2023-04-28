package fr.carbonit.treasurehunt.technical.io;

import fr.carbonit.treasurehunt.functional.exceptions.FileNotFoundException;
import fr.carbonit.treasurehunt.functional.exceptions.ProgramException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public abstract class FileReader {

    /**
     * Méthode permetttant de récupérer toutes les lignes du fichier sous forme de liste de Strings
     * @param filePath
     * @return
     * @throws ProgramException
     */
    public static List<String> getFileLines(String filePath) throws ProgramException {

        List<String> fileLine = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Path.of(filePath))) {
            stream.forEach(fileLine::add);
        } catch (IOException ioe) {
            throw new FileNotFoundException("Impossible de lire le fichier fournit.");
        }

        return fileLine;
    }
}
