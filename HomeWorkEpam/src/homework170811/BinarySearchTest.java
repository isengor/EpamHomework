package homework170811;

import java.util.*;

public class BinarySearchTest {
    /*
    BinarySearchExample
    сравнить три варианта: с LinkedList, ArrayList  и TreeSet
    1) добавить 1000000 элементов
    2) отсортировать
    3) сделать двоичный поиск
    4) генератор случайных чисел тоже сделать до 1000000
    5) сделать замеры времени для пунктов 1-3 (каждого отдельно)
    6) сравнить общее время выполнения

    BinarySearch algorithm:
сделать возврат отрицательного числа,
указывающего на место, которое должен
занимать отсутствующий элемент в массиве
     */

    public static int VALUE = 1000000;

    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList();
        List<Integer> arrayList = new ArrayList();

        Set<Integer> treeSet = new TreeSet();

        addRandomElements(linkedList, VALUE);
        addRandomElements(arrayList, VALUE);
        addRandomElements(treeSet, VALUE);

        System.out.println();

        sort(linkedList);
        sort(arrayList);

        System.out.println();

        binarySearch(linkedList, 28);
        binarySearch(arrayList, 28);

        System.out.println(arrayList.get(25));

    }

    public static void addRandomElements(Collection<Integer> collection, int count) {
        Random rnd = new Random();
        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            collection.add(rnd.nextInt(VALUE));
        }

        System.out.println(collection.getClass() + " addElemnts time elapsed: " + (System.currentTimeMillis() - start));
    }


    //for list only, because treeSet already sorted
    public static void sort(List<Integer> list) {
        long start = System.currentTimeMillis();
        Collections.sort(list);
        System.out.println(list.getClass() + " sort time elapsed " + (System.currentTimeMillis() - start));
    }


    //for list only, because no idea about binarysearch for trees
    public static void binarySearch(List<Integer> list, int value) {
        long start = System.currentTimeMillis();

        int index = Collections.binarySearch(list, value);

        System.out.println(list.getClass() + " binarySearch time elapsed " +
                (System.currentTimeMillis() - start) +
                " keyIndex = " + index);

    }

}
