package Generics;

import java.util.List;

public class GenericsWildCard {


    public static void main(String[] args) {
        List<String> stringList = List.of("hello","bye","asjvnve","rjujvne");
        List<Integer> integerList = List.of(1,2,5,4,6,4);


        printWildCardList(stringList);
        System.out.println();
        printWildCardList(integerList);
        System.out.println();
        printList(stringList);
        System.out.println();
        printList(integerList);
    }

    // method to print elements of List<?>, less type safe
    public static void printWildCardList(List<?> list){
        for(Object item: list){
            System.out.print(item+" ");
        }
    }

    // method to print elements of List<T>
    public static <T> void printList(List<T> list){
        for(T item: list){
            System.out.print(item+" ");
        }
    }
}
