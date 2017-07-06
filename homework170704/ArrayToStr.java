package homework170704;

/**
 * Created by Ilya on 05.07.2017.
 */
public class ArrayToStr {
    public static String getString(int[] arr) {
        String s = "[";

        for (int i = 0; i < arr.length; i++) {
            s += arr[i];

            if (i != arr.length - 1) {
                s += ", ";
            }
        }

        return s + "]";
    }
}
