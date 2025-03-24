package CollectionsAndGenerics;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {

        List<String> arrayList = new ArrayList<>();
        arrayList.add("apple");
        arrayList.add("banana");
        arrayList.add("cherry");

        System.out.println("Element at index 1: "+arrayList.get(1));

        System.out.println("Elements: ");
        for(String fruit: arrayList){
            System.out.println(fruit);
        }

        // remove element:
        arrayList.remove(1);
        System.out.println("After removal");
        for(String fruit: arrayList){
            System.out.println(fruit);
        }

    }
}
