package it.polimi.ingsw.model;

import java.util.Observable;

public class Model extends Observable {

    private Board board = new Board();
    private Cell playerMarker = Cell.X;
    private Cell cpuMarker = Cell.O;

    public boolean isFeasibleMove(int row, int col){
        return board.isEmpty(row, col);
    }

    public void performMove(int row, int col, Cell p){
        board.setCell(row, col, p);
        setChanged();
        notifyObservers(board.clone());
    }

    public boolean checkGameOver(Cell p) {
        return board.isGameOver(p);
    }

    public Cell getPlayerMarker() {
        return playerMarker;
    }

    public Cell getCpuMarker() {
        return cpuMarker;
    }

    public boolean checkIsFull() {
        return board.isFull();
    }
}
