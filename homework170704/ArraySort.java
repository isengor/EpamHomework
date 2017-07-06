package homework170704;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Ilya on 04.07.2017.
 */
public class ArraySort {
    //(optional) отсортировать миллион целых чисел.  сравнить стандартный Arrays.sort и Radix

    public static int[] generateArray(int length) {

        int[] arr = new int[length];
        Random rnd = new Random();

        for (int i = 0; i < length; i++) {
            arr[i] = rnd.nextInt();
        }

        return arr;
    }

    public static void radixSort(int[] arr) {
        long start = System.nanoTime();

        int[] radix = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int indext = arr[i] - (arr[i] / 10) * 10;
            radix[indext] = arr[i];
        }
        System.out.println(Arrays.toString(radix));
        System.out.println("Radixsort runtime: "
                + (float) (System.nanoTime() - start) / 1000000
                + " ms.");
    }

    public static void quickSort(int[] arr) {
        long start = System.nanoTime();
        Arrays.sort(arr);
        System.out.println("Quicsort start: "
                + (float) (System.nanoTime() - start) / 1000000
                + " ms.");
    }
}
