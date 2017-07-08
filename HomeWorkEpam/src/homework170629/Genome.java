package homework170629;

/**
 * Created by Ilya on 30.06.2017.
 */
public class Genome {
    //Найти все повторяющиеся последовательности определенной длины.
    //Длина передается в качестве параметра. Решить задачу нужно вложенными циклами.

    public static void printDnaChain(byte[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print((char) data[i]);
        }
        System.out.println();
    }

    public static void countSequences(byte[] data, int sequenceLength) {
        int counter = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length - sequenceLength + 1; j++) {
                boolean found = true;

                for (int l = 0; l < sequenceLength; l++) {
                    if (data[i + l] != data[j + l]) {
                        found = false;
                        break;
                    }
                }

                if (found) {
                    counter++;

                    //System.out.println("Yey");
                }
            }

        }

        System.out.println("Yo! " + counter + " sequences found!");
    }
}
