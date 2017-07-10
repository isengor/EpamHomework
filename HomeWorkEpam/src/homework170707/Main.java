package homework170707;

/**
 * Created by Ilya on 07.07.2017.
 */
public class Main {
    public static void main(String[] args) {

        //MyString.trim();
        ///////////////////
        String s = "  sds sd    ";
        System.out.println(MyString.trim(s));

        //MyString.replace();
        ///////////////////
        System.out.println(MyString.replace(s, 's', 'g'));

        //StringArrayList
        ///////////////////
        StringArrayList stringArrayList = new StringArrayList();
        stringArrayList.add("one");
        stringArrayList.add("two");
        stringArrayList.add("three");
        stringArrayList.add("three");
        stringArrayList.add("one");
        stringArrayList.add("one");
        stringArrayList.add("one");

        System.out.println(stringArrayList);
        System.out.println(stringArrayList.size());
        System.out.println(stringArrayList.isEmpty());
        System.out.println(stringArrayList.get(3));

        stringArrayList.set(3, "heyho");
        System.out.println(stringArrayList.get(3));
    }
}
