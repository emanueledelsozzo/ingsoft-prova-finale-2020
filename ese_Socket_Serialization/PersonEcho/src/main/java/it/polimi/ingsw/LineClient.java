package it.polimi.ingsw;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LineClient {
    private String ip;
    private int port;

    public LineClient(String ip, int port){
        this.ip = ip;
        this.port = port;
    }

    public void startClient() throws IOException {

        int year = 1989;
        Person p = new Person("client0", new GregorianCalendar(year, Calendar.FEBRUARY, 2));
        Socket socket = new Socket(ip, port);
        System.out.println("Connection established");
        Scanner stdin = new Scanner(System.in);

        ObjectOutputStream socketOut = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream socketIn = new ObjectInputStream(socket.getInputStream());

        socketOut.reset();
        socketOut.writeObject(p);
        socketOut.flush();

        try{
            while (true){
                //socketOut.reset();
                //socketOut.writeObject(p);
                //socketOut.flush();
                String inputLine = stdin.nextLine();
                socketOut.reset();
                socketOut.writeUTF(inputLine);
                socketOut.flush();
                String socketLine = socketIn.readUTF();
                System.out.println(socketLine);
                //year--;
                //p.setBirthdayYear(year);
            }
        }
        catch (IOException e) {
           System.out.println("Connection closed");
        } finally {
            stdin.close();
            socketIn.close();
            socketOut.close();
            socket.close();
        }
    }

}
