package homework170809;

public class Main {

    public static void main(String[] args) {

        Dictionary<String, String> dictionary = new Dictionary<>();

        putTest(dictionary, 1000);

        dictionary = new Dictionary<>();

        putTest(dictionary, 10000);

        dictionary = new Dictionary<>();

        putTest(dictionary, 100000);
    }

    public static void putTest(Dictionary d, int quantity) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < quantity; i++) {
            d.put("key" + i, "value" + i);
        }

        System.out.println("Elapsed: " + (System.currentTimeMillis() - start));

    }
}
