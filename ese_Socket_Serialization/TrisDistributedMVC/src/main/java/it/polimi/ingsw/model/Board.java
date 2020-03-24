package it.polimi.ingsw.model;

import java.io.Serializable;

public class Board implements Cloneable, Serializable {

    private Cell[][] board = new Cell[3][3];

    public Board(){
        reset();
    }

    @Override
    protected final Board clone() {
        final Board result = new Board();
        for(int i = 0; i < 3; i++){
            result.board[i] = board[i].clone();
        }
        return result;
    }

    public void reset(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = Cell.EMPTY;
            }
        }
    }

    public void setCell(int row, int column, Cell marker) {
        if(row < 0 || column < 0 || row > 2 || column > 2){
            return;
        }
        board[row][column] = marker;
    }

    public Cell getCell(int row, int column) {
        if(row >= 0 && column >= 0 && row <= 2 && column <= 2){
            return board[row][column];
        } else {
            throw new RuntimeException();
        }
    }

    public boolean isEmpty(int row, int column) {
        return row >= 0 && column >= 0 && row <= 2 && column <= 2 && board[row][column] == Cell.EMPTY;
    }

    public boolean isGameOver(Cell marker){
        for(int i = 0; i < 3; i++){
            if(board[0][i] == marker && board[1][i] == marker && board[2][i] == marker){
                return true;
            }
            if(board[i][0] == marker && board[i][1] == marker && board[i][2] == marker){
                return true;
            }
        }
        return board[0][0] == marker && board[1][1] == marker && board[2][2] == marker ||
                board[0][2] == marker && board[1][1] == marker && board[2][0] == marker;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == Cell.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public void print(){
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + "|");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }

}
