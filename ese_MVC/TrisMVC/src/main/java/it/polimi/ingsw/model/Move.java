package it.polimi.ingsw.model;

public class Move {

    private final int row;
    private final int column;

    public Move(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }


}
