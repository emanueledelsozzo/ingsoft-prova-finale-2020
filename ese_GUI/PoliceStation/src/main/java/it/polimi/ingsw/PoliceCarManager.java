package it.polimi.ingsw;

import java.util.ArrayList;

public class PoliceCarManager {

    private ArrayList<PoliceCar> dbPoliceCar = new ArrayList<>();

    public void addPoliceCar(PoliceCar p){
        dbPoliceCar.add(p);
    }

    public String notifyPoliceCars(int area) throws NoPoliceCarException{
        StringBuilder builder = new StringBuilder();
        for(PoliceCar policeCar: dbPoliceCar){
            if(policeCar.getArea() == area){
                builder.append(policeCar.notified() + "\n");
            }
        }
        String result = builder.toString();
        if(result.isEmpty()){
            throw new NoPoliceCarException();
        }
        return result;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("PoliceCarManager{dbPoliceCar=");
        for(int i = 0; i < dbPoliceCar.size(); i++){
            sb.append("[" + dbPoliceCar.get(i).toString() + " in area " +
                    dbPoliceCar.get(i).getArea());
            if(i < dbPoliceCar.size() - 1){
                sb.append("], ");
            } else {
                sb.append("]");
            }
        }
        sb.append("}");
        return sb.toString();

    }

}
