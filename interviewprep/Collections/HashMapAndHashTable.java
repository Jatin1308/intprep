package CollectionsAndGenerics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashMapAndHashTable {

    public static void main(String[] args) {

        Map<String, Integer> hashMap = new HashMap<>(); // -> not thread sagfe
        hashMap.put(null,null);

        Map<String,Integer> hashTable = new Hashtable<>(); // is thread safe but legacy
                                                            // user ConcurrentHashMap instead
        try {
            hashTable.put(null, null); // -> cannot add null to hashtable
        }catch(Exception e){
            System.out.println("Exception: "+e.getMessage()+", "+ Arrays.toString(e.getStackTrace()));
        }
    }
}
