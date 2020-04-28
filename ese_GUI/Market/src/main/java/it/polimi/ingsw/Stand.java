package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.Observable;
import it.polimi.ingsw.Product.Type;

public class Stand extends Observable {

    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product p){
        products.add(p);
        setChanged();
        notifyObservers();
    }

    public void buyProduct(Type type){
        boolean sold = false;
        for(Product p: products){
            if(p.getType()== type){
                products.remove(p);
                sold = true;
                break;
            }
        }
        if(sold) {
            setChanged();
            notifyObservers();
        }
    }

    public int getNumber(Type type){
        int result = 0;
        for(Product p: products){
            if(p.getType() == type){
                result++;
            }
        }
        return result;
    }

}
