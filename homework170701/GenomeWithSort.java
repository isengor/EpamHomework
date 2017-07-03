package homework170701;

/**
 * Created by Ilya on 02.07.2017.
 */
public class GenomeWithSort {

    public static final int GENOME_SIZE = 300000;
    public static final int WORD_SIZE = 4;

    static class Word implements Comparable<Word> {
        byte[] data;
        int offset;

        public Word(byte[] data, int i) {
            this.data = data;
            offset = i;
        }

        @Override
        public int compareTo(Word otherWord) {
            for (int i = 0; i < WORD_SIZE; i++) {
                int diff = data[offset + i] - data[otherWord.offset + i];
                if (diff != 0) {
                    return diff;
                }
            }
            return 0;
        }
    }
}
