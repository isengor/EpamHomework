package homework170710;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Ilya on 10.07.2017.
 */
public class MyLinkedList {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        // list.remove(1);

        System.out.println(list.get(0));

        Hashtable table = new Hashtable();

        table.put(2, "dsdasad");
        table.put(3, 13);
        table.put(123, 5);
        System.out.println(table);


    }
}
