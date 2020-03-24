package it.polimi.ingsw.model;

import it.polimi.ingsw.view.View;

public class PlayerMove {

    private final int row;
    private final int column;
    private final Player player;
    private final View view;

    public PlayerMove(Player player, int row, int column, View view) {
        this.player = player;
        this.row = row;
        this.column = column;
        this.view = view;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Player getPlayer() {
        return player;
    }

    public View getView() {
        return view;
    }


}
