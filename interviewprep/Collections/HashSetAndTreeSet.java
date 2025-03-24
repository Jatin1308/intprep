package CollectionsAndGenerics;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetAndTreeSet {

    public static void main(String[] args) {

        /*
            HashSet:  uses hashtable to store elements, relies on hahsing for its operations
            meaning it uses the hashCode method t determine the storage location of elements
            O(1) avg timecomp for add,remove,and contains operations, no order is maintained
            usecase: when need fastlookups and do not care about order

            TreeSet: uses Red-Black Tree(self balancing BST)
            Timecompl: O(log n) for add , remove, and contains operations

            Ordering: Maintains elements in sorted order
            UseCase:  suitable when you need to maintain a sorted order of elements
         */


        Set<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("bananas");
        hashSet.add("cherry");
        System.out.println("Contains Apple: "+hashSet.contains("Apple"));


        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Apple");
        treeSet.add("bananas");
        treeSet.add("cherry");


    }
}
