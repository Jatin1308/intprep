package CollectionsAndGenerics;

import java.util.*;
/*
FailFast systems abort operation s fast as possible exposing failures immediately
and stopping the whole operation, they immedeately throw a ConcurentModificationException
These iterators diretly access the collection's data strucutre making them sensitive to modifiations
Example: ArrayList, HashSet, HashMap are Fail-Fast
 */

public class FailFast{
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3));

        for (Integer number : numbers) {
            numbers.add(50);
        }

//        while(iterator.hasNext()){
//            Integer number = iterator.next();
//            numbers.add(50);
//        }

    }
}