package fr.carbonit.treasurehunt.functional.map.model;

import fr.carbonit.treasurehunt.functional.adventurer.model.Adventurer;

/**
 * Cellule permettant de représenter la carte sous la forme d'une matrice
 */
public class Cell {

    private int posX;
    private int posY;
    private Boolean isMountain;
    private int treasures;
    private Adventurer adventurer;

    public Cell() {
    }

    public Cell(int x, int y) {
        this.posX = x;
        this.posY = y;
        this.isMountain = false;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Boolean isMountain() {
        return isMountain;
    }

    public void setMountain(Boolean mountain) {
        isMountain = mountain;
    }

    public int getTreasures() {
        return treasures;
    }

    public void setTreasures(int treasures) {
        this.treasures = treasures;
    }

    public Adventurer getAdventurer() {
        return adventurer;
    }

    public void setAdventurer(Adventurer adventurer) {
        this.adventurer = adventurer;
    }
}
