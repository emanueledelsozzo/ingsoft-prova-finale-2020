package it.polimi.ingsw.model;

import java.util.Observable;
import java.util.Observer;

public class ModelView extends Observable implements Observer {

    private Model modelCopy;

    public Choice getModelPlayerChoice(){
        return modelCopy.getPlayerChoice();
    }

    public Choice getModelCpuChoice(){
        return modelCopy.getCpuChoice();
    }

    public Outcome getModelOutcome(){
        return modelCopy.getOutcome();
    }

    @Override
    public void update(Observable o, Object arg) {
        if(!(o instanceof Model)){
            throw new IllegalArgumentException();
        }
        modelCopy = ((Model)o).clone();
        setChanged();
        notifyObservers();

    }
}
