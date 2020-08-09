package functional;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Carsten Gips
 */

class X {
    public static boolean four(int x) {
        return x > 4;
    }

    public static int cmp(String s1, String s2) {
        return s2.compareTo(s1);
    }

}

public class CollectionStreams {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action", "Manning", "Working", "with", "streams");
        List<Integer> wordLengths = words.stream()
            .sorted(X::cmp)
            .map(String::length)
            .filter(X::four)
            .sorted()
            .collect(toList());
        System.out.println(wordLengths);
    }

}
