package Java9To23Features;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {
    public static void main(String[] args) {

        // convert array to stream

        // 1. primitive type array
        int[] arrayInt = {1,2,3,4,5};
        IntStream primStream = Arrays.stream(arrayInt);

        // 2. Object type array
        Integer[] arrayInteger = {7,8,9};
        Stream<Integer> objStream = Stream.of(arrayInteger);


    }
}
