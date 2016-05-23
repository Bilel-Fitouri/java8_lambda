import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

/**
 * Created by bfitouri on 08/01/16.
 */
public class Groupping {

    public static void main(String[] args) {
        Person p1 = new Person(25, "A");
        Person p2 = new Person(32, "B");
        Person p3 = new Person(21, "C");
        Person p4 = new Person(25, "D");
        Person p5 = new Person(25, "E");
        Person p6 = new Person(21, "F");
        List<Person> persons = Arrays.asList(p1,p2,p3,p4,p5,p6);

        System.out.println("--------------------");
        personsGroupedByAge(persons);

        System.out.println("--------------------");
        personsNamesGroupedByAge(persons);

    }

    private static void personsNamesGroupedByAge(List<Person> persons) {
        Map<Integer, List<String>> groupedByAgeStrings =
                persons
                        .stream()
                        .collect(
                                groupingBy(p -> p.getAge(), mapping( p -> p.getName(), Collectors.toList()))
                        );


        groupedByAgeStrings.forEach((k,v)-> System.out.println("age : " + k + " names : " + v.toString()));
    }

    private static void personsGroupedByAge(List<Person> persons) {
        Map<Integer, List<Person>> groupedByAgePersons =
                persons
                        .stream()
                        .collect(groupingBy(p -> p.getAge()));

        Map<Integer, List<Person>> groupedByAgePersons2 =
                persons
                        .stream()
                        .collect(groupingBy(Person::getAge));

        groupedByAgePersons.forEach((k,v)-> {
            System.out.println("age : " + k );
            System.out.println("names : " );
            v.forEach(p -> System.out.println(p.getName()));
        });
    }

    public static class Person{

        Person(int age, String name){
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;


    }
}