package fr.carbonit.treasurehunt.technical.properties;

import fr.carbonit.treasurehunt.functional.exceptions.ProgramException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/**
 * Classe technique permettant la gestion de la configuration du programme.s
 * <p>Cette classe est un signleton. Pour récupérer l'instance de cette dernière, passer par la méthode {@code getInstance()}
 */
public class ProgramProperties {

    private static ProgramProperties instance;

    static {
        try {
            instance = new ProgramProperties();
        } catch (ProgramException e) {
            e.printStackTrace();
        }
    }

    private String fileInputArgName;
    private String fileInputArgDescription;
    private boolean fileInputArgHasArg;
    private boolean fileInputArgRequired;
    private boolean fileInputArgOptional;
    private String fileOutputArgName;
    private String fileOutputArgDescription;
    private boolean fileOutputArgHasArg;
    private boolean fileOutputArgRequired;
    private boolean fileOutputArgOptional;
    private String mapLineStartWith;
    private String mountainLineStartWith;
    private String treasureLineStartWith;
    private String adventurerLineStartWith;
    private String commentLineStartWith;

    private ProgramProperties() throws ProgramException {

        Properties programProperties = new Properties();
        try {
            programProperties.load(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream("program.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }


        fileInputArgName = programProperties.getProperty("fileInputArgName");
        fileInputArgDescription = programProperties.getProperty("fileInputArgDescription");
        fileInputArgHasArg = Boolean.parseBoolean(programProperties.getProperty("fileInputArgHasArg"));
        fileInputArgRequired = Boolean.parseBoolean(programProperties.getProperty("fileInputArgRequired"));
        fileInputArgOptional = Boolean.parseBoolean(programProperties.getProperty("fileInputArgOptional"));

        fileOutputArgName = programProperties.getProperty("fileOutputArgName");
        fileOutputArgDescription = programProperties.getProperty("fileOutputArgDescription");
        fileOutputArgHasArg = Boolean.parseBoolean(programProperties.getProperty("fileOutputArgHasArg"));
        fileOutputArgRequired = Boolean.parseBoolean(programProperties.getProperty("fileOutputArgRequired"));
        fileOutputArgOptional = Boolean.parseBoolean(programProperties.getProperty("fileOutputArgOptional"));

        mapLineStartWith = programProperties.getProperty("mapLineStartWith");
        mountainLineStartWith = programProperties.getProperty("mountainLineStartWith");
        treasureLineStartWith = programProperties.getProperty("treasureLineStartWith");
        adventurerLineStartWith = programProperties.getProperty("adventurerLineStartWith");
        commentLineStartWith = programProperties.getProperty("commentLineStartWith");
    }

    public static ProgramProperties getInstance() {
        return instance;
    }

    public String getFileInputArgName() {
        return fileInputArgName;
    }

    public String getFileInputArgDescription() {
        return fileInputArgDescription;
    }

    public boolean isFileInputArgHasArg() {
        return fileInputArgHasArg;
    }

    public boolean isFileInputArgRequired() {
        return fileInputArgRequired;
    }

    public boolean isFileInputArgOptional() {
        return fileInputArgOptional;
    }

    public String getFileOutputArgName() {
        return fileOutputArgName;
    }

    public String getFileOutputArgDescription() {
        return fileOutputArgDescription;
    }

    public boolean isFileOutputArgHasArg() {
        return fileOutputArgHasArg;
    }

    public boolean isFileOutputArgRequired() {
        return fileOutputArgRequired;
    }

    public boolean isFileOutputArgOptional() {
        return fileOutputArgOptional;
    }

    public String getMapLineStartWith() {
        return mapLineStartWith;
    }

    public String getMountainLineStartWith() {
        return mountainLineStartWith;
    }

    public String getTreasureLineStartWith() {
        return treasureLineStartWith;
    }

    public String getAdventurerLineStartWith() {
        return adventurerLineStartWith;
    }

    public String getCommentLineStartWith() {
        return commentLineStartWith;
    }
}
