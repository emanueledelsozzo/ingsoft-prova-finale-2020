package it.polimi.ingsw;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class ServerMain
{
    public static void main( String[] args )
    {
        MultiEchoServer server = new MultiEchoServer(1337);
        try {
            server.startServer();
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
