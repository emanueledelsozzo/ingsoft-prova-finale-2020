package it.polimi.ingsw;

public class PoliceCar {

    private static int currentId = 0;
    private final int id;
    private final int area;

    public PoliceCar(int area){
        id = currentId;
        currentId++;
        this.area = area;
    }

    public int getArea(){
        return area;
    }

    @Override
    public String toString(){
        return "PC" + id;
    }

    public String notified(){
        return "Police Car " + this + " notified!";
    }

}
