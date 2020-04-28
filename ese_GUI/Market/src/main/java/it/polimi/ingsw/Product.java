package it.polimi.ingsw;

public class Product {

    enum Type{TOMATO, BASIL, POTATO};

    private Type type;

    public Product(Type type){
        this.type = type;
    }

    public Type getType(){
        return type;
    }

}
