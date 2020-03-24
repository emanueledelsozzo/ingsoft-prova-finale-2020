package it.polimi.ingsw.controller;

import it.polimi.ingsw.model.Model;
import it.polimi.ingsw.model.PlayerMove;
import it.polimi.ingsw.utils.gameMessage;
import it.polimi.ingsw.observer.Observer;

public class Controller implements Observer<PlayerMove> {

    private final Model model;

    public Controller(Model model){
        super();
        this.model = model;
    }

    private synchronized void performMove(PlayerMove move){
        if(!model.isPlayerTurn(move.getPlayer())){
            move.getView().reportError(gameMessage.wrongTurnMessage);
            return;
        }
        if(!model.isFeasibleMove(move.getRow(), move.getColumn())){
            move.getView().reportError(gameMessage.occupiedCellMessage);
            return;
        }
        model.performMove(move.getRow(), move.getColumn(), move.getPlayer());
        model.updateTurn();
    }



    @Override
    public void update(PlayerMove message) {
        performMove(message);
    }
}
