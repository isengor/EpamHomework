package homework170704;

/**
 * Created by Ilya on 04.07.2017.
 */
public class Main {
    public static void main(String[] args) {
        //
        //ArrayToString
        //////////////////////////
        int[] arr = {24, 22, 29, 14, 11, 12, 15, 13, 55, 89};
        System.out.println(ArrayToStr.getString(arr));

        //
        //diff between quicksort and radixsort(optional)
        //////////////////////////
        //ArraySort.quickSort(arr);
        ArraySort.radixSort(arr);
    }
}
