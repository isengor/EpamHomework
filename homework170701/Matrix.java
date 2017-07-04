package homework170701;

/**
 * Created by Ilya on 02.07.2017.
 */
public class Matrix {

//    Написать метод, печатающий сумму элементов в ряду 2D матрицы,
//    но только если в этом ряду нет отрицательных чисел

    public static int rowSum(int[][] matrix, int row) {
        int sum = 0;

        for (int i = 0; i < matrix[row].length; i++) {
            if (matrix[row][i] > 0) {
                sum += matrix[row][i];
            }
            else {
                return -1;
            }
        }

        return sum;
    }

}
