package it.polimi.ingsw;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            TestSerialization s = new TestSerialization();
            Person p0 = new Person("person0", new GregorianCalendar(1990, Calendar.MARCH, 23));
            p0.computeAge();
            Person p1 = new Person("person1", new GregorianCalendar(2001, Calendar.JUNE, 12));
            p0.computeAge();
            p1.computeAge();
            s.start(p0);
            s.start(p1);
            p0.setBirthdayYear(1980);
            s.start(p0);
        } catch(IOException | ClassNotFoundException e){
            System.err.println(e.getMessage());
        }


    }
}
