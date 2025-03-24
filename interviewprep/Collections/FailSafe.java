package CollectionsAndGenerics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class FailSafe{
    public static void main(String[] args) {

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>(Arrays.asList("a","b","c"));

        Iterator<String> iterator = list.iterator();

        while(iterator.hasNext()){
            if(iterator.next().equals("b")){
                list.remove("b");
            }
        }

        System.out.println(list);

    }
}