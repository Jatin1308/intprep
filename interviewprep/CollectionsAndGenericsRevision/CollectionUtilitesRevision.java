package CollectionsAndGenericsRevision;

import java.util.*;

class LengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
}
public class CollectionUtilitesRevision {
    public static void main(String[] args) {

        // cannot add new members but still change the existing ones
        List<String> cricketers = Arrays.asList("jatin batish", "shivam dhiman", "amrinder pannu", "anku batish");

        // sorting using alphabetically order
//        Collections.sort(cricketers);

        // custom sort based on length of name of cricketers
//        Collections.sort(cricketers, Comparator.comparingInt(String::length));
//        cricketers.forEach(System.out::println);
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // sorting in descending order
//        cricketers.sort(Collections.reverseOrder());
//        cricketers.forEach(System.out::println);
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


        // binary search -  for this method list should be sorted in ascending order
//        Collections.sort(cricketers);
//        int index = Collections.binarySearch(cricketers,"jatin batish");
//        System.out.println("Index: "+index);
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // reversing the list
//        Collections.reverse(cricketers);
//        cricketers.forEach(System.out::println);
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // shuffling the list
//        Collections.shuffle(cricketers);
//        cricketers.forEach(System.out::print);

        //swapping elements
//        cricketers.forEach(System.out::print);
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//        Collections.swap(cricketers,0,2);
//        cricketers.forEach(System.out::print);

        //Creating unmodifiable list
        List<String> unmodifiableList = Collections.unmodifiableList(cricketers);
//        unmodifiableList.add("123"); // giving compile time error
//        unmodifiableList.set(0,"abc"); // giving compile time error

        // Finding max and min by customer coparator
        String longestName = Collections.max(cricketers,Comparator.comparingInt(String::length));
        String shortestName = Collections.min(cricketers,Comparator.comparingInt(String::length));
        System.out.println(longestName+" :: "+shortestName);

    }
}
