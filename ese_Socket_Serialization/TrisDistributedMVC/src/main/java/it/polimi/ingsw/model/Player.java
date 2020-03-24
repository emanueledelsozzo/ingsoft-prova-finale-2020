package it.polimi.ingsw.model;

public class Player {

    private final String name;

    private final Cell marker;

    public Player(String name, Cell marker) {
        this.name = name;
        this.marker = marker;
    }

    public Cell getMarker() {
        return marker;
    }

    @Override
    public String toString() {
        return name;
    }


}
