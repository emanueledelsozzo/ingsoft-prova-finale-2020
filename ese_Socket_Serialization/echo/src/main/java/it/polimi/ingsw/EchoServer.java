package it.polimi.ingsw;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

    private int port;
    private ServerSocket serverSocket;

    public EchoServer(int port){
        this.port = port;
    }

    public void startServer() throws IOException {
        //open TCP port
        serverSocket = new ServerSocket(port);
        System.out.println("Server socket ready on port: " + port);
        //wait for connection
        Socket socket = serverSocket.accept();
        System.out.println("Received client connection");
        // open input and output streams to read and write
        Scanner in = new Scanner(socket.getInputStream());
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        //read from and write to the connection until I receive "quit"
        while(true){
            String line = in.nextLine();
            if(line.equals("quit")){
                break;
            } else {
                out.println("Received: " + line);
                out.flush();
            }
        }
        //close streams and socket
        System.out.println("Closing sockets");
        in.close();
        out.close();
        socket.close();
        serverSocket.close();
    }

}
