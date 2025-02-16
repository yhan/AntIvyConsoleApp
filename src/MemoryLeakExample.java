public class MemoryLeakExample {
    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        Object key = new Object();  // Assume this object should be collected later

        eventSource.registerListener(key, () -> System.out.println("Event received"));

//        // Later, we no longer reference `key`, but it's still in the HashMap
//        key = null;  // Removing reference

        eventSource.removeListener(key);

        //System.gc(); // Request GC (doesn't guarantee immediate cleanup)
        eventSource.notifyListeners(); // Listener still exists! (Memory Leak)
    }
}
