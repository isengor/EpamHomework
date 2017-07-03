package homework170701;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ilya on 02.07.2017.
 */
public class Main {

    public static void main(String[] args) {

        //
        //2d matrix
        /////////////////

        int[][] matrix = {
                {2, 32, 123},
                {12, -5, 23},
                {9, 12, 44},
        };

        System.out.println(Matrix.rowSum(matrix, 0));
        System.out.println(Matrix.rowSum(matrix, 1));
        System.out.println(Matrix.rowSum(matrix, 2));


        //
        //Genome, sort/hash
        //////////////////////////

        byte[] data = DataGenerator.generate(GenomeWithSort.GENOME_SIZE);

        List<GenomeWithSort.Word> list = new ArrayList<>();

        for (int i = 0; i < data.length - GenomeWithSort.WORD_SIZE; i++) {
            list.add(new GenomeWithSort.Word(data, i));
        }

        Collections.sort(list);

        for (GenomeWithSort.Word word : list) {
            byte[] wordBytes = Arrays.copyOfRange(data, word.offset,
                    word.offset + GenomeWithSort.WORD_SIZE);
            System.out.println(Arrays.toString(wordBytes));
        }

    }
}
