package it.polimi.ingsw;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestSerialization {

    public void start(Person pIn) throws IOException, ClassNotFoundException {

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(os);
        out.reset();
        out.writeObject(pIn);
        out.flush();
        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        ObjectInputStream in = new ObjectInputStream(is);
        Person pOut = (Person)in.readObject();
        System.out.println(pOut.getName());
        System.out.println(pOut.getBirthday().getTime());
        System.out.println(pOut.getAge());

    }

}
