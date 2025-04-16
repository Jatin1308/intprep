package Collections;

import java.util.*;

public class CollectionAndGenericsQuiz {

    public static void main(String[] args) {

//        Set<String> names = new HashSet<>();
//        names.add("Alice");
//        names.add("Bob");
//        names.add("alice");
//        System.out.println(names.size());

//        List<Integer> numbers = new ArrayList<>();
//        numbers.add(5);
//        numbers.add(2);
//        numbers.add(8);
//
//        Collections.sort(numbers,Collections.reverseOrder());
//        System.out.println(numbers);

//        List<? extends Number> list = new ArrayList<>();
//        list.add(10);

        Map<Integer, String> emp = new HashMap<>();

        emp.put(1,"jatin");
        emp.put(2,"ankit");

        emp.forEach((k,v) -> System.out.println(k+" "+v));
        emp.entrySet().forEach(l -> System.out.println(l));
        System.out.println(emp.entrySet());


    }
}
