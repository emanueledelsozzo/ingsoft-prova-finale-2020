package it.polimi.ingsw.view;

import java.util.ArrayList;
import java.util.List;

public class Observable<T> {

    private List<Observer<T>> observers = new ArrayList<>();

    public void addObservers(Observer<T> observer){
        observers.add(observer);
    }

    public void notify(T message){
        for(Observer<T> observer: observers){
            observer.update(message);
        }
    }

}
