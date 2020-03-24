package it.polimi.ingsw;

import it.polimi.ingsw.view.Client;
import it.polimi.ingsw.view.Server;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class ClientApp
{
    public static void main(String[] args){
        Client client = new Client("127.0.0.1", 12345);
        try{
            client.run();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
