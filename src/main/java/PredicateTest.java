import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bfitouri on 30/06/16.
 */
public class PredicateTest {

    List<Apple> filterApples(List<Apple> inventory,
                                    Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        PredicateTest test = new PredicateTest();

        Apple a1 = new Apple("blue", 15);
        Apple a2 = new Apple("red", 75);
        Apple a3 = new Apple("green", 255);
        List<Apple> apples = Arrays.asList(a1, a2, a3);


        List<Apple> res0 = test.filterApples(apples, new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return Apple.isGreenApple(apple);
            }
        });


        List<Apple> res1 = test.filterApples(apples, Apple::isGreenApple);


        List<Apple> res2 = test.filterApples(apples, apple -> Apple.isGreenApple(apple));


        res0.stream().map(apple -> apple.getColor() + " - " + apple.getWeight()).forEach(System.out::println);
        res1.stream().map(apple -> apple.getColor() + " - " + apple.getWeight()).forEach(System.out::println);
        res2.stream().map(apple -> apple.getColor() + " - " + apple.getWeight()).forEach(System.out::println);
    }














    public interface Predicate<T>{
        boolean test(T t);
    }

    static class Apple{

        Apple(String color, int weight){
            this.color = color;
            this.weight = weight;
        }
        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public static boolean isGreenApple(Apple apple) {
            return "green".equals(apple.getColor());
        }
        public static boolean isHeavyApple(Apple apple) {
            return apple.getWeight() > 150;
        }

        private String color;
        private int weight;
    }


}
