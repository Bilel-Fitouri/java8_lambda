import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by bfitouri on 09/06/16.
 */
public class Collectors {

    public static void main(String[] args) {
        Collectors.Person p1 = new Collectors.Person("a", 13);
        Collectors.Person p2 = new Collectors.Person("b", 14);
        Collectors.Person p3 = new Collectors.Person("c", 15);
        Collectors.Person p4 = new Collectors.Person("d", 17);
        Collectors.Person p5 = new Collectors.Person("e", 19);
        Collectors.Person p6 = new Collectors.Person("f", 14);
        Collectors.Person p7 = new Collectors.Person("g", 11);
        List<Person> persons = Arrays.asList(p1,p2,p3,p4,p5,p6,p7);

        Map<String,Person> map =
         persons.stream().collect(java.util.stream.Collectors.toMap(Person::getName,Function.identity()));


        System.out.println(map);


        //java.util.stream.Collectors.toMap()




    }


    static class Person{

        public Person(String name, int age){
            this.age = age;
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        String name;
        int age;


    }
}
