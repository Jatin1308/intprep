package Generics;

import java.util.List;

public class GenericsBoundingParamaters {
    public static void main(String[] args) {

        List<Integer> intList = List.of(4,8,2,10,6);
        findMax(intList);

        // Now in future i want to make the same method work with Double, i will change T extends Number & Comparable
        List<Double> doubleList = List.of(4.1,8.2,2.3,100.3,698.8);
//        findMax(doubleList); // -> compile time error



    }


    // this will not allow compareTo method, as we need to restrict the type
    // below we had mentioned, T is subclass of Integer
//    public static <T> void findMax(List<T> list){
//    public static <T extends Integer> void findMax(List<T> list){
    public static <T extends Number & Comparable> void findMax(List<T> list){
        if(list == null || list.isEmpty()){
            throw new IllegalArgumentException("List cannot be null or empty");
        }

        T max = list.get(0);
        for(int i=1; i<list.size();i++){
            T currentEle = list.get(i);
            // compareTo method belongs to Comparable Interface
            if(currentEle.compareTo(max)>0){
                max=currentEle;
            }
        }
        System.out.println(max);
    }
}
