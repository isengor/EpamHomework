package homework170823;

import java.util.HashMap;
import java.util.Map;

public class ForEachCounter {

    public static void count(String... words) {

        Map<String, Integer> map = new HashMap();

        for (String s : words
                ) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            }
            else {
                map.put(s, 1);
            }
        }

        map.forEach((s1, s2) -> System.out.println(s1 + " " + s2));
    }
}
