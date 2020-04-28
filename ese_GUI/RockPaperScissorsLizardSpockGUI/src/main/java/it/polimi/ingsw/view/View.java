package it.polimi.ingsw.view;

import it.polimi.ingsw.model.Choice;
import it.polimi.ingsw.model.ModelView;

import java.util.Observable;
import java.util.Observer;

public abstract class View extends Observable implements Runnable, Observer {

    protected void processChoice(Choice choice){
        setChanged();
        notifyObservers(choice);
    }

    protected abstract void showModel(ModelView model);

    @Override
    public void update(Observable o, Object arg){
        if(!(o instanceof ModelView)){
            throw new IllegalArgumentException();
        }
        showModel((ModelView)o);
    }

}
