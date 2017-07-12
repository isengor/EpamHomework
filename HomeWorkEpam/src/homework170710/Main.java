package homework170710;

/**
 * Created by Ilya on 10.07.2017.
 */
public class Main {

    public static void main(String[] args) {
        StringLinkedList stringLinkedList = new StringLinkedList();

        stringLinkedList.add("one");
        stringLinkedList.add("two");
        stringLinkedList.add("three");
        stringLinkedList.add("four");
        stringLinkedList.add("five");


        // System.out.println(stringLinkedList.remove("four"));
        System.out.println(stringLinkedList.remove(0));
        System.out.println(stringLinkedList.remove(3));
        System.out.println(stringLinkedList);


    }
}
