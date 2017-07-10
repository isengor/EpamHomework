package homework170707;

import java.util.Arrays;

/**
 * Created by Ilya on 09.07.2017.
 */
public class StringArrayList {

    //Доделать класс StringArrayList:   добавить методы get, set, size, isEmpty, remove(value), toString (переписать)

    static final int DEFAULT_SIZE = 2;

    private String[] elements = new String[DEFAULT_SIZE];

    //  [a,b,c,d,e,f]
    //   0 1 2 3 4 5

    private int size = 0;

    public void add(String string) {

        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }

        elements[size++] = string;
//		size = size + 1;
    }

    public String get(int index) {
        return elements[index];
    }

    public void set(int index, String s) {
        elements[index] = s;
    }

    public boolean isEmpty() {
        boolean b = true;
        for (Object o : elements) {
            if (o != null) {
                b = false;
                break;
            }
        }

        return b;
    }

    @Override
    public String toString() {
        String s = "[";

        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                s += elements[i];

                if (i < size - 1) {
                    s += ", ";
                }
            }
        }

        return s + "]";
    }

    //  [a,b,c,d,e,_]
    //   0 1 2 3 4 5
    //  [a,b,d,e,_,_]
    //   0 1 2 3 4

    public void remove(int i) {
        if (i >= size || i < 0) {
            return;
        }

        System.arraycopy(elements, i + 1, elements, i, --size - i);
        elements[size] = null;

    }

    public int size() {
        return size;
    }


}
