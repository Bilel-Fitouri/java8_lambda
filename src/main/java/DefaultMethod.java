/**
 * Created by bfitouri on 11/01/16.
 */
public class DefaultMethod {

    interface MyInterface {
        public void doSomeStuff();
        default public void doOtherStuff(String text){
            System.out.println(text);
        }
    }

    private class MyClass implements MyInterface {
        @Override
        public void doSomeStuff() {
            System.out.println("this is a test");
        }
    }

    private void apply(){
        MyInterface myInterface = this.new MyClass();
        myInterface.doSomeStuff();
        myInterface.doOtherStuff("this is a default method implemented in the interface!!!");
    }

    public static void main(String[] args) {
        DefaultMethod defaultMethod = new DefaultMethod();
        defaultMethod.apply();
    }
}
