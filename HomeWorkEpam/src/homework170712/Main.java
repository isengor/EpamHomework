package homework170712;

import mytestframework.Asserts;

/**
 * Created by Ilya on 12.07.2017.
 */
public class Main {
    public static void main(String[] args) {
        //TODO: CUSTOM STUCK - DONE

        StringStack stringStack = new StringStack();

        stringStack.push("heyho1");
        stringStack.push("heyho2");
        stringStack.push("heyho3");


        System.out.println(stringStack);
        System.out.println(Asserts.assertEquals(stringStack.peek(), "heyho3"));
        System.out.println(Asserts.assertEquals(stringStack.tos(), "heyho3"));

        System.out.println(Asserts.assertEquals(stringStack.pop(), "heyho3"));

        System.out.println(stringStack);

    }

}
