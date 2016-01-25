/**
 * Created by bfitouri on 08/01/16.
 */
public class FunctionalInterface {

     public static void main(String[] args) {

         Doubler d1 = new Doubler() {
             @Override
             public int doSomething(int x) {
                 return x * 2;
             }
         };

         Doubler d2 = x -> { return x * 3;};

         System.out.println("Result with non lambda code :" + d1.doSomething(50));
         System.out.println("Result with lambda code : " + d2.doSomething(50));

         NoArgInterface nai = () -> {return 42;};

         System.out.println("Result with lambda code (with no arg) : " + nai.returnFixedNumber());
    }

    @java.lang.FunctionalInterface
    public interface Doubler {
        int doSomething(int x);
    }

    public interface NoArgInterface {
        int returnFixedNumber();
    }
}
