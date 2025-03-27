package lru;

public class LinkedHashMapLRUExample {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        cache.get(1); // Access 1, making it recently used
        cache.put(4, "D"); // Removes 2 (Least Recently Used)

        System.out.println(cache); // Output: {3=C, 1=A, 4=D}
    }

}
