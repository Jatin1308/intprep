package CollectionsAndGenerics;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
    CONCURRENTHASHMAP
     nd hashmap are implementations of Map interface.
    both are for different use cases especially when it comes to handling concurrent access

    concurrency level: divides the map into segments or buckets. Each segment is a smaller independently
                        synchronized map, allowing multiple threads to access different segments concurrently
                        without contention
    Locking mechanism: instead of locking the entire map, it locks only the specific segment that a key
                        belong to. the fine-grained locking mechanism significantly improves performance in
                        multithreaded environments.
    No Locking on read:
    Performance: its better than HashMap when synchronized externally due to its advanced locking mechanism.


    HASHMAP
        external synchronization is needed, in single threaded env hashmap is faster due to lack of synch overhead

 */
public class ConcurrentHashMapExample {

    public static void main(String[] args) {

        Map<String, Integer> map = new ConcurrentHashMap<>();

        map.put("one",1);
        map.put("two",2);
        map.put("three",3);

        map.forEach((key,value) -> {
            key = key + "concatenated";
            value = value *2;
            System.out.println(key+" : "+value);

        });

        map.computeIfAbsent("four",k -> 4);
        System.out.println("new Value: "+map.get("four"));
    }

}
