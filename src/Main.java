import java.util.Map;
import java.util.WeakHashMap;

public class Main {
    public static void main(String[] args) {

        Map<Object, String> map = new WeakHashMap<>();

        Object key1 = new Object(); // Strong reference
        Object key2 = new Object(); // Strong reference

        map.put(key1, "Value 1");
        map.put(key2, "Value 2");

        System.out.println("Before GC: " + map);

        key1 = null; // Remove strong reference to key1
        System.gc(); // Request garbage collection

        // Give some time for GC to collect weak references
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}

        System.out.println("After GC: " + map); // key1 should be removed
    }
}
