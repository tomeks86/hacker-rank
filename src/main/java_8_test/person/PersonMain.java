import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class PersonMain {

    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));
        List<Person> people = new LinkedList<>();
        people.add(new Person("id1", "Stefan Beton", 16, "male"));
        people.add(new Person("id2", "Anika Matysik", 25, "female"));
        people.add(new Person("id3", "Frania Barańska", 30, "female"));
        people.add(new Person("id4", "Franek Leś", 12, "male"));
        people.add(new Person("id5", "Wojciech Noga", 22, "male"));
        people.add(new Person("id6", "Rebeka Wąsik", 52, "female"));
        people.add(new Person("id7", "Rebeka Woda", 82, "female"));
        people.add(new Person("id8", "Franciszek Piwko", 42, "male"));

        List<Person> adultPeople = people.stream()
                .filter(p -> p.getAge() > 17)
                .collect(toList());

        /*List<Person> adultMen = people.stream()
                .filter(p -> p.getAge() > 17)
                .filter(p -> p.getGender().equals("male"))
                .collect(Collectors.toList());*/

        System.out.println("Adult people:");
        for (Person adultPerson : adultPeople) {
            System.out.println(adultPerson.getName());
        }

        System.out.println();

        System.out.println("Adult males:");
        people.stream()
                .filter(p -> p.getAge() > 17 && p.getGender().equals("male"))
                .forEach(p -> System.out.println(p.getName()));
        System.out.println();

        System.out.println("People over 50 years old:");
        people.stream()
                .filter(p -> p.getAge() > 50)
                .forEach(p -> System.out.println(p.getName()));
        System.out.println();

        System.out.println("Adult women:");
        people.stream()
                .filter(p -> p.getAge() > 17 && p.getGender().equals("female"))
                .map(p -> p.getName())  //person -> String (!)
                .forEach(p -> System.out.println(p));
                //.collect(toList());
        System.out.println();

        int limit = 40;
        System.out.printf("People under %d years old:%n", limit);
        people.stream()
                .filter(p -> p.getAge() < limit)
                .map(p -> p.getName())
                .forEach(p -> System.out.println(p));
        System.out.println();

        System.out.printf("People at least %d years old:%n", limit);
        people.stream()
                .filter(p -> p.getAge() >= limit)
                .map(p -> p.getName())
                .forEach(p -> System.out.println(p));
        System.out.println();

        System.out.println("Eldest person: " + people.stream()
                .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2)
                .get().getName());

        people.stream()
                .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2)
                .ifPresent(p -> System.out.println(p.getName() + " " + p.getAge()));

        people.stream()
                .map(p -> p.getAge())
                .reduce((age1, age2) -> age1 + age2)
                .ifPresent(age -> System.out.println("Summary age: " + age));

        people.stream()
                .map(p -> p.getAge())
                .reduce((age1, age2) -> age1 + age2)
                .ifPresent(age -> System.out.printf("Average age: %6.2f%n", (double) age / people.size()));
        System.out.println();


        System.out.println("before sorting:");
        people.forEach(p -> System.out.println(p.getName() + " " + p.getAge()));
        System.out.println();
        //sorting
        Comparator<Person> personComparator = (p1, p2) -> {
            if (p1.getAge() > p2.getAge()) return 1;
            else if (p1.getAge() == p2.getAge()) return 0;
            else return -1;
        };

        System.out.println("People sorted by age:");
        Collections.sort(people, personComparator);
        people.forEach(p -> System.out.println(p.getName() + " " + p.getAge()));
    }
}
