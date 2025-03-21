package CollectionsAndGenerics;

import java.util.LinkedList;

public class LinkedListExample {

    public static void main(String[] args) {

        // creates linked list
        LinkedList<String> ll = new LinkedList<>();
        ll.add("hello");
        ll.add("ok");
        ll.add("no");


        ll.addFirst("Added directly at first");
        ll.addLast("Added directly at last");

    }
}
