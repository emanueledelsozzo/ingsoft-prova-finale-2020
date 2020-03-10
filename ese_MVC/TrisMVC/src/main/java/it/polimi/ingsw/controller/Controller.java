package it.polimi.ingsw.controller;

import it.polimi.ingsw.model.Model;
import it.polimi.ingsw.model.Move;
import it.polimi.ingsw.view.View;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Controller implements Observer {

    private Model model;
    private View view;

    public Controller(Model model, View view){

        this.model = model;
        this.view = view;

    }

    @Override
    public void update(Observable o, Object arg) {
        if(o != view || !(arg instanceof Move)){
            throw new IllegalArgumentException();
        }
        Move m = (Move)arg;
        if(model.isFeasibleMove(m.getRow(), m.getColumn())){
            model.performMove(m.getRow(), m.getColumn(), model.getPlayerMarker());
        } else {
            return;
        }
        if(model.checkGameOver(model.getPlayerMarker())) {
            view.declareWinner(model.getPlayerMarker());
        } else if (model.checkIsFull()){
            view.declareDraw();
        } else {
            cpuGame();
        }
    }

    private void cpuGame() {
        Random r = new Random();
        while(true){
            int row = r.nextInt(3);
            int col = r.nextInt(3);
            if(model.isFeasibleMove(row, col)) {
                model.performMove(row, col, model.getCpuMarker());
                if(model.checkGameOver(model.getCpuMarker())){
                    view.declareWinner(model.getCpuMarker());
                } else if (model.checkIsFull()){
                    view.declareDraw();
                }
                return;
            }
        }
    }
}
