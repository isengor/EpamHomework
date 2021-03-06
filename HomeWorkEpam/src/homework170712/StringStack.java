package homework170712;

import java.util.Arrays;

/**
 * Created by Ilya on 12.07.2017.
 */
public class StringStack {

    //TODO: hometask: реализовать Stack на массиве с TDD

    private static final int DEFAULT_MAX_ZISE = 3;
    private String[] elements;
    private int size;


    public StringStack() {
        this(DEFAULT_MAX_ZISE);
    }

    public StringStack(int maxSize) {
        elements = new String[maxSize];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public boolean push(String one) {
        if (size >= elements.length) { //guard condition
            return false;
        }
        elements[size++] = one;
        return true;
    }

    public int size() {
        return size;
    }

    public String pop() {
        if (size <= 0) {           //guard condition
            return null;           //stack underflow
        }
        String result = elements[--size];
        elements[size] = null;
        return result;
    }

    public String peek() {
        if (size <= 0) {           //guard condition
            return null;           //stack underflow
        }
        String result = elements[size - 1];

        return result;
    }

    public String tos() {
        return size <= 0 ? null : elements[size - 1];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(elements, 0, size));
    }
}
