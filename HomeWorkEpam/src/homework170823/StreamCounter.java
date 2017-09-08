package homework170823;

import java.util.Arrays;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class StreamCounter {

    public static void count(String... words) {

        Arrays.stream(words).collect(groupingBy(s -> s, counting())).forEach((s1, s2) -> System.out.println(s1 + " " + s2));

    }
}
