package homework170809;

public class Main {

    public static void main(String[] args) {

        Dictionary<String, String> dictionary = new Dictionary<>();

        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {

            dictionary.put("key" + i, "value" + i);

        }

        System.out.println("Elapsed: " + (System.currentTimeMillis() - start));


        dictionary = new Dictionary<>();

        start = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {

            dictionary.put("key" + i, "value" + i);

        }

        System.out.println("Elapsed: " + (System.currentTimeMillis() - start));

        dictionary = new Dictionary<>();

        start = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {

            dictionary.put("key" + i, "value" + i);

        }

        System.out.println("Elapsed: " + (System.currentTimeMillis() - start));

    }
}
