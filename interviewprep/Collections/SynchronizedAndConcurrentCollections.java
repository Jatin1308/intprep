package CollectionsAndGenerics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/*
    both are used for multithreaded access to data structures

    SYNCHRONIZED COLLECTIONS
        provide basic thread safety by synchronizing the entire collection. this means that all methods that access
        or modify the collection are synchronized, which can lead to contention and reduced performance under high
        concurrency

        Key Points:
            1. implementation: created using: Collections.synchronized.*
            2. Synchro mechan: synchronized using intrinsic locks(synchronized keyword).
            3. performance:    synchronizing on entire collection can cause performance bottlenexks
            4. iteration:      Iterators must be used within a synchronized block to avoid Exception
            5. usecase:        suitable for low moderate concurrecny, and high performance is not critical


    CONCURRENT COLLECTIONS
        java.util.concurrent package and are for high concurrency.

        Key Points:
            1. implementation: ConcurrentHashMap, ConcurrentLinkedQueue,CopyOnWriteArrayList, etc.
            2. Synchro mechan: use sophisticated algo and non-blocking tech. eg: concurrenthashmap
                                uses a segmented locking technique and CopyOnWriteArrayList creates
                                a new copy of the underlying array on each write operation
            3. performance:     minimize lock contention and more efficient under heavy multithreaded access
            4. Iteration:      iterators are weakly consistent, meaning they can tolerate concurrent modifications.
                               without throwinf ConcurrentModifExc and may reflect some, all or none of the changes
                               made to collection after the iterator was created
            5. UseCase:        suitable for high concurrency scenarios where thread safety are perf are critical

 */
public class SynchronizedAndConcurrentCollections {

    public static void main(String[] args) {
        List<String> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        synchronizedList.add("one");
        synchronizedList.add("two");

        synchronized (synchronizedList){
            for (String item: synchronizedList){
                System.out.println(item);
            }
        }

        ConcurrentHashMap<String, String> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("one","1");
        concurrentMap.put("two","2");

        for (String key: concurrentMap.keySet()){
            System.out.println(key + " : "+concurrentMap.get(key));
        }
    }

}
