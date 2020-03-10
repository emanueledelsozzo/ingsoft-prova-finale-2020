package it.polimi.ingsw.model;

public enum Cell {
    X("X"),O("O"),EMPTY("-");

    private final String message;

    Cell(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
