package it.polimi.ingsw.model;

import it.polimi.ingsw.observer.Observable;

public class Model extends Observable<MoveMessage> {

    private Board board = new Board();
    private Cell turn = Cell.X;

    public boolean isPlayerTurn(Player player) {
        return player.getMarker() == turn;
    }

    public Board getBoardCopy(){
        return board.clone();
    }

    public boolean isFeasibleMove(int row, int col){
        return board.isEmpty(row, col);
    }

    public void performMove(int row, int column, Player player){
        board.setCell(row, column, player.getMarker());
        boolean hasWon = board.isGameOver(player.getMarker());
        notify(new MoveMessage(board.clone(), player));
        if(hasWon || board.isFull()){
            board.reset();
        }
    }

    public void updateTurn(){
        if(turn == Cell.X){
            turn = Cell.O;
        }
        else{
            turn = Cell.X;
        }
    }

}
