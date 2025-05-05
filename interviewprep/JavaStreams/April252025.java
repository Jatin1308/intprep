package JavaStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class April252025 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // Write your code here

        List<Integer> squares = numbers.stream()
                .map(n -> n*n)
                .toList();
        System.out.println(squares);


        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eva");
        int lengthOfLongestName = names.stream()
                .map(String::length)
                .max(Integer::compare)
                .get();

        System.out.println(lengthOfLongestName);


        List<String> sentences = Arrays.asList(
                "Java Stream API provides a fluent interface for processing sequences of elements.",
                "It supports functional-style operations on streams of elements, such as map-reduce transformations.",
                "In this exercise, you need to count the total number of words in all sentences."
        );

        long distinctElements = sentences.stream()
                .flatMap(e -> Arrays.stream(e.split(" ")))
                .distinct()
                .count();
        System.out.println(distinctElements);


        // find concatenation of first 2 words with equal length and length even
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        String concatenationOfEvenWordsWithEqualLength = words.stream()
                .filter(e -> e.length()%2 == 0)
                .limit(2)
                .collect(Collectors.joining());

        System.out.println(concatenationOfEvenWordsWithEqualLength);

        // sum of squares of even number
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sumOfEvenSquares = numberList.stream()
                .filter(n -> n%2 == 0)
                .mapToInt(n -> n*n)
                .sum();
        System.out.println(sumOfEvenSquares);



    }
}