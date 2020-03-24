package it.polimi.ingsw.observer;

public interface Observer<T> {

    void update(T message);

}
