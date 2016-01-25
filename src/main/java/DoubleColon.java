import java.lang.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bfitouri on 11/01/16.
 */
public class DoubleColon {

    @java.lang.FunctionalInterface
    interface MyInterface {
        void display(String text);
    }

    DoubleColon(){}

    DoubleColon(String text){
        System.out.println("Constructor called with text : " + text);
    }

    public void body(String text){
        System.out.println("method body called with text : " + text);
    }

    public static void staticbody(String text){
        System.out.println("static method body called with text : " + text);
    }

    public static void main(String[] args) {
        MyInterface i1 = DoubleColon::staticbody;
        i1.display("hello");

        MyInterface i2 = DoubleColon::new;
        i2.display("it's me again");

        DoubleColon dc = new DoubleColon();
        MyInterface i3 = dc::body;
        i3.display("me once again !!");

        List<String> list = Arrays.asList("a", "b", "c");
        list.forEach(s -> DoubleColon.staticbody(s));
        //or
        list.forEach(DoubleColon::staticbody);

    }

}
