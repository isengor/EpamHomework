package homework170629;

/**
 * Created by Ilya on 01.07.2017.
 */
public class Main {
    public static void main(String[] args) {
        byte[] data = DataGenerator.generate(1000);
        Genome.printDnaChain(data);
        Genome.countSequences(data, 4);
    }
}
