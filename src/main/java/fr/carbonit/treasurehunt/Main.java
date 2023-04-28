package fr.carbonit.treasurehunt;

import fr.carbonit.treasurehunt.functional.adventurer.model.Adventurer;
import fr.carbonit.treasurehunt.functional.adventurer.service.AdventurerService;
import fr.carbonit.treasurehunt.functional.line.model.Line;
import fr.carbonit.treasurehunt.functional.line.utils.LineUtils;
import fr.carbonit.treasurehunt.functional.map.builder.MapBuilder;
import fr.carbonit.treasurehunt.functional.map.model.Cell;
import fr.carbonit.treasurehunt.technical.cli.CliManager;
import fr.carbonit.treasurehunt.technical.io.FileReader;
import fr.carbonit.treasurehunt.technical.io.FileWriter;
import fr.carbonit.treasurehunt.technical.properties.ProgramProperties;
import org.apache.commons.cli.CommandLine;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        CommandLine commandLine = CliManager.getCommandLine(args);

        String fileToReadPath = CliManager.getArgumentValue(commandLine, ProgramProperties.getInstance().getFileInputArgName());

        List<Line> linesTypes = LineUtils.getAllLinesTypes(FileReader.getFileLines(fileToReadPath));

        Cell[][] map = MapBuilder.build(linesTypes);

        List<Adventurer> adventurers = AdventurerService.getAdventurersFromLines(linesTypes);

        AdventurerService.placeAdventurersOnMap(map, adventurers);

        AdventurerService.playAdventurersMovements(map, adventurers, 0);

        FileWriter.writeProgramOutputFile(
                commandLine,
                ProgramProperties.getInstance().getFileOutputArgName(),
                map,
                adventurers,
                linesTypes
        );
    }
}