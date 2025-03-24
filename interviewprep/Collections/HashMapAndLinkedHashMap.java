package CollectionsAndGenerics;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
Hashmap:
Order of Entries: HashMap does not maintain any order of its entries. The order of elements can change over time, especially when rehashing occurs after resizing the map.
Performance: HashMap generally provides constant-time performance for the basic operations (get and put), assuming the hash function disperses the elements properly among the buckets.
Internal Structure: HashMap uses a hash table to store the map entries. Each entry is stored in a bucket which is determined by the hash code of the key.
Use Cases: Suitable for general-purpose use where the order of the entries is not important

LinkedHashmap:
Order of Entries: LinkedHashMap maintains a doubly-linked list running through all of its entries. This allows it to maintain the order in which keys were inserted (insertion-order).
Performance: LinkedHashMap has a slightly lower performance compared to HashMap due to the overhead of maintaining the linked list. However, it still provides constant-time performance for basic operations, assuming the hash function disperses the elements properly.
Internal Structure: Like HashMap, LinkedHashMap uses a hash table to store the map entries. Additionally, each entry maintains pointers to the next and previous entries in the doubly-linked list.
Use Cases: Suitable when you need to maintain the insertion order of the elements.

 */
public class HashMapAndLinkedHashMap {
    public static void main(String[] args) {
        Map<String, Integer> countMap = new HashMap<>();
        String name = "jatin batish";
        String[] arrOfName = name.split(" ");
        for (String c: arrOfName) {
            countMap.merge(c, 1, Integer::sum);
        }
        System.out.println(countMap+"-"+countMap.getClass());


        Map<String,Integer> linkedMap = new LinkedHashMap<>();
        linkedMap.put("one",1);
        linkedMap.put("two",2);
        linkedMap.put("three",3);
        linkedMap.put("four",4);

        for(Map.Entry<String,Integer> entry: linkedMap.entrySet()){
            System.out.println(entry);
        }

        // accessing element to check if order is maintained
        System.out.println(linkedMap.get("two"));


        // using LinkedHashMap with access-order enabled (for LRU caching)

        Map<String,Integer> accessOrderMap = new LinkedHashMap<>(16,0.75f,true);

        accessOrderMap.put("one",1);
        accessOrderMap.put("two",2);
        accessOrderMap.put("three",3);
        accessOrderMap.put("four",4);

        // accessing some elements
        System.out.println(accessOrderMap.get("one"));
        System.out.println(accessOrderMap.get("two"));


        // printing after access to show LRU order (least recently used to goes to end)
        System.out.println("LinkedHashMap with access order: "+accessOrderMap);

    }

}
