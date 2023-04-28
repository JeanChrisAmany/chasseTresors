package fr.carbonit.treasurehunt.technical.cli;

import fr.carbonit.treasurehunt.technical.properties.ProgramProperties;
import org.apache.commons.cli.*;

public abstract class CliManager {

    public static CommandLine getCommandLine(String[] args) throws ParseException {

        Options options = new Options();
        Option programInputFileArgument = createArgument(
                ProgramProperties.getInstance().getFileInputArgName(),
                ProgramProperties.getInstance().isFileInputArgHasArg(),
                ProgramProperties.getInstance().getFileInputArgDescription(),
                ProgramProperties.getInstance().isFileInputArgRequired(),
                ProgramProperties.getInstance().isFileInputArgOptional()
        );
        Option programOutputFileArgument = createArgument(
                ProgramProperties.getInstance().getFileOutputArgName(),
                ProgramProperties.getInstance().isFileOutputArgHasArg(),
                ProgramProperties.getInstance().getFileOutputArgDescription(),
                ProgramProperties.getInstance().isFileOutputArgRequired(),
                ProgramProperties.getInstance().isFileOutputArgOptional()
        );
        options.addOption(programInputFileArgument);
        options.addOption(programOutputFileArgument);

        return parseArguments(options, args);
    }

    public static Option createArgument(String argName, boolean hasArg, String argDescription, boolean required, boolean optional) {
        return Option.builder()
                .longOpt(argName)
                .optionalArg(optional)
                .argName(argName)
                .hasArg(hasArg)
                .desc(argDescription)
                .required(required)
                .build();
    }

    public static CommandLine parseArguments(Options options, String[] args) throws ParseException {

        CommandLineParser commandLineParser = new DefaultParser();
        HelpFormatter helpFormatter = new HelpFormatter();

        try {
            return commandLineParser.parse(options, args);
        } catch (ParseException pe) {
            helpFormatter.printHelp("java", options);
            System.out.println("############### /!\\ ###############");
            System.out.println("Impossible de récupérer les arguments depuis la commande de lancement du programme. Arrêt du programe en cours !");
            System.out.println("Pour plus d'informations, regarder la suite de la console du programme.");
            System.out.println("############### /!\\ ###############");
            pe.printStackTrace();
            System.exit(0);
            throw new ParseException(pe.getMessage());
        }
    }

    public static String getArgumentValue(CommandLine commandLine, String argName) {
        return commandLine.getOptionValue(argName);
    }
}
