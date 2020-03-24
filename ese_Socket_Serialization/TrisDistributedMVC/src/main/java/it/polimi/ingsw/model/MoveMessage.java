package it.polimi.ingsw.model;

public class MoveMessage {

    private final Player player;

    private final Board board;

    MoveMessage(Board board, Player player) {
        this.player = player;
        this.board = board;
    }

    public Player getPlayer() {
        return player;
    }

    public Board getBoard() {
        return board;
    }

}
