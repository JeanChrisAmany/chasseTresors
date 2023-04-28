package fr.carbonit.treasurehunt.functional.coordinates.model;

import fr.carbonit.treasurehunt.functional.line.model.Line;

public class Coordinates {

    private int ordinatesAxis;
    private int abscissasAxis;

    public Coordinates() {
    }

    public Coordinates(int ordinatesAxis, int abscissasAxis) {
        this.ordinatesAxis = ordinatesAxis;
        this.abscissasAxis = abscissasAxis;
    }

    public Coordinates(Line line) {
        String[] contents = line.getLine().split(" - ");
        this.ordinatesAxis = Integer.parseInt(contents[2]);
        this.abscissasAxis = Integer.parseInt(contents[1]);
    }

    public int getOrdinatesAxis() {
        return ordinatesAxis;
    }

    public void setOrdinatesAxis(int ordinatesAxis) {
        this.ordinatesAxis = ordinatesAxis;
    }

    public int getAbscissasAxis() {
        return abscissasAxis;
    }

    public void setAbscissasAxis(int abscissasAxis) {
        this.abscissasAxis = abscissasAxis;
    }
}
