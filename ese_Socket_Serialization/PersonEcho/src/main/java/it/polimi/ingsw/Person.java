package it.polimi.ingsw;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Calendar;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;
    private Calendar birthday;
    private transient int age;

    public Person(String name, Calendar birthday){
        this.name = name;
        this.birthday = birthday;
    }

    public void computeAge(){
        Calendar today = Calendar.getInstance();
        age = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
        if (today.get(Calendar.MONTH) < birthday.get(Calendar.MONTH) ||
                (today.get(Calendar.MONTH) == birthday.get(Calendar.MONTH) &&
                        today.get(Calendar.DATE) < birthday.get(Calendar.DATE))) {
            age--;
        }
    }

    public String getName() {
        return name;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public int getAge() {
        return age;
    }

    private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
        in.defaultReadObject();
        computeAge();
    }

    public void setBirthdayYear(int year) {
        this.birthday.set(Calendar.YEAR, year);
        computeAge();
    }
}
