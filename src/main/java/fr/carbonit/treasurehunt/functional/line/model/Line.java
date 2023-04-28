package fr.carbonit.treasurehunt.functional.line.model;

public class Line {

    private String line;
    private LineType lineType;

    public Line() {
    }

    public Line(String line, LineType lineType) {
        this.line = line;
        this.lineType = lineType;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public LineType getLineType() {
        return lineType;
    }

    public void setLineType(LineType lineType) {
        this.lineType = lineType;
    }
}
