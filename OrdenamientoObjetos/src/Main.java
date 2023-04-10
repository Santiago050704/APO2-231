import model.DANEPerson;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<DANEPerson> people = new ArrayList<>();
        people.add(
                new DANEPerson(444, "Ximena", "Rodriguez", 40)
        );
        people.add(
                new DANEPerson(111, "Andres", "Rodriguez", 20)
        );
        people.add(
                new DANEPerson(222, "José", "Zapata", 17)
        );
        people.add(
                new DANEPerson(333, "Alexandra", "Londoño", 18)
        );
        people.add(
                new DANEPerson(444, "Verónica", "Andrade", 40)
        );
        people.add(
                new DANEPerson(444, "Lucia", "Rodriguez", 40)
        );
        people.add(
                new DANEPerson(444, "Rafael", "Rodriguez", 40)
        );

        //ArrayList -> Collections
        //Array [] -> Arrays
        Collections.sort(people);

        people.forEach(person ->{
            System.out.println(person.getName() + " " + person.getLastname());
        });

        Collections.sort(people, (a, b) ->{
            return a.getAge() - b.getAge();
        });

        System.out.println("*****************");
        people.forEach(person ->{
            System.out.println(person.getName() + " " + person.getLastname() + " " + person.getAge());
        });

        Collections.sort(people, (a, b) ->{
            return a.getName().compareTo(b.getName());
        });

        System.out.println("*****************");
        people.forEach(person ->{
            System.out.println(person.getName() + " " + person.getLastname() + " " + person.getAge());
        });
    }
}