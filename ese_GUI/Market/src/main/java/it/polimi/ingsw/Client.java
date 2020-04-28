package it.polimi.ingsw;

import java.util.Random;

public class Client {

    public void buy(Stand stand){
        Random random = new Random();
        int num = random.nextInt(Product.Type.values().length);
        stand.buyProduct(Product.Type.values()[num]);
    }

}
