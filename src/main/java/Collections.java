import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by bfitouri on 08/01/16.
 */
public class Collections {

    private List<String> strings = Arrays.asList("abc", "bb", "cdefe", "daa");
    private List<Integer> numbers = Arrays.asList(5,7,4,2,3,1,6);

    public static void main(String[] args) {
        Collections col = new Collections();
        col.display();
        System.out.println("----------------------------------");
        col.filter();
        System.out.println("----------------------------------");
        col.pow();
        System.out.println("----------------------------------");
        col.sort1();
        System.out.println("----------------------------------");
        col.sort2();
    }

    public void display(){
        //Old way
        for (String s : strings){
            System.out.println(s);
        }
        //New Way
        strings.forEach(s -> System.out.println(s));

        //Or
        strings.forEach(System.out :: println);
    }

    public void filter(){

        Predicate<String> p1 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 6;
            }
        };

        Predicate<String> p = s -> s.length() > 3;
        List<String> res = strings.stream().filter(p).collect(Collectors.toList());
        res.forEach(System.out :: println);
    }

    public void pow(){
        Integer i = numbers.stream()
                .filter(n -> n < 3)
                .map(n -> n * n)
                .reduce((a,b) -> a + b).get();
        System.out.println("result of pow is : " + i);
    }

    public void sort1(){
        //sort is imlemented in interface List (default method)
        numbers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        numbers.forEach(System.out :: println);
    }

    public void sort2(){
        //Comparator is a functional Interface, we could do like this
        numbers.sort((a,b) -> (b - a));
        numbers.forEach(System.out :: println);
    }
}
