package CollectionsAndGenerics;

/*
HashMap implements hash map data structure using reszable array of power of 2 size.
when adding an element the key's hashCode is calculated and its lower bits determine the array index(bucket)

hash collisions might occur when different keys produce same index.
in java's HashMap each bucket points to read-black tree(a linked list before java 8)

Initial Capacity:

Purpose: Sets the initial size of the internal array that stores the key-value pairs.

Default Value: 16.

Effect: If the specified initial capacity is not a power of two, it is adjusted to the
next power of two. For example, an initial capacity of 10 will be adjusted to 16.

Usage: Helps to minimize the number of resizings if the number of elements to be stored
is known in advance, improving performance.

Load Factor:

Purpose: Determines when to increase the size of the internal array to maintain performance.

Default Value: 0.75.

Effect: When the number of elements exceeds the product of the load factor and the current
capacity, the array size is doubled, and the elements are rehashed.

Usage: Balances time complexity of operations and space usage. A lower load factor
reduces the likelihood of collisions but increases memory usage, while a higher load
factor saves memory but may increase collisions and degrade performance.

 */

class Entry<K, V>{
    K key;
    V value;
    Entry<K,V> next;

    public Entry(K key, V value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

// MyHashMap.java
class MyHashMap<K,V> {
    private Entry<K, V>[] buckets;
    private static final int INITIAL_CAPACITY = 16;
    private int size = 0;

    public MyHashMap() {
        this.buckets = new Entry[INITIAL_CAPACITY];
    }

    // hash function to calculate the index for a given key
    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    // Add or update a key-value pair
    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        Entry<K, V> newEntry = new Entry<>(key, value);

        // If bucket is empty, add the new entry
        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = newEntry;
            size++;
        } else {
            // Traverse the bucket and update the value if key is found, otherwise append the new entry
            Entry<K, V> current = buckets[bucketIndex];
            Entry<K, V> previous = null;
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value; // Update value
                    return;
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry; // Append the new entry at the end
            size++;
        }
    }

    // Retrieve a value by key
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        Entry<K, V> current = buckets[bucketIndex];

        // Traverse the bucket to find the key
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null; // Key not found
    }

    // Remove key value pair by key
    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        Entry<K, V> current = buckets[bucketIndex];
        Entry<K, V> previous = null;

        // Traverse the bucket to find the key and remove the entry
        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    buckets[bucketIndex] = current.next; // Remove first entry in the bucket
                } else {
                    previous.next = current.next; // Bypass the entry to be removed
                }
                size--;
                return current.value;
            }
            previous = current;
            current = current.next;
        }
        return null; // Key not found
    }
    // Return the number of key-value pairs in the map
    public int size() {
        return size;
    }

    // Check if the map is empty
    public boolean isEmpty() {
        return size == 0;
    }
}

public class HashMapDeepDive {

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        // Add some key-value pairs
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        // Retrieve values
        System.out.println("Value for 'one': " + map.get("one")); // Output: 1
        System.out.println("Value for 'two': " + map.get("two")); // Output: 2

        // Remove a key-value pair
        System.out.println("Removed value for 'two': " + map.remove("two")); // Output: 2

        // Check size and content
        System.out.println("Size of map: " + map.size()); // Output: 2
        System.out.println("Value for 'two': " + map.get("two")); // Output: null

        // Check if map is empty
        System.out.println("Is map empty? " + map.isEmpty()); // Output: false

        // Remove all elements
        map.remove("one");
        map.remove("three");

        // Check if map is empty
        System.out.println("Is map empty? " + map.isEmpty()); // Output: true
    }
}
